package com.acm.tallerfinal.repository;

import com.acm.tallerfinal.entity.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}