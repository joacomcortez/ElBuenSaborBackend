package com.Backend.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOInsumoDetalle {
    private int cantidad;
    private Long articuloInsumoId;
}
