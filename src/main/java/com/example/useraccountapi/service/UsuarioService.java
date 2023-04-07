package com.example.useraccountapi.service;

import com.example.useraccountapi.entities.Usuario;
import com.example.useraccountapi.interfaces.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UsuarioService {



        @Autowired
        private UsuarioRepository repoUsuario;

        //Crud Jpa

        public void crearUsuario(String nombre,String apellido,String email){

            Usuario user=new Usuario();
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setEmail(email);
            repoUsuario.save(user);
        }


        public Optional<Usuario> buscarUsuario(Integer id){
            Optional<Usuario> usuarioJpa= repoUsuario.findById(id);
            return usuarioJpa;
        }

        public void modificarUsuario(String nombre, String apellido, String email,Integer id){

            // Optional<Usuario> usuario= repoUsuario.save();
            buscarUsuario(id);
            Optional<Usuario> usuarioJpa= repoUsuario.findById(id);
            if (usuarioJpa.isPresent()){
                Usuario usuario = usuarioJpa.get();
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setEmail(email);
                repoUsuario.save(usuario);

            }else System.out.println("Usuario no encontrado");

        }
        public void borrarUsuario(Integer id){
            repoUsuario.deleteById(id);
        }


    }

