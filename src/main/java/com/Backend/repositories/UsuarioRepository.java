package com.Backend.repositories;

import com.Backend.entities.Usuario;
import com.Backend.enums.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
    @Query(
            value = "SELECT u FROM Usuario u WHERE u.username = ':filtro'",
            nativeQuery = true
    )
     Usuario loadByUsername(@Param("filtro") String username);


    @Query(value = "SELECT u FROM Usuario u WHERE u.username = ':filtro'")
    Usuario search(@Param("filtro") String filtro);

    //CORROBORAR QUE EXISTA EL USUARIO
    @Query(
            value = "SELECT * FROM usuario WHERE EXISTS (SELECT * FROM usuario u WHERE  u.username = ':filtro')",
            nativeQuery = true
    )
    Boolean existeUsuario(@Param("filtro") String filtro);

    //INICIAR SESION
    @Query(
            value = "SELECT * FROM usuario WHERE EXISTS (SELECT * FROM usuario u WHERE  u.username = ':username' AND u.password = ':password' AND u.activo = ':activo')",
            nativeQuery = true
    )
    Usuario loginUsuario(@Param("username") String username, @Param("password") String password);


    //ALTAS DE USUARIO POR PARTE DEL USUARIO Y DEL ADMIN CON FORMULARIO Y CON GOOGLE
    @Query(
            value = "INSERT INTO usuario (ACTIVO, FECHA_ALTA, FECHA_BAJA, FECHA_MODIFICACION, PASSWORD, ROL, USERNAME) VALUES ('TRUE',':fecha_alta','null','null',':password','CLIENTE',':username');",
            nativeQuery = true
    )
    Boolean altaUsuarioForm(@Param("username") String username, @Param("password") String password, @Param("fecha_alta")LocalDateTime LocalDateTime);

    @Query(
            value = "INSERT INTO usuario (ACTIVO, FECHA_ALTA, FECHA_BAJA, FECHA_MODIFICACION, PASSWORD, ROL, USERNAME) VALUES ('TRUE',':fecha_alta','null','null',':password','CLIENTE',':username');",
            nativeQuery = true
    )
    Boolean altaUsuarioGoogle(@Param("username") String username, @Param("password") String password, @Param("fecha_alta")LocalDateTime LocalDateTime);

    @Query(
            value = "INSERT INTO usuario (ACTIVO, FECHA_ALTA, FECHA_BAJA, FECHA_MODIFICACION, PASSWORD, ROL, USERNAME) VALUES ('TRUE',':fecha_alta','null','null',':password',':rol',':username');",
            nativeQuery = true
    )
    Boolean adminAltaUsuarioForm(@Param("username") String username, @Param("password") String password, @Param("fecha_alta")LocalDateTime LocalDateTime,@Param(":rol") Rol rol);


    //BAJA LOGICA DEL USUARIO
    @Query(
            value = "UPDATE usuario SET ACTIVO = FALSE WHERE u.username = ':username';",
            nativeQuery = true
    )
    Boolean bajaUsuario(@Param("username") String username);

    //ACTUALIZAR DATOS DEL USUARIO POR PARTE DEL USUARIO
    @Query(
            value = "UPDATE usuario SET (ACTIVO=':activo', FECHA_ALTA=':fecha_alta', FECHA_BAJA=':fecha_baja', FECHA_MODIFICACION=':fecha_mod', PASSWORD=':password', USERNAME=':username') WHERE u.username = ':username';",
            nativeQuery = true
    )
    Usuario modifUsuario(@Param("activo") Boolean activo, @Param("fecha_alta") Date fecha_alta, @Param("fecha_baja") Date fecha_baja, @Param("fecha_mod") Date fecha_mod, @Param("password") String password, @Param("username") String username);

    //ACTUALIZAR DATOS DEL USUARIO POR PARTE DEL ADMINISTRADOR
    @Query(
            value = "UPDATE usuario SET (ACTIVO=':activo', FECHA_ALTA=':fecha_alta', FECHA_BAJA=':fecha_baja', FECHA_MODIFICACION=':fecha_mod', PASSWORD=':password', ROL=':rol', USERNAME=':username') WHERE u.username = ':username';",
            nativeQuery = true
    )
    Usuario adminModifUsuario(@Param("activo") Boolean activo, @Param("fecha_alta") Date fecha_alta, @Param("fecha_baja") Date fecha_baja, @Param("fecha_mod") Date fecha_mod, @Param("password") String password, @Param("rol") Rol rol, @Param("username") String username);

    Optional<Usuario> findByUsername(String username);



}
