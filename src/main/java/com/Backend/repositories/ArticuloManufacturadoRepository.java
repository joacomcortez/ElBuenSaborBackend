package com.Backend.repositories;

import com.Backend.entities.ArticuloManufacturado;
import com.Backend.entities.TipoArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(value = "SELECT a FROM ArticuloManufacturado a WHERE a.denominacion LIKE %:filtro%")
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);



}