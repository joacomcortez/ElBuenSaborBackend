package com.Backend.services;

import com.Backend.entities.DetallePedido;
import com.Backend.entities.Domicilio;
import com.Backend.entities.TipoArticulo;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.DetallePedidoRepository;
import com.Backend.repositories.TipoArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoArticuloServiceImpl extends BaseServiceImpl<TipoArticulo, Long> implements TipoArticuloService {

    @Autowired
    private TipoArticuloRepository tipoPedidoRepository;
    public TipoArticuloServiceImpl(BaseRepository<TipoArticulo, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public List<TipoArticulo> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<TipoArticulo> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
