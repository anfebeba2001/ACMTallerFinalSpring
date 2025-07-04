package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.VentaDetalleDTO;
import com.acm.tallerfinal.dtos.VentaRespuestaDTO;
import com.acm.tallerfinal.entity.Venta;
import com.acm.tallerfinal.entity.VentaProducto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    @Mapping(source = "ventaProductos", target = "detalle")
    @Mapping(source = "cliente.username", target = "clienteUsername")
    @Mapping(target = "total", ignore = true)
    VentaRespuestaDTO toDto(Venta venta);

    @Mapping(source = "producto.idProducto", target = "idProducto")
    @Mapping(source = "producto.nombre", target = "nombreProducto")
    @Mapping(source = "producto.precio", target = "precioUnitario")
    @Mapping(target = "subtotal", ignore = true)
    VentaDetalleDTO ventaProductoToVentaDetalleDTO(VentaProducto ventaProducto);

    List<VentaDetalleDTO> toDetalleDtoList(List<VentaProducto> ventaProductos);


    @AfterMapping
    default void calcularSubtotal(VentaProducto ventaProducto, @MappingTarget VentaDetalleDTO dto) {
        if (dto.getPrecioUnitario() != null && dto.getCantidad() != null) {
            BigDecimal subtotal = dto.getPrecioUnitario().multiply(new BigDecimal(dto.getCantidad()));
            dto.setSubtotal(subtotal);
        }
    }

    @AfterMapping
    default void calcularTotal(Venta venta, @MappingTarget VentaRespuestaDTO dto) {
        if (dto.getDetalle() != null) {
            BigDecimal total = dto.getDetalle().stream()
                    .map(VentaDetalleDTO::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            dto.setTotal(total);
        }
    }
}