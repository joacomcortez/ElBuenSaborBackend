package com.Backend.entities;

import com.Backend.enums.EstadoPedido;
import com.Backend.enums.FormaPago;
import com.Backend.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    //@NotNull  PONER ESTO CUANDO SE ARREGLE LO DE SUMAR EL TIEMPO ESTIMADO DE COCINA
    @Column(name = "hora_estimada_finalizacion")
    private LocalTime horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_costo", precision = 10, scale = 2)
    private BigDecimal totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilio;

    @NotNull
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private Factura factura;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detallesPedido;

    public void adddetallesPedido(DetallePedido detallePedido){
        detallesPedido.add(detallePedido);
    }

    public void setdetallesPedido(List<DetallePedido> detalles){this.detallesPedido = detalles;}

}
