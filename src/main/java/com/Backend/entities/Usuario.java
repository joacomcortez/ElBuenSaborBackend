package com.Backend.entities;

import com.Backend.enums.FormaPago;
import com.Backend.enums.Rol;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.ConstructorProperties;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Usuario extends BaseFecha implements UserDetails {


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


    @Column(name = "activo")
    private Boolean activo;

    @OneToOne(mappedBy = "usuario", optional = false)
    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}