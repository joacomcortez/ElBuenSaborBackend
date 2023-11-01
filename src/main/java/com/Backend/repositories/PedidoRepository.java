package com.Backend.repositories;


import com.Backend.entities.ArticuloManufacturado;
import com.Backend.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
    @Query(
            value = "SELECT p FROM Pedido p WHERE p.id_cliente = cast(:filtro as int)",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Pedido> searchByCliente(@Param("filtro") Long clienteId, Pageable pageable);

    @Query(
            value = "SELECT * FROM Pedido p WHERE p.id_cliente = %:filtro%",
//            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    List<Pedido> searchByCliente(@Param("filtro") Long clienteId);

    @Query(
            value = "SELECT * FROM Pedido p WHERE p.estado = 'PREPARACION'",
//            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    List<Pedido> searchPedidosCocina();

    @Query(
            value="SELECT * FROM Pedido p WHERE p.FECHA_PEDIDO BETWEEN %:date1% AND %:date2%",
            nativeQuery = true
    )
    List<Pedido> searchPedidosBetweenDates(String date1, String date2);
}
