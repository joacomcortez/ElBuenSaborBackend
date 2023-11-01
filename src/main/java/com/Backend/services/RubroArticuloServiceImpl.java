package com.Backend.services;

import com.Backend.entities.RubroArticulo;
import com.Backend.enums.EstadoBasico;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;


    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<RubroArticulo> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<RubroArticulo> search(String string, Pageable pageable) throws Exception {
        return null;
    }

    public RubroArticulo cambiarEstado(Long rubroId, EstadoBasico estadoRubro) throws Exception{
        try{
            RubroArticulo rubroArticulo = rubroArticuloRepository.getById(rubroId);
            rubroArticulo.setEstadoRubro(estadoRubro);
            rubroArticuloRepository.save(rubroArticulo);
            return rubroArticulo;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
