package com.Backend.services;

import com.Backend.entities.*;
import com.Backend.repositories.ArticuloManufacturadoRepository;
import com.Backend.repositories.BaseRepository;
import com.Backend.repositories.FacturaRepository;
import com.Backend.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
//import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Factura> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<Factura> search(String string, Pageable pageable) throws Exception {
        return null;
    }
    //Crear factura para un pedido con id i
    @Transactional
    public Factura createFactura(Long i) throws Exception {

        try {
            Factura factura = new Factura();
//            Pedido pedido = new Pedido(); // saque esto pq creo que me daba el error del key duplicado
            Pedido pedido = pedidoRepository.getReferenceById(i);
            factura.setPedido(pedidoRepository.getReferenceById(i));
            factura.setTotalVenta(pedidoRepository.getReferenceById(i).getTotal());
            factura.setFechaFacturacion(new Date());
            factura.setFechaAlta(new Date());
            factura.setFormaPago(pedidoRepository.getReferenceById(i).getFormaPago());
            List<DetallePedido> detallesPedido = pedidoRepository.getReferenceById(i).getDetallesPedido();
            List<DetalleFactura> detallesFactura = new ArrayList<>();
            DetalleFactura detalleFactura = new DetalleFactura();
            for (int j = 0; j < detallesPedido.size(); j++) {
                detalleFactura.setCantidad(detallesPedido.get(Math.toIntExact(i)).getCantidad());
                detalleFactura.setFactura(factura);
                detalleFactura.setArticuloManufacturado(detallesPedido.get(Math.toIntExact(i)).getArticuloManufacturado());
                detalleFactura.setSubtotal(detallesPedido.get(Math.toIntExact(i)).getSubtotal());
                detallesFactura.add(detalleFactura);
            }
            factura.setDetallesFactura(detallesFactura);
//            factura = facturaRepository.save(factura);
//            pedido.setFactura(factura);
//            System.out.println("antes");

//            pedidoRepository.save(pedido);
//            System.out.println("despues");
            factura = facturaRepository.save(factura);
            facturaRepository.flush();
//            refresh(factura);
        return factura;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
