package com.Backend.entities;

import com.Backend.enums.FormaPago;
import com.Backend.enums.Rol;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.beans.ConstructorProperties;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "usuario")
public class Usuario extends BaseFecha {

//    NO IMPLEMENTAR, uso id de Base
//    @NotNull
//    @Column(name = "auth0_id", nullable = false, unique = true)
//    private String auth0Id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;


    @NotNull
    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @NotNull
    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @OneToOne(mappedBy = "usuario", optional = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}