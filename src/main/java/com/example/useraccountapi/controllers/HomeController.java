package com.example.useraccountapi.controllers;

import com.example.useraccountapi.entities.Usuario;
import com.example.useraccountapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RestTemplate usuarioRestTemplate;



    @GetMapping("/prueba/{id}")
    public Object getApi(@PathVariable Integer id){

        String url="http://localhost:9000/buscarUsuario/"+id;
        return usuarioRestTemplate.getForObject(url,Object.class);
    }

    @GetMapping("/buscarUsuario/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable Integer id) {
        Optional<Usuario> userId = usuarioService.buscarUsuario(id);
        return userId;
    }

    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail());
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
