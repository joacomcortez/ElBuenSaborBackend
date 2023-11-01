package com.Backend.repositories;

import com.Backend.entities.Cliente;
import com.Backend.entities.Pedido;
import com.Backend.entities.TipoArticulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoArticuloRepository extends BaseRepository<TipoArticulo, Long> {

    @Query(value = "SELECT t FROM TipoArticulo t WHERE t.nombreCategoria LIKE %:filtro%")
    TipoArticulo searchTipo(@Param("filtro") String filtro);

}
