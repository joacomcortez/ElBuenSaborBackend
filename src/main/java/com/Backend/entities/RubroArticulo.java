package com.Backend.entities;

import com.Backend.enums.EstadoBasico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class RubroArticulo extends BaseFecha {


    @OneToMany(mappedBy = "rubroArticulo")
    @JsonIgnore
    private List<ArticuloInsumo> articuloInsumos;


    @NotNull
    private String denominacion;

   private EstadoBasico estadoRubro;
    public void addArticuloInsumos(ArticuloInsumo articuloInsumo) {
        articuloInsumos.add(articuloInsumo);
    }
}