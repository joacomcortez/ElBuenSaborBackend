package com.Backend.entities;

import com.Backend.entities.Base;
import com.Backend.enums.EstadoBasico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@ToString
public class ArticuloManufacturado extends BaseFecha {

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @OneToMany(mappedBy = "articuloManufacturado")
    @JsonIgnore
    private List<DetalleArticuloManufacturado> detallesArticuloManufacturado = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tipoArticulo")
    private TipoArticulo tipoArticulo;

    private EstadoBasico estado;
    public void addDetalleArticuloManufacturado (DetalleArticuloManufacturado detalleArticuloManufacturado){
        detallesArticuloManufacturado.add(detalleArticuloManufacturado);
    }


}
