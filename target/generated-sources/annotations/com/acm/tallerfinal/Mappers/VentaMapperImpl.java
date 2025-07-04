package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.VentaDetalleDTO;
import com.acm.tallerfinal.dtos.VentaRespuestaDTO;
import com.acm.tallerfinal.entity.Producto;
import com.acm.tallerfinal.entity.Usuario;
import com.acm.tallerfinal.entity.Venta;
import com.acm.tallerfinal.entity.VentaProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class VentaMapperImpl implements VentaMapper {

    @Override
    public VentaRespuestaDTO toDto(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        VentaRespuestaDTO ventaRespuestaDTO = new VentaRespuestaDTO();

        ventaRespuestaDTO.setDetalle( toDetalleDtoList( venta.getVentaProductos() ) );
        ventaRespuestaDTO.setClienteUsername( ventaClienteUsername( venta ) );
        ventaRespuestaDTO.setIdVenta( venta.getIdVenta() );
        ventaRespuestaDTO.setFechaVenta( venta.getFechaVenta() );

        calcularTotal( venta, ventaRespuestaDTO );

        return ventaRespuestaDTO;
    }

    @Override
    public VentaDetalleDTO ventaProductoToVentaDetalleDTO(VentaProducto ventaProducto) {
        if ( ventaProducto == null ) {
            return null;
        }

        VentaDetalleDTO ventaDetalleDTO = new VentaDetalleDTO();

        ventaDetalleDTO.setIdProducto( ventaProductoProductoIdProducto( ventaProducto ) );
        ventaDetalleDTO.setNombreProducto( ventaProductoProductoNombre( ventaProducto ) );
        ventaDetalleDTO.setPrecioUnitario( ventaProductoProductoPrecio( ventaProducto ) );
        ventaDetalleDTO.setCantidad( ventaProducto.getCantidad() );

        calcularSubtotal( ventaProducto, ventaDetalleDTO );

        return ventaDetalleDTO;
    }

    @Override
    public List<VentaDetalleDTO> toDetalleDtoList(List<VentaProducto> ventaProductos) {
        if ( ventaProductos == null ) {
            return null;
        }

        List<VentaDetalleDTO> list = new ArrayList<VentaDetalleDTO>( ventaProductos.size() );
        for ( VentaProducto ventaProducto : ventaProductos ) {
            list.add( ventaProductoToVentaDetalleDTO( ventaProducto ) );
        }

        return list;
    }

    private String ventaClienteUsername(Venta venta) {
        if ( venta == null ) {
            return null;
        }
        Usuario cliente = venta.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String username = cliente.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private Integer ventaProductoProductoIdProducto(VentaProducto ventaProducto) {
        if ( ventaProducto == null ) {
            return null;
        }
        Producto producto = ventaProducto.getProducto();
        if ( producto == null ) {
            return null;
        }
        Integer idProducto = producto.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    private String ventaProductoProductoNombre(VentaProducto ventaProducto) {
        if ( ventaProducto == null ) {
            return null;
        }
        Producto producto = ventaProducto.getProducto();
        if ( producto == null ) {
            return null;
        }
        String nombre = producto.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private BigDecimal ventaProductoProductoPrecio(VentaProducto ventaProducto) {
        if ( ventaProducto == null ) {
            return null;
        }
        Producto producto = ventaProducto.getProducto();
        if ( producto == null ) {
            return null;
        }
        BigDecimal precio = producto.getPrecio();
        if ( precio == null ) {
            return null;
        }
        return precio;
    }
}
