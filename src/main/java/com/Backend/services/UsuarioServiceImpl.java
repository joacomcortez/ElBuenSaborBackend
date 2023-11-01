package com.Backend.services;

import com.Backend.DTO.DTOActualizarDatosUsuario;
import com.Backend.entities.Usuario;
import com.Backend.enums.Rol;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<Usuario> search(String username) throws Exception {
        try{
            //Busca y devuelve una lista de los usuarios pasandole el correo
            List<Usuario> usuario = (List<Usuario>) usuarioRepository.search(username);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> search(String string, Pageable pageable) throws Exception {
        return null;
    }

    public Boolean existeUsuario (String Username) throws Exception{
        try{
            Boolean consulta  = usuarioRepository.existeUsuario(Username);
            return consulta;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Boolean log_in (String Email, String Clave) throws Exception {
        try{
            Boolean consulta = usuarioRepository.loginUsuario(Email, Clave);
            return consulta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Boolean altaUsuarioForm ( String Email, String Clave, Rol Rol) throws Exception {
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Boolean consulta = usuarioRepository.altaUsuarioForm(Email, Clave, now);
            return consulta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Boolean altaUsuarioGoogle ( String Email, String Clave, Rol Rol) throws Exception {
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Boolean consulta = usuarioRepository.altaUsuarioGoogle(Email, Clave, now);
            return consulta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Boolean adminAltaUsuarioForm ( String Email, String Clave, Rol Rol) throws Exception {
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Boolean consulta = usuarioRepository.adminAltaUsuarioForm(Email, Clave, now, Rol);
            return consulta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Boolean bajaUsuario ( String Email) throws Exception {
        try{
            Boolean consulta = usuarioRepository.bajaUsuario(Email);
            return consulta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<DTOActualizarDatosUsuario> modifUsuario (Boolean activo,  Date fecha_alta, Date fecha_baja,  Date fecha_mod, String password, String username) throws Exception {
        try{
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public List<DTOActualizarDatosUsuario> adminModifUsuario (Boolean activo,  Date fecha_alta, Date fecha_baja,  Date fecha_mod, String password, Rol rol, String username) throws Exception {
        try{
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
