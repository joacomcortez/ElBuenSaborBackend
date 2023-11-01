package com.Backend.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOCompraInsumo {
    private List<DTOInsumoDetalle> detalles = new ArrayList<>();

    public void setDetalles(List<DTOInsumoDetalle> insumos) {
        this.detalles = insumos;
    }
}
