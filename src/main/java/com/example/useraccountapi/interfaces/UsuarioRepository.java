package com.example.useraccountapi.interfaces;

import com.example.useraccountapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
