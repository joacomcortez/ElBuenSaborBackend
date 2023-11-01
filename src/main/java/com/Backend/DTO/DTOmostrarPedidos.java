package com.Backend.DTO;

import com.Backend.entities.Pedido;
import com.Backend.enums.EstadoPedido;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOmostrarPedidos {
    public List<Pedido> pedidos = new ArrayList<>();
    //pedido.getElementById
    private EstadoPedido estadoPedido;

}
