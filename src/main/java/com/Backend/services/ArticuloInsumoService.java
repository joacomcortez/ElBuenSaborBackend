package com.Backend.services;

import com.Backend.entities.ArticuloInsumo;
import com.Backend.entities.Base;
import com.Backend.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> search(String string) throws Exception;

    Page<ArticuloInsumo> search(String string, Pageable pageable) throws Exception;
}
