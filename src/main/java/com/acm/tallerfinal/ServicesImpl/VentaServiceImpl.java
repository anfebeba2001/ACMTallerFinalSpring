package com.acm.tallerfinal.ServicesImpl;

import com.acm.tallerfinal.Exceptions.ResourceNotFoundException;
import com.acm.tallerfinal.Exceptions.StockInsuficienteException;
import com.acm.tallerfinal.Mappers.VentaMapper;
import com.acm.tallerfinal.Services.IVentaService;
import com.acm.tallerfinal.dtos.ItemVentaDTO;
import com.acm.tallerfinal.dtos.VentaCreacionDTO;
import com.acm.tallerfinal.dtos.VentaRespuestaDTO;
import com.acm.tallerfinal.entity.*;
import com.acm.tallerfinal.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    private final VentaRepository ventaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;
    private final AlmacenProductoRepository almacenProductoRepository;
    private final VentaProductoRepository ventaProductoRepository;
    private final AlmacenRepository almacenRepository;
    private final VentaMapper ventaMapper;

    public VentaServiceImpl(VentaRepository ventaRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository, AlmacenProductoRepository almacenProductoRepository, VentaProductoRepository ventaProductoRepository, AlmacenRepository almacenRepository, VentaMapper ventaMapper) {
        this.ventaRepository = ventaRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
        this.almacenProductoRepository = almacenProductoRepository;
        this.ventaProductoRepository = ventaProductoRepository;
        this.almacenRepository = almacenRepository;
        this.ventaMapper = ventaMapper;
    }


    @Override
    @Transactional
    public VentaRespuestaDTO registrarVenta(VentaCreacionDTO ventaCreacionDTO) {
        Usuario cliente = usuarioRepository.findById(ventaCreacionDTO.getIdCliente())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + ventaCreacionDTO.getIdCliente()));

        Almacen almacenPrincipal = almacenRepository.findById(1)
                .orElseThrow(() -> new IllegalStateException("El almacén principal con ID 1 no existe"));

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFechaVenta(LocalDateTime.now());
        venta.setTotal(0L);
        Venta ventaGuardada = ventaRepository.save(venta);

        BigDecimal totalVenta = BigDecimal.ZERO;
        List<VentaProducto> detallesVenta = new ArrayList<>();

        for (ItemVentaDTO item : ventaCreacionDTO.getItems()) {
            Producto producto = productoRepository.findById(item.getIdProducto())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + item.getIdProducto()));

            AlmacenProducto inventario = almacenProductoRepository.findByAlmacenAndProducto(almacenPrincipal, producto)
                    .orElseThrow(() -> new StockInsuficienteException("No hay registro de stock para el producto: " + producto.getNombre()));

            if (inventario.getStock() < item.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre() + ". Stock actual: " + inventario.getStock());
            }

            inventario.setStock(inventario.getStock() - item.getCantidad());
            almacenProductoRepository.save(inventario);

            VentaProducto ventaProducto = new VentaProducto();
            ventaProducto.setVenta(ventaGuardada);
            ventaProducto.setProducto(producto);
            ventaProducto.setCantidad(item.getCantidad());
            detallesVenta.add(ventaProductoRepository.save(ventaProducto));

            totalVenta = totalVenta.add(producto.getPrecio().multiply(new BigDecimal(item.getCantidad())));
        }

        ventaGuardada.setTotal(totalVenta.longValue());
        Venta ventaFinal = ventaRepository.save(ventaGuardada);

        VentaRespuestaDTO respuesta = ventaMapper.toDto(ventaFinal);
        respuesta.setTotal(totalVenta);

        return respuesta;
    }
}