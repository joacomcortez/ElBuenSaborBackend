package com.Backend.DTO;

import com.Backend.enums.FormaPago;
import com.Backend.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCrearPedido {

    private List<DTODetallePedido> articulos = new ArrayList<>();
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private String domicilioCalle;
    private int domicilioNumero;
    private String username;


    public void setArticulos(List<DTODetallePedido> articulos) {
        this.articulos = articulos;
    }
}
