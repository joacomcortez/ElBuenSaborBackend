package com.Backend.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTODetallePedido {

    private Integer cantidad;
    private Long id_ArticuloManufacturado;


}
