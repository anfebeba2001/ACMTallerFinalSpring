package com.acm.tallerfinal.Services;

import com.acm.tallerfinal.dtos.UsuarioCreacionDTO;
import com.acm.tallerfinal.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuario(Integer id);
    UsuarioDTO crearUsuario(UsuarioCreacionDTO usuarioCreacionDTO);
}