package com.Backend;


import com.Backend.entities.*;
import com.Backend.enums.EstadoBasico;
import com.Backend.enums.Rol;
import com.Backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.Backend.enums.EstadoPedido.*;
import static com.Backend.enums.FormaPago.EFECTIVO;
import static com.Backend.enums.TipoEnvio.DELIVERY;


@SpringBootApplication
public class BackendApplication {
	private GregorianCalendar fecha = new GregorianCalendar();
	@Autowired
	 ClienteRepository clienteRepository;
	@Autowired
	 ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	 ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	 DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	 DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	 DetallePedidoRepository detallePedidoRepository;
	@Autowired
	 DomicilioRepository domicilioRepository;
	@Autowired
	 FacturaRepository facturaRepository;
	@Autowired
	 PedidoRepository pedidoRepository;
	@Autowired
	 RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	 UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	 UsuarioRepository usuarioRepository;
	@Autowired
	TipoArticuloRepository tipoArticuloRepository;


	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(/*ClienteRepository clienteRepo, ArticuloInsumoRepository articuloInsumoRep, ArticuloManufacturadoRepository articuloManufacturadoRepo,
						   DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepo, DetalleFacturaRepository detalleFacturaRepo, DetallePedidoRepository detallePedidoRepo,
							DomicilioRepository domicilioRepo, FacturaRepository facturaRepo, PedidoRepository pedidoRepo, RubroArticuloRepository rubroArticuloRepo,
						   UnidadMedidaRepository unidadMedidaRepository, UsuarioRepository usuarioRepo*/){
		return args -> {

//			Cliente cliente = Cliente.builder().nombre("hola").apellido("Gutierrez").email("soyGutierrez@gmail.com").telefono("2604552255").build();
//			cliente.setFechaAlta(new Date(1-10-2023));

			ArticuloManufacturado artMan = new ArticuloManufacturado();
			artMan.setCosto(BigDecimal.valueOf(1200));
			artMan.setDenominacion("hamburguesa");
			artMan.setDescripcion("hamburguesa rica con panceta siuu");
			artMan.setFechaAlta(new Date(1-10-2023));
			artMan.setFechaBaja(null);
			artMan.setFechaModificacion(null);
			artMan.setPrecioVenta(BigDecimal.valueOf(2500));
			artMan.setTiempoEstimadoCocina(20);
			artMan.setEstado(EstadoBasico.Baja);
			artMan.setUrlImagen("https://recetasdeusa.com/wp-content/uploads/2022/05/Hamburguesa-americana-1-scaled.jpg");

			TipoArticulo tipoArticulo = new TipoArticulo();
			tipoArticulo.setDenominacion("sandwiches");
			tipoArticulo.setEstadoRubro(EstadoBasico.Baja);
			tipoArticuloRepository.save(tipoArticulo);
			artMan.setTipoArticulo(tipoArticulo);

			ArticuloManufacturado artMan2 = new ArticuloManufacturado();
			artMan2.setCosto(BigDecimal.valueOf(1200));
			artMan2.setDenominacion("pizza");
			artMan2.setDescripcion("napolitana");
			artMan2.setFechaAlta(new Date(1-10-2023));
			artMan2.setFechaBaja(null);
			artMan2.setFechaModificacion(null);
			artMan2.setPrecioVenta(BigDecimal.valueOf(2500));
			artMan2.setTiempoEstimadoCocina(20);
			artMan2.setEstado(EstadoBasico.Alta);
			artMan2.setUrlImagen("https://osojimix.com/wp-content/uploads/2022/06/Para-la-masa-de-pizza-napolitana-8-hrs-fermentacion-Web-1.jpg");
			articuloManufacturadoRepository.save(artMan2);

			ArticuloManufacturado artMan3 = new ArticuloManufacturado();
			artMan3.setCosto(BigDecimal.valueOf(450));
			artMan3.setDenominacion("Papas fritas");
			artMan3.setDescripcion("papas fritas con cheddar y verdeo");
			artMan3.setFechaAlta(new Date(1-10-2023));
			artMan3.setFechaBaja(null);
			artMan3.setFechaModificacion(null);
			artMan3.setPrecioVenta(BigDecimal.valueOf(2300));
			artMan3.setTiempoEstimadoCocina(20);
			artMan3.setEstado(EstadoBasico.Alta);
			artMan3.setUrlImagen("https://as2.ftcdn.net/v2/jpg/02/95/15/49/1000_F_295154986_Gg3nJFkV7vxmUzlRKgk2TNiIOmyMBmyH.jpg");
			articuloManufacturadoRepository.save(artMan3);

			ArticuloManufacturado artMan4 = new ArticuloManufacturado();
			artMan4.setCosto(BigDecimal.valueOf(2000));
			artMan4.setDenominacion("sushi 7 piezas");
			artMan4.setDescripcion("7 piezas de sushi variadas");
			artMan4.setFechaAlta(new Date(1-10-2023));
			artMan4.setFechaBaja(null);
			artMan4.setFechaModificacion(null);
			artMan4.setPrecioVenta(BigDecimal.valueOf(5000));
			artMan4.setTiempoEstimadoCocina(25);
			artMan4.setEstado(EstadoBasico.Alta);
			artMan4.setUrlImagen("https://media.c5n.com/p/03172cea7d946db55d6ab28fa602cf0c/adjuntos/326/imagenes/000/199/0000199545/790x0/smart/kamay-lounge-sushi.jpg");
			articuloManufacturadoRepository.save(artMan4);

			ArticuloManufacturado artMan5 = new ArticuloManufacturado();
			artMan5.setCosto(BigDecimal.valueOf(1500));
			artMan5.setDenominacion("lomo de bife");
			artMan5.setDescripcion("lomo de ternera con vegetales");
			artMan5.setFechaAlta(new Date(1-10-2023));
			artMan5.setFechaBaja(null);
			artMan5.setFechaModificacion(null);
			artMan5.setPrecioVenta(BigDecimal.valueOf(3500));
			artMan5.setTiempoEstimadoCocina(25);
			artMan5.setEstado(EstadoBasico.Alta);
			artMan5.setUrlImagen("https://www.clarin.com/img/2021/07/26/u-aUfp64d_1256x620__1.jpg");
			articuloManufacturadoRepository.save(artMan5);

			ArticuloManufacturado artMan6 = new ArticuloManufacturado();
			artMan6.setCosto(BigDecimal.valueOf(1500));
			artMan6.setDenominacion("Fideos");
			artMan6.setDescripcion("fideos con salsa a eleccion");
			artMan6.setFechaAlta(new Date(1-10-2023));
			artMan6.setFechaBaja(null);
			artMan6.setFechaModificacion(null);
			artMan6.setPrecioVenta(BigDecimal.valueOf(3500));
			artMan6.setTiempoEstimadoCocina(25);
			artMan6.setEstado(EstadoBasico.Alta);
			artMan6.setUrlImagen("https://cocinaconmarco.com/wp-content/uploads/2022/02/Ant-web-Pasta-salsa-arrabbiata-e1645198880814.webp");
			articuloManufacturadoRepository.save(artMan6);

			Cliente cliente1 = new Cliente();
			cliente1.setNombre("Hola :)");
			cliente1.setApellido("Gonzalez");
			cliente1.setEmail("gonzalez@hotmail.com");
			cliente1.setFechaAlta(new Date(1-10-2023));
			cliente1.setFechaBaja(null);
			cliente1.setFechaModificacion(null);
			cliente1.setTelefono("2604562573");

			Usuario user = new Usuario();
			user.setFechaAlta(new Date(1-10-2023));
			user.setFechaBaja(null);
			user.setFechaModificacion(null);
			user.setRol(Rol.CLIENTE);
			user.setUsername("holaGonzalez");
			user.setPassword("password");
			user.setActivo(true);
			usuarioRepository.save(user);

			cliente1.setUsuario(user);
			clienteRepository.save(cliente1);

			Domicilio domi = new Domicilio();
			domi.setCalle("callesiu");
			domi.setCodigoPostal(5500);
			domi.setFechaAlta(new Date(1-10-2023));
			domi.setFechaBaja(null);
			domi.setFechaModificacion(null);
			domi.setCliente(cliente1);
			domi.setCliente(cliente1);
			domicilioRepository.save(domi);

			Pedido pedido = new Pedido();
			pedido.setCliente(cliente1);


			pedido.setDomicilio(domi);
			pedido.setEstado(PAGADO);
			pedido.setFechaPedido(new Date(1-10-2023));
			pedido.setFormaPago(EFECTIVO);
			pedido.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido.setTipoEnvio(DELIVERY);
			pedido.setTotal(BigDecimal.valueOf(2500));
			pedido.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido);


			Pedido pedido1 = new Pedido();
			pedido.setCliente(cliente1);

			pedido1.setDomicilio(domi);
			pedido1.setEstado(PAGADO);
			pedido1.setFechaPedido(new Date(1-10-2023));
			pedido1.setFormaPago(EFECTIVO);
			pedido1.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido1.setTipoEnvio(DELIVERY);
			pedido1.setTotal(BigDecimal.valueOf(2500));
			pedido1.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido1);

//			DetallePedido detallePedido = new DetallePedido();
//			detallePedido.setArticuloManufacturado(artMan);
//			detallePedido.setPedido(pedido);


			Factura factura = new Factura();
			factura.setFormaPago(EFECTIVO);
			factura.setPedido(pedido);
			factura.setFechaAlta(new Date(1-10-2023));
			factura.setFechaBaja(null);
			factura.setFechaModificacion(null);
			factura.setFechaFacturacion(new Date(1-10-2023));
			factura.setTotalVenta(BigDecimal.valueOf(5000));
			facturaRepository.save(factura);

			RubroArticulo ra = new RubroArticulo();
			ra.setDenominacion("carne");
			ra.setEstadoRubro(EstadoBasico.Alta);
			ra.setFechaAlta(new Date(1-10-2023));
			ra.setFechaBaja(null);
			ra.setFechaModificacion(null);



			rubroArticuloRepository.save(ra);

			UnidadMedida unidad = new UnidadMedida();
			unidad.setDenominacion("unidad");
			unidad.setAbreviatura("un");
			unidadMedidaRepository.save(unidad);

			ArticuloInsumo artInsumo = new ArticuloInsumo();
			artInsumo.setDenominacion("carneHamburguesa");
			artInsumo.setFechaAlta(new Date(1-10-2023));
			artInsumo.setFechaBaja(null);
			artInsumo.setFechaModificacion(null);
			artInsumo.setPrecioCompra(BigDecimal.valueOf(1200));
			artInsumo.setRubroArticulo(ra);
			artInsumo.setStockActual(BigDecimal.valueOf(20));
			artInsumo.setStockMinimo(BigDecimal.valueOf(8));
			artInsumo.setUnidadMedida(unidad);
			artInsumo.setUrlImagen("urlURLurlURLurlURL");
			articuloInsumoRepository.save(artInsumo);

			ArticuloInsumo artInsumo2 = new ArticuloInsumo();
			artInsumo2.setDenominacion("panHamburguesa");
			artInsumo2.setFechaAlta(new Date(1-10-2023));
			artInsumo2.setFechaBaja(null);
			artInsumo2.setFechaModificacion(null);
			artInsumo2.setPrecioCompra(BigDecimal.valueOf(1200));
			artInsumo2.setRubroArticulo(ra);
			artInsumo2.setStockActual(BigDecimal.valueOf(1));
			artInsumo2.setStockMinimo(BigDecimal.valueOf(20));
			artInsumo2.setUnidadMedida(unidad);
			artInsumo2.setUrlImagen("urlURLurlURLurlURL");
			articuloInsumoRepository.save(artInsumo2);

			ArticuloInsumo artInsumo3 = new ArticuloInsumo();
			artInsumo3.setDenominacion("tomate");
			artInsumo3.setFechaAlta(new Date(1-10-2023));
			artInsumo3.setFechaBaja(null);
			artInsumo3.setFechaModificacion(null);
			artInsumo3.setPrecioCompra(BigDecimal.valueOf(1200));
			artInsumo3.setRubroArticulo(ra);
			artInsumo3.setStockActual(BigDecimal.valueOf(5));
			artInsumo3.setStockMinimo(BigDecimal.valueOf(20));
			artInsumo3.setUnidadMedida(unidad);
			artInsumo3.setUrlImagen("urlURLurlURLurlURL");
			articuloInsumoRepository.save(artInsumo3);



//

			articuloManufacturadoRepository.save(artMan);

			DetalleArticuloManufacturado detalleArticuloManufacturado = new DetalleArticuloManufacturado();
			detalleArticuloManufacturado.setCantidad(BigDecimal.valueOf(3));
			detalleArticuloManufacturado.setArticuloInsumo(artInsumo);
			detalleArticuloManufacturado.setArticuloManufacturado(artMan);
			artMan.addDetalleArticuloManufacturado(detalleArticuloManufacturado);

			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);

			DetalleFactura df = new DetalleFactura();
			df.setArticuloManufacturado(artMan);
			df.setCantidad(2);
			df.setFactura(factura);
			df.setSubtotal(BigDecimal.valueOf(5000));
			detalleFacturaRepository.save(df);


//			DetallePedido detped = new DetallePedido();
//			detped.setCantidad(1);

			Cliente cliente2 = new Cliente();
			cliente2.setNombre("Fabrizio");
			cliente2.setApellido("Azeglio");
			cliente2.setEmail("fazeglio@hotmail.com");
			cliente2.setFechaAlta(new Date(1-10-2023));
			cliente2.setFechaBaja(null);
			cliente2.setFechaModificacion(null);
			cliente2.setTelefono("12345678");

			Usuario user2 = new Usuario();
			user2.setFechaAlta(new Date(1-10-2023));
			user2.setFechaBaja(null);
			user2.setFechaModificacion(null);
			user2.setRol(Rol.CLIENTE);
			user2.setUsername("fabros96");
			user2.setPassword("123456");
			user2.setActivo(true);
			usuarioRepository.save(user2);

			cliente2.setUsuario(user2);
			clienteRepository.save(cliente2);

			Domicilio domi2 = new Domicilio();
			domi2.setCalle("Cacheuta 555");
			domi2.setCodigoPostal(5539);
			domi2.setFechaAlta(new Date(1-10-2023));
			domi2.setFechaBaja(null);
			domi2.setFechaModificacion(null);
			domi2.setCliente(cliente2);
			domi2.setCliente(cliente2);
			domicilioRepository.save(domi2);

			Cliente cliente3 = new Cliente();
			cliente3.setNombre("Joaco");
			cliente3.setApellido("Cortez");
			cliente3.setEmail("jcortez@hotmail.com");
			cliente3.setFechaAlta(new Date(1-10-2023));
			cliente3.setFechaBaja(null);
			cliente3.setFechaModificacion(null);
			cliente3.setTelefono("12345679");

			Usuario user3 = new Usuario();
			user3.setFechaAlta(new Date(1-10-2023));
			user3.setFechaBaja(null);
			user3.setFechaModificacion(null);
			user3.setRol(Rol.CLIENTE);
			user3.setUsername("jcortez");
			user3.setPassword("123789");
			user3.setActivo(true);
			usuarioRepository.save(user3);

			cliente3.setUsuario(user3);
			clienteRepository.save(cliente3);

			Domicilio domi3 = new Domicilio();
			domi3.setCalle("Calle Siu 777");
			domi3.setCodigoPostal(5500);
			domi3.setFechaAlta(new Date(1-10-2023));
			domi3.setFechaBaja(null);
			domi3.setFechaModificacion(null);
			domi3.setCliente(cliente3);
			domi3.setCliente(cliente3);
			domicilioRepository.save(domi3);

			Cliente cliente4 = new Cliente();
			cliente4.setNombre("Ezequiel");
			cliente4.setApellido("Buxo");
			cliente4.setEmail("ebuxo@hotmail.com");
			cliente4.setFechaAlta(new Date(1-10-2023));
			cliente4.setFechaBaja(null);
			cliente4.setFechaModificacion(null);
			cliente4.setTelefono("12345676");

			Usuario user4 = new Usuario();
			user4.setFechaAlta(new Date(1-10-2023));
			user4.setFechaBaja(null);
			user4.setFechaModificacion(null);
			user4.setRol(Rol.CLIENTE);
			user4.setUsername("ebuxo");
			user4.setPassword("123765");
			user4.setActivo(true);
			usuarioRepository.save(user4);

			cliente4.setUsuario(user4);
			clienteRepository.save(cliente4);

			Domicilio domi4 = new Domicilio();
			domi4.setCalle("Calle Falsa 123");
			domi4.setCodigoPostal(5500);
			domi4.setFechaAlta(new Date(1-10-2023));
			domi4.setFechaBaja(null);
			domi4.setFechaModificacion(null);
			domi4.setCliente(cliente4);
			domi4.setCliente(cliente4);
			domicilioRepository.save(domi4);

			Cliente cliente5 = new Cliente();
			cliente5.setNombre("Antunella");
			cliente5.setApellido("Cortez");
			cliente5.setEmail("acortez@hotmail.com");
			cliente5.setFechaAlta(new Date(1-10-2023));
			cliente5.setFechaBaja(null);
			cliente5.setFechaModificacion(null);
			cliente5.setTelefono("26171235");

			Usuario user5 = new Usuario();
			user5.setFechaAlta(new Date(1-10-2023));
			user5.setFechaBaja(null);
			user5.setFechaModificacion(null);
			user5.setRol(Rol.CLIENTE);
			user5.setUsername("acortez");
			user5.setPassword("lala");
			user5.setActivo(true);
			usuarioRepository.save(user5);

			cliente5.setUsuario(user5);
			clienteRepository.save(cliente5);

			Domicilio domi5 = new Domicilio();
			domi5.setCalle("Barrio Escondido");
			domi5.setCodigoPostal(5540);
			domi5.setFechaAlta(new Date(1-10-2023));
			domi5.setFechaBaja(null);
			domi5.setFechaModificacion(null);
			domi5.setCliente(cliente5);
			domi5.setCliente(cliente5);
			domicilioRepository.save(domi5);

			Cliente cliente6 = new Cliente();
			cliente6.setNombre("El Nachin");
			cliente6.setApellido("Arnold");
			cliente6.setEmail("enarnold@hotmail.com");
			cliente6.setFechaAlta(new Date(1-10-2023));
			cliente6.setFechaBaja(null);
			cliente6.setFechaModificacion(null);
			cliente6.setTelefono("2604561234");

			Usuario user6 = new Usuario();
			user6.setFechaAlta(new Date(1-10-2023));
			user6.setFechaBaja(null);
			user6.setFechaModificacion(null);
			user6.setRol(Rol.CLIENTE);
			user6.setUsername("heyarnold");
			user6.setPassword("eh?<gira>");
			user6.setActivo(true);
			usuarioRepository.save(user6);

			cliente6.setUsuario(user6);
			clienteRepository.save(cliente6);

			Domicilio domi6 = new Domicilio();
			domi6.setCalle("Al Lado del Vecino");
			domi6.setCodigoPostal(5500);
			domi6.setFechaAlta(new Date(1-10-2023));
			domi6.setFechaBaja(null);
			domi6.setFechaModificacion(null);
			domi6.setCliente(cliente6);
			domi6.setCliente(cliente6);
			domicilioRepository.save(domi6);


			//----------------------------------------------PEDIDOS EXTRAS PARA PRUEBAS DE FABRI

			Pedido pedido2 = new Pedido();
			pedido2.setCliente(cliente2);


			pedido2.setDomicilio(domi2);
			pedido2.setEstado(CANCELADO);
			fecha.set(2023, 8, 10);
			pedido2.setFechaPedido(fecha.getTime());
			pedido2.setFormaPago(EFECTIVO);
			pedido2.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido2.setTipoEnvio(DELIVERY);
			pedido2.setTotal(BigDecimal.valueOf(2500));
			pedido2.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido2);


			Pedido pedido3 = new Pedido();
			pedido3.setCliente(cliente3);

			pedido3.setDomicilio(domi3);
			pedido3.setEstado(PAGADO);
			fecha.set(2023, 10, 22);
			pedido3.setFechaPedido(fecha.getTime());
			pedido3.setFormaPago(EFECTIVO);
			pedido3.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido3.setTipoEnvio(DELIVERY);
			pedido3.setTotal(BigDecimal.valueOf(2500));
			pedido3.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido3);


			Pedido pedido4 = new Pedido();
			pedido4.setCliente(cliente2);

			pedido4.setDomicilio(domi2);
			pedido4.setEstado(COMPLETADO);
			fecha.set(2023, 10 ,20);
			pedido4.setFechaPedido(fecha.getTime());
			pedido4.setFormaPago(EFECTIVO);
			pedido4.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido4.setTipoEnvio(DELIVERY);
			pedido4.setTotal(BigDecimal.valueOf(2500));
			pedido4.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido4);


			Pedido pedido5 = new Pedido();
			pedido5.setCliente(cliente4);

			pedido5.setDomicilio(domi4);
			pedido5.setEstado(PAGADO);
			fecha.set(2023, 11, 15);
			pedido5.setFechaPedido(fecha.getTime());
			pedido5.setFormaPago(EFECTIVO);
			pedido5.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido5.setTipoEnvio(DELIVERY);
			pedido5.setTotal(BigDecimal.valueOf(2500));
			pedido5.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido5);


			Pedido pedido6 = new Pedido();
			pedido6.setCliente(cliente4);

			pedido6.setDomicilio(domi4);
			pedido6.setEstado(CANCELADO);
			fecha.set(2023, 11, 8);
			pedido6.setFechaPedido(fecha.getTime());
			pedido6.setFormaPago(EFECTIVO);
			pedido6.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido6.setTipoEnvio(DELIVERY);
			pedido6.setTotal(BigDecimal.valueOf(2500));
			pedido6.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido6);


			Pedido pedido7 = new Pedido();
			pedido7.setCliente(cliente5);

			pedido7.setDomicilio(domi5);
			pedido7.setEstado(CANCELADO);
			fecha.set(2023, 11, 5);
			pedido7.setFechaPedido(fecha.getTime());
			pedido7.setFormaPago(EFECTIVO);
			pedido7.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido7.setTipoEnvio(DELIVERY);
			pedido7.setTotal(BigDecimal.valueOf(2500));
			pedido7.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido7);


			Pedido pedido8 = new Pedido();
			pedido8.setCliente(cliente5);

			pedido8.setDomicilio(domi5);
			pedido8.setEstado(PAGADO);
			fecha.set(2023, 11, 1);
			pedido8.setFechaPedido(fecha.getTime());
			pedido8.setFormaPago(EFECTIVO);
			pedido8.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido8.setTipoEnvio(DELIVERY);
			pedido8.setTotal(BigDecimal.valueOf(2500));
			pedido8.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido8);


			Pedido pedido9 = new Pedido();
			pedido9.setCliente(cliente2);

			pedido9.setDomicilio(domi2);
			pedido9.setEstado(PAGADO);
			fecha.set(2023, 10, 30);
			pedido9.setFechaPedido(fecha.getTime());
			pedido9.setFormaPago(EFECTIVO);
			pedido9.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido9.setTipoEnvio(DELIVERY);
			pedido9.setTotal(BigDecimal.valueOf(2500));
			pedido9.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido9);


			Pedido pedido10 = new Pedido();
			pedido10.setCliente(cliente2);

			pedido10.setDomicilio(domi2);
			pedido10.setEstado(PAGADO);
			fecha.set(2023, 11, 21);
			pedido10.setFechaPedido(fecha.getTime());
			pedido10.setFormaPago(EFECTIVO);
			pedido10.setHoraEstimadaFinalizacion(LocalTime.now());//ver
			pedido10.setTipoEnvio(DELIVERY);
			pedido10.setTotal(BigDecimal.valueOf(2500));
			pedido10.setTotalCosto(BigDecimal.valueOf(1200));
			pedidoRepository.save(pedido10);


		};
	}
}
