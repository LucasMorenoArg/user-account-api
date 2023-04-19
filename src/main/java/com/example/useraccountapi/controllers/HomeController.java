package com.example.useraccountapi.controllers;

import com.example.useraccountapi.entities.Deuda;
import com.example.useraccountapi.entities.Usuario;
import com.example.useraccountapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    @Qualifier("clienteRest")
    private RestTemplate petisoTemplate;


    @GetMapping("/prueba/{id}")
    public Deuda getApi(@PathVariable Integer id) {
        String url="http://localhost:9000/buscarDeuda/"+id;
        return petisoTemplate.getForObject(url, Deuda.class);
    }

    @GetMapping("/prueba2/{id}")
    public Integer prueba(@PathVariable Integer id){
        String url="http://localhost:9000/numero/"+id;
       Integer mensajeNum= petisoTemplate.getForObject(url,Integer.class);
        System.out.println(mensajeNum);
       return mensajeNum;
    }

    @GetMapping("/buscar_usuario/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable Integer id) {
        Optional<Usuario> userId = usuarioService.buscarUsuario(id);
        return userId;
    }

    @PostMapping("/crear_usuario")
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail());
    }

    @PostMapping("/modificar_usuario")
    public void actualizar(@RequestBody Usuario usuario) {
        usuarioService.modificarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getIdUsuario());
    }

    @PostMapping("/borrar_usuario")
    public String borrar(@RequestBody Usuario usuario) {
        usuarioService.borrarUsuario(usuario.getIdUsuario());
        return "Registro eliminado correctamente";
    }

    @PostMapping("/crear_deuda")
    public String crearDeuda(@RequestBody Deuda deuda) {
        String url = "http://localhost:9000/crearDeuda";
        String respuesta = petisoTemplate.postForObject(url, deuda, String.class);
        System.out.println(respuesta);
        return respuesta;
    }

    @PostMapping("/prueba_post")
    public String pruebaPost(@RequestBody Map<String,String> nombre){
        String url = "http://localhost:9000/prueba_post";
        String respuesta=petisoTemplate.postForObject(url,nombre,String.class);
        return respuesta;
    }
}
