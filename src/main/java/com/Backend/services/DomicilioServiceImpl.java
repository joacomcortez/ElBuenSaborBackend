package com.Backend.services;

import com.Backend.entities.Domicilio;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Domicilio> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<Domicilio> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
