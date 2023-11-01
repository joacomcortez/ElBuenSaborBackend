package com.Backend.services;

import com.Backend.entities.DetallePedido;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetallePedido> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<DetallePedido> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
