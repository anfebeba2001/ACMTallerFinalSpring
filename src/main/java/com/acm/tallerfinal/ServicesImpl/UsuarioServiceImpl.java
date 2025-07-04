package com.acm.tallerfinal.ServicesImpl;

import com.acm.tallerfinal.Exceptions.ResourceNotFoundException;
import com.acm.tallerfinal.Mappers.UsuarioMapper;
import com.acm.tallerfinal.Services.IUsuarioService;
import com.acm.tallerfinal.dtos.UsuarioCreacionDTO;
import com.acm.tallerfinal.dtos.UsuarioDTO;
import com.acm.tallerfinal.entity.Ciudad;
import com.acm.tallerfinal.entity.RolUsuario;
import com.acm.tallerfinal.entity.Usuario;
import com.acm.tallerfinal.repository.CiudadRepository;
import com.acm.tallerfinal.repository.RolUsuarioRepository;
import com.acm.tallerfinal.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioRepository rolUsuarioRepository;
    private final CiudadRepository ciudadRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolUsuarioRepository rolUsuarioRepository, CiudadRepository ciudadRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolUsuarioRepository = rolUsuarioRepository;
        this.ciudadRepository = ciudadRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO obtenerUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    @Transactional
    public UsuarioDTO crearUsuario(UsuarioCreacionDTO usuarioCreacionDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioCreacionDTO);

        usuario.setPassword(passwordEncoder.encode(usuarioCreacionDTO.getPassword()));

        RolUsuario rol = rolUsuarioRepository.findById(usuarioCreacionDTO.getIdRol())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + usuarioCreacionDTO.getIdRol()));
        Ciudad ciudad = ciudadRepository.findById(usuarioCreacionDTO.getIdCiudad())
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad no encontrada con ID: " + usuarioCreacionDTO.getIdCiudad()));

        usuario.setRol(rol);
        usuario.setCiudad(ciudad);
        usuario.setFechaRegistro(LocalDateTime.now());

        // Guardar y devolver DTO
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }
}