package com.Backend.services;

import com.Backend.entities.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {
    List<Usuario> search(String username) throws Exception;
}
