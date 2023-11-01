package com.Backend.services;

import com.Backend.entities.DetalleArticuloManufacturado;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.DetalleArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {
    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetalleArticuloManufacturado> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<DetalleArticuloManufacturado> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
