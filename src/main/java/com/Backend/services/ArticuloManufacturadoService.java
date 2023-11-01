package com.Backend.services;

import com.Backend.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {
    List<ArticuloManufacturado> search(String string) throws Exception;

    Page<ArticuloManufacturado> search(String string, Pageable pageable) throws Exception;

    List<ArticuloManufacturado> searchByTipo(String string) throws Exception;
}
