package com.Backend.entities;

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
    private String nombreCategoria;
}
