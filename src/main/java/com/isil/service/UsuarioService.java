package com.isil.service;

import com.isil.model.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Integer> {
    List<Usuario> usersActivated();
    List<Usuario> usersInactivated();
    List<Usuario> usersAdministrators();
}
