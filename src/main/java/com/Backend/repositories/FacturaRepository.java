package com.Backend.repositories;

import com.Backend.entities.*;
import com.Backend.enums.FormaPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {



    //Anotacion JPQL parametros indexados
//    @Query(value = "SELECT f FROM Factura f WHERE f.formaPago LIKE %:filtro%" )
//    List<Factura> search(@Param("filtro") FormaPago filtro);
////
//    @Query(value = "SELECT f FROM Factura f WHERE f.formaPago LIKE %:filtro%" )
//    Page<Factura> search(@Param("filtro") FormaPago filtro, Pageable pageable);
//    //QUERy nativo
//    @Query(
//            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
//            nativeQuery = true
//    )
//    List<Cliente> searchNativo(@Param("filtro") String filtro);
//
//    @Query(
//            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
//            countQuery = "SELECT count(*) FROM cliente",
//            nativeQuery = true
//    )
//    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}


