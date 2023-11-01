package com.Backend.repositories;

import com.Backend.entities.ArticuloInsumo;
import com.Backend.entities.ArticuloManufacturado;
import com.Backend.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    @Query(
            value = "SELECT * FROM ARTICULO_INSUMO ai ORDER BY ai.STOCK_MINIMO - ai.STOCK_ACTUAL  DESC",
            nativeQuery = true)
    Page<ArticuloInsumo> searchStock(Pageable pageable);

}