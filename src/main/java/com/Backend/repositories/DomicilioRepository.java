package com.Backend.repositories;

import com.Backend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro% AND d.numero = cast(:filtro2 as int)")
    Domicilio search(@Param("filtro") String filtro, int filtro2);

}

