package com.Backend.controllers;



import com.Backend.DTO.DTOCrearPedido;
import com.Backend.entities.Pedido;
import com.Backend.enums.EstadoPedido;
import com.Backend.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    //Búsqueda: a través de un cuadro de búsqueda, se podrá buscar productos mediante su nombre o se podrá elegir una determinada categoría para ver todos los productos correspondientes a la misma
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Long clienteId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.searchByCliente(clienteId));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPedidosCocina")
    public ResponseEntity<?> searchPedidosCocina(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.searchPedidosCocina());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
//    @GetMapping("/searchPaged")
//    public ResponseEntity<?> searchByCliente(@RequestParam Long clienteID, Pageable pageable){
//        try{
//            System.out.println("entre siuu\n");
//            return ResponseEntity.status(HttpStatus.OK).body(service.searchByCliente(clienteID, pageable));
//        } catch(Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
//        }
//    }


    @PostMapping("/createPedido")
    public ResponseEntity<?> createCarrito(@RequestBody DTOCrearPedido dtoPedido){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.savePedido(dtoPedido));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/rankingProductos")
    public ResponseEntity<?> rankingProductos(@RequestParam String date1, String date2){
        try{
            System.out.println("adentro del controller");
            return ResponseEntity.status(HttpStatus.OK).body(service.rankingProductos(date1, date2));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    }

