package com.Backend.repositories;

import com.Backend.entities.Cliente;
import com.Backend.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:filtro%")
    Usuario search(@Param("filtro") String filtro);
}
