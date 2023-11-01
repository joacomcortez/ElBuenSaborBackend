package com.Backend.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTORankingClientes implements Comparable {
    private int cantidadPedidos;
    private long clienteId;
    private String nombre;
    private String apellido;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
