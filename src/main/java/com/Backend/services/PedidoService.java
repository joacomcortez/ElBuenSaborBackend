package com.Backend.services;

import com.Backend.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    Page<Pedido> searchByCliente(Long clienteId, Pageable pageable) throws Exception;
    List<Pedido> searchByCliente(Long clienteId) throws Exception;

}
