package com.Backend.DTO;

import com.Backend.enums.Rol;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOCrearUsuario {

    private String username;
    private String password;
    private Rol rol;
    private Boolean activo;

}
