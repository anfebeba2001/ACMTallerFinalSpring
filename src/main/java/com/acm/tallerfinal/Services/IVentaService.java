package com.acm.tallerfinal.Services;

import com.acm.tallerfinal.dtos.VentaCreacionDTO;
import com.acm.tallerfinal.dtos.VentaRespuestaDTO;

public interface IVentaService {
    VentaRespuestaDTO registrarVenta(VentaCreacionDTO ventaCreacionDTO);
}