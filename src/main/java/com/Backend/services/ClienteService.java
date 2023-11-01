package com.Backend.services;

import com.Backend.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ClienteService extends BaseService<Cliente, Long>{
    List<Cliente> search(String string) throws Exception;

    Page<Cliente> search(String string, Pageable pageable) throws Exception;


}
