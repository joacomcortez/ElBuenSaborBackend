package com.Backend.repositories;

import com.Backend.entities.Cliente;
import com.Backend.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

 //Anotacion metodo Query
    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
   // boolean existsByDni(int dni);
   Page<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%" )
    List<Cliente> search(@Param("filtro") String filtro);

   @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%" )
   Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);
    //QUERy nativo
    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);

   @Query(
           value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
           countQuery = "SELECT count(*) FROM cliente",
           nativeQuery = true
   )
   Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value="SELECT count(*) FROM Pedido p  WHERE p.ID_CLIENTE like %:clienteId% AND p.FECHA_PEDIDO BETWEEN %:date1% AND %:date2%",
            nativeQuery = true
    )
    Integer searchClienteRanking( long clienteId,String date1, String date2);
}
