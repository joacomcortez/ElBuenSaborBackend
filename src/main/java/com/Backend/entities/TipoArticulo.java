package com.Backend.entities;

import com.Backend.enums.EstadoBasico;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TipoArticulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class TipoArticulo extends Base{
    private String denominacion;
    private EstadoBasico estadoRubro;
}
