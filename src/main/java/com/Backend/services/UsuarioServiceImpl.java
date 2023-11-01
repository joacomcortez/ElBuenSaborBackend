package com.Backend.services;

import com.Backend.entities.Usuario;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Usuario> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<Usuario> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
