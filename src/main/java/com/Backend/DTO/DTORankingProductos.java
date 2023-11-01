package com.Backend.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTORankingProductos {
    private List<DTODetalleRankingProductos> dtoDetalleRankingProductosList = new ArrayList<>();
    public void setDetalles(List<DTODetalleRankingProductos> detalles) {
        this.dtoDetalleRankingProductosList = detalles;
    }
    public void addDetalles(DTODetalleRankingProductos detalles) {
        dtoDetalleRankingProductosList.add(detalles);
    }
}
