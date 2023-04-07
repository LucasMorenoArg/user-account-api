package com.example.useraccountapi.controllers;

import com.example.useraccountapi.entities.Usuario;
import com.example.useraccountapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail());
    }

    @PostMapping("/buscarUsuario")
    public Optional<Usuario> buscarUsuario(@RequestBody Usuario usuario) {

        Optional<Usuario> userId = usuarioService.buscarUsuario(usuario.getIdUsuario());

        return userId;
    }

    @PostMapping("/modificarUsuario")
    public void actualizar(@RequestBody Usuario usuario) {
        usuarioService.modificarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getIdUsuario());
    }

    @PostMapping("/borrarUsuario")
    public String borrar(@RequestBody Usuario usuario) {
        usuarioService.borrarUsuario(usuario.getIdUsuario());
        return "Registro eliminado correctamente";
    }
}
