package com.acm.tallerfinal.controllers;

import com.acm.tallerfinal.Services.IUsuarioService;
import com.acm.tallerfinal.dtos.AuthRequestDTO;
import com.acm.tallerfinal.dtos.AuthResponseDTO;
import com.acm.tallerfinal.dtos.UsuarioCreacionDTO;
import com.acm.tallerfinal.dtos.UsuarioDTO;
import com.acm.tallerfinal.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final IUsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, IUsuarioService usuarioService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@Valid @RequestBody UsuarioCreacionDTO usuarioCreacionDTO) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuarioCreacionDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDTO.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}