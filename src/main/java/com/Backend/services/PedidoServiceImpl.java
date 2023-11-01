package com.Backend.services;

import com.Backend.DTO.DTODetallePedido;
import com.Backend.DTO.DTOCrearPedido;
import com.Backend.DTO.DTODetalleRankingProductos;
import com.Backend.DTO.DTORankingProductos;
import com.Backend.entities.*;
import com.Backend.enums.EstadoPedido;
import com.Backend.enums.Rol;
import com.Backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.Backend.enums.EstadoPedido.PENDIENTE_PAGO;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<Pedido> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<Pedido> search(String string, Pageable pageable) throws Exception {
        return null;
    }

    @Transactional
    //FALTA VER STOCK CAPO
    public Pedido savePedido(DTOCrearPedido dtoPedido) throws Exception {
        try {
            Calendar calendar = Calendar.getInstance();
            Pedido pedido = new Pedido(); //creo pedido
            //Buscar cliente
            Usuario usuario = usuarioRepository.search(dtoPedido.getUsername());
            pedido.setCliente(usuario.getCliente());
            Cliente cliente = usuario.getCliente();
            System.out.println("aca");
//            if(usuario.getRol() == Rol.CLIENTE) {
                List<DTODetallePedido> articulos = dtoPedido.getArticulos();

                pedido.setFechaPedido(new Date());
                //convertir articulos de DTOArticuloCarrito en DetallePedido
                List<DetallePedido> detallesPedidos = new ArrayList<>();
                int tiempoEstimado = 0;
                for (int i = 0; i < articulos.size(); i++) {
                    DetallePedido detallePedido = new DetallePedido();
                    DTODetallePedido dto = articulos.get(i);
                    ArticuloManufacturado articulo = articuloManufacturadoRepository.getById(dto.getId_ArticuloManufacturado());
                    detallePedido.setCantidad(dto.getCantidad());
                    detallePedido.setSubtotal(articulo.getPrecioVenta().multiply(BigDecimal.valueOf(dto.getCantidad())));
                    detallePedido.setPedido(pedido);
                    detallePedido.setArticuloManufacturado(articulo);
//                    detallePedidoRepository.save(detallePedido);
                    detallesPedidos.add(detallePedido);
                    detallePedidoRepository.save(detallePedido);
                    //aprovecho a calcular el tiempo aprox de entrega
                    tiempoEstimado = 0;
                    if (articulo.getTiempoEstimadoCocina() >= tiempoEstimado) {
                        tiempoEstimado = articulo.getTiempoEstimadoCocina();
                    }

                }
                pedido.setdetallesPedido(detallesPedidos);
                //Buscar total pedido
                List<BigDecimal> subtotales = new ArrayList<>();
                for (int i = 0; i < detallesPedidos.size(); i++) {
                    subtotales.add(detallesPedidos.get(i).getSubtotal());
                }
                BigDecimal totalPedido = subtotales.stream().reduce(
                        BigDecimal.ZERO, BigDecimal::add);
                pedido.setTotal(totalPedido);

                //Busco Forma Pago
                pedido.setFormaPago(dtoPedido.getFormaPago());

                //Busco domicilio
                Domicilio domicilio = domicilioRepository.search(dtoPedido.getDomicilioCalle(), dtoPedido.getDomicilioNumero());
                pedido.setDomicilio(domicilio);
                //Busco Tipo Envio
                pedido.setTipoEnvio(dtoPedido.getTipoEnvio());
                //Seteo Estado
                pedido.setEstado(PENDIENTE_PAGO);
                //Busco tiempo estimado
                //            pedido.setHoraEstimadaFinalizacion(calendar.add(Calendar.HOUR_OF_DAY,tiempoEstimado));
                cliente.addPedido(pedido);
                clienteRepository.save(cliente);

//            }

            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

//    public Page<Pedido> searchByCliente(Long clienteId, Pageable pageable) throws Exception {
//        try {
//          Page<Pedido> pedidos = pedidoRepository.searchByCliente(clienteId, pageable);
//          return pedidos;
//        }catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
    public List<Pedido> searchByCliente(Long clienteId) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.searchByCliente(clienteId);
            return pedidos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> searchByCliente(Long clienteId, Pageable pageable) throws Exception {
        return null;
    }

    public List<Pedido> searchPedidosCocina() throws Exception{
        try{
            List<Pedido> pedidos = pedidoRepository.searchPedidosCocina();
           return null;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DTORankingProductos rankingProductos(String date1, String date2) throws Exception {
        try{
            List<Pedido> pedidos = pedidoRepository.searchPedidosBetweenDates(date1, date2);
            //Crear una variable por cada ArticuloManufacturado existente y despues barrer por detalles e ir sumando 1
            //cada vez que salga :)
            List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.findAll();
            List<Integer> contadorArticulos = new ArrayList<>();
            //Initialize contador en 0
            for (int i = 0; i < articulos.size() ; i++) {
                contadorArticulos.add(i,0);
            }
            System.out.println(contadorArticulos);
            //Recorro pedido a pedido dentro del range
            for (int i = 0; i < pedidos.size(); i++) {
                //Traigo cada Detalle de un pedido a la vez
                List<DetallePedido> detalles = pedidos.get(i).getDetallesPedido();
                // ACA ESTA EL PROBLEMA NO TIENEN DETALLES PEDIDOS, EN EL GETaLL NO TRAE NAADA
                //PERO CUANDO LO CREO ME LOS TRAE, NO PUEDO VER NI LOS DETALLES DE ESE
                for (int j = 0; j < detalles.size(); j++) {
                    int cantidad = detalles.get(j).getCantidad();
                    Long artId = detalles.get(j).getArticuloManufacturado().getId();
                    //esta es por si ya tenia algo antes para ir acumulando
                    int cuentaPrevia = contadorArticulos.get(Math.toIntExact(artId)-1);
                    int nuevoValor = cuentaPrevia + cantidad;
                    //agrego el nuevoValor al arreglo contador en la posicion del articulo Id
                    contadorArticulos.set(Math.toIntExact(artId)-1, nuevoValor);
                }
            }
            System.out.println(contadorArticulos);
            DTORankingProductos rankingProductos = new DTORankingProductos();
//
            for (int i = 0; i < articulos.size() ; i++) {
                ArticuloManufacturado articulo = articuloManufacturadoRepository.getById((long) i+1);
                DTODetalleRankingProductos dto = new DTODetalleRankingProductos();
                dto.setCantidad(contadorArticulos.get(i));
                dto.setNombreArticulo(articulo.getDenominacion());
                rankingProductos.addDetalles(dto);
            }

            return rankingProductos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
