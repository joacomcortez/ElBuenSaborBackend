package com.Backend.services;

import com.Backend.entities.DetalleFactura;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetalleFactura> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<DetalleFactura> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
