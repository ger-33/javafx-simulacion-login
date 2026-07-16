/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geraldcalderon.controller;

import com.geraldcalderon.model.Rol;
import com.geraldcalderon.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class AuthSistema {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public AuthSistema() {
        Usuario usuarioAdmin = new Usuario("admin", "admin", "admin", Rol.ADMIN);
        Usuario usuarioUser = new Usuario("user", "user", "user", Rol.USER);
        Usuario userYo = new Usuario("Gerald", "123", "Gerald Calderon", Rol.USER);
        listaUsuarios.add(usuarioAdmin);
        listaUsuarios.add(usuarioUser);
        listaUsuarios.add(userYo);
    }

    public Usuario login(String nombreUsuario, String clave) {
        for (Usuario usuarioBuscado : listaUsuarios) {

            if (usuarioBuscado.getUsername().equals(nombreUsuario)
                    && usuarioBuscado.getPassword().equals(clave)) {

                return usuarioBuscado;
            }
        }

        return null;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        AuthSistema.listaUsuarios = listaUsuarios;
    }
}
