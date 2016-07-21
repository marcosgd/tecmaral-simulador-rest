package com.tecmaral.simulador;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecmaral.domain.user.Usuario;


/**
 * 
 * @author mgonzalezdi
 *mvn -Dtest=TestApp1 test -Djava.net.preferIPv
 *
 */
public class SerializationServiceJsonTest {
		@Test
		public void testUserJsonDTO() {

		
			 InputStream xmlis = ClassLoader.getSystemResourceAsStream("json/user.json");
			 String 	json = "";
			 try {
				json =IOUtils.toString(xmlis);
				System.out.print(json);
				ObjectMapper mapper = new ObjectMapper();
				// mapea a blanco
 				 // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				 mapper.addMixInAnnotations(Usuario.class, IgnoreFooSetValueIntMixIn.class);
				 mapper.addMixInAnnotations(com.tecmaral.domain.user.Usuario.class, IgnoreFooSetValueIntMixIn.class);
				 mapper.addMixInAnnotations(com.tecmaral.domain.user.DatosAdicionalesType.class, IgnoreFooSetValueIntMixIn.class);
				 mapper.addMixInAnnotations(com.tecmaral.domain.user.DatosIdentificacion.class, IgnoreFooSetValueIntMixIn.class);
				 mapper.addMixInAnnotations(com.tecmaral.domain.user.comun.datoscontacto.DatosContacto.class, IgnoreFooSetValueIntMixIn.class);
				 mapper.addMixInAnnotations(com.tecmaral.domain.user.comun.datoscontacto.DatosAdicionalesContacto.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CARRITO_NO_RESERVADAS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CATEGORIAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CARRITO_ELEMENTO.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.PRODUCTOS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.HIJAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CARRITO_COTO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CARRITO_PARTNERS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.RESERVA_PRODUCTOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CARRITO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CALCULO_PRECIOS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.DatosContratoPDFBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.PROMOCIONES.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CUENTAS_ASOCIADAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.MSISDN_ASOCIADOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CATALOGOS_COLECTIVOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.PUNTOS_PARTNERS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.BLOQUEOS_ACTIVOS_EMPRESA.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.TIPO_CLIENTE.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LINEAS_CADUCIDAD.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CLIENTE_PROMOCION_PARTICULAR.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.DatosPromocionClienteBean.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.LISTA_CUENTA_RENOVACION_ASEGURADA.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.HISTORICO_ESTADOS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.Provincias.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.Poblaciones.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.MEDIOS_PAGO_MEDIOS_PAGO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.Historico_Puntos.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.ListaStockSAPBean.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.Historico_Pedidos.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.CANTIDADES.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandobean.ARTICULOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.cif.CIF.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.cif.Cuenta.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.cif.SubCuenta.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.Paquete.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.Linea.class, IgnoreFooSetValueIntMixIn.class);
//				 //mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.Producto.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.Atributos.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LineaSinPermanenciaEmpresaGBean.class, IgnoreFooSetValueIntMixIn.class);				 
//				// mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.MEDIOS_PAGO_MEDIOS_PAGO.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.CARRITO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LINEAS_CARRITO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.ELEMENTOS_DTOVOLUMEN.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.ORDEN_ELEMENTOS_LINEA.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LINEAS_CARRITO_COTO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LINEAS_CARRITO_PARTNERS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.CATEGORIAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LINEAS_CARRITO_ELEMENTO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LISTADO_AHORROS_PTOS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.PRODUCTOS.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.HIJAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LISTADO_TRAMOS_DTOVOLUMEN.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.CALCULO_PRECIOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DESGLOSE_AHORROS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DISPONIBLES_GAMAS_PEDIDO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DISPONIBLES_GAMAS_PEDIDO_ANTERIOR.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LINEAS_CARRITO_NO_RESERVADAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.RESERVA_PRODUCTOS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.ORDEN_ELEMENTOS_CARRITO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DESGLOSE_AHORROS_CESTA.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.PROMOCIONES.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DATOS_ENVIO.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.BLOQUEOS_ACTIVOS_EMPRESA.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.LISTA_CUENTA_RENOVACION_ASEGURADA.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.CUENTAS_ASOCIADAS.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.PRODUCTO_IBT.class, IgnoreFooSetValueIntMixIn.class);
////				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.TIPO_CLIENTE.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DatosAutorizadosCIFGBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.Cuentas.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.ServiciosSinPermanencia.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DatosAutorizadosIBT.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.Distribuidores.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.ListaStockSAPBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.HistoricoPedidosEmpresaGBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.HistoricoPuntosEmpresaGBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.DetallePedidoEmpresaBean.class, IgnoreFooSetValueIntMixIn.class);
//				 mapper.addMixInAnnotations(com.indra.vodafone.common.domain.amdocs.user.datoscomandoempresabean.TerminalPedidoEmpresa.class, IgnoreFooSetValueIntMixIn.class);
//				 
				 
				 //mapper.getDeserializationConfig().getHandlerInstantiator().
				 
				
				//JSON from file to Object
				Usuario user = mapper.readValue(json, Usuario.class);
				String nombre =user.getDatosContacto().getNombre();
				System.out.println("Nombre json To Java:"+nombre);
				Assert.assertEquals(nombre, "Marcos");
			
			 } catch (Exception e) {
					
					e.printStackTrace();
					Assert.fail("Failure here");
				}
			
			
			//toXml
		
			 
			//toObject

		}
		
		
		abstract class IgnoreFooSetValueIntMixIn
		{
		//  @JsonIgnore public abstract void setCIF(List cif);
//		  @JsonIgnore public abstract void setFacturaWeb(List facturaWeb);
//		  @JsonIgnore public abstract void setGRE(List gre);
//		  @JsonIgnore public abstract void setNBA(List nba);
//		  @JsonIgnore public abstract void setDatosContratoPDFBean(List datos);
//		  @JsonIgnore public abstract void setLineaCarritoBean(List datos);
//		  @JsonIgnore public abstract void setCATEGORIASItem(List datos);
//		  @JsonIgnore public abstract void setLineaCarritoElementoBean(List datos);
//		  @JsonIgnore public abstract void setPRODUCTO(List datos);
//		  @JsonIgnore public abstract void setHIJA(List datos);
//		  @JsonIgnore public abstract void setLineaCarritoCotoBean(List datos);
//		  @JsonIgnore public abstract void setLineaCarritoPartnersBean(List datos);
//		  @JsonIgnore public abstract void setReservaProductoBean(List datos);
//		  @JsonIgnore public abstract void setCalculoPrecioBean(List datos);
//		  @JsonIgnore public abstract void setDatosAutorizadoBean(List datos);
//		  @JsonIgnore public abstract void setDatosEnvioBean(List datos);
//		  @JsonIgnore public abstract void setChargesBean(List datos);
//		  @JsonIgnore public abstract void setPromocionActivaBean(List datos);
//		  @JsonIgnore public abstract void setPSAIR(List datos);
//		  @JsonIgnore public abstract void setPSAIR_CUENTA(List datos);
//		  @JsonIgnore public abstract void setMsisdnAsociadoBean(List datos);
//		  @JsonIgnore public abstract void setCatalogoBean(List datos);
//		  @JsonIgnore public abstract void setPuntosPartnerBean(List datos);
//		  @JsonIgnore public abstract void setDetalleBloqueoBean(List datos);
//		  @JsonIgnore public abstract void setTIPOLOGIAS_PEDIDOS(List datos);
//		  @JsonIgnore public abstract void setZONAS_ENTREGA(List datos);
//		  @JsonIgnore public abstract void setCaducidadClientePuntosBean(List datos);
//		  @JsonIgnore public abstract void setDatosPromocionClienteBean(List datos);
//		  @JsonIgnore public abstract void setLISTA_CLIENTES(List datos);
//		  @JsonIgnore public abstract void setCUENTA_AIRTEL(List datos);
//		  @JsonIgnore public abstract void setHISTORICO_ESTADO(List datos);
//		  @JsonIgnore public abstract void setProvinciaBean(List datos);
//		  @JsonIgnore public abstract void setBusquedaPoblacionBean(List datos);
//		  @JsonIgnore public abstract void setMEDIO_PAGO(List datos);
//		  @JsonIgnore public abstract void setHistoricoPuntosBean(List datos);
//		  @JsonIgnore public abstract void setInfoStockSAPBean(List datos);
//		  @JsonIgnore public abstract void setHistoricoPedidosBean(List datos);
//		  @JsonIgnore public abstract void setCANTIDAD(List datos);
//		  @JsonIgnore public abstract void setARTICULO(List datos);
//		  @JsonIgnore public abstract void setCuenta(List datos);
//		  @JsonIgnore public abstract void setLinea(List datos);
//		  @JsonIgnore public abstract void setPaquete(List datos);
//		  @JsonIgnore public abstract void setProducto(List datos);
//		  @JsonIgnore public abstract void setSubCuenta(List datos);
//		  @JsonIgnore public abstract void setPermanencia(List datos);
//		  @JsonIgnore public abstract void setAtributo(List datos);
//		  @JsonIgnore public abstract void setLineaSinPermanenciaEmpresaB(List datos);
//		  @JsonIgnore public abstract void setLineaSinPermanenciaEmpresaBean(List datos);
//		  @JsonIgnore public abstract void setDISPONIBLES_GAMAS_PEDIDO(List datos);
//		  @JsonIgnore public abstract void setDISPONIBLES_GAMAS_PEDIDO_ANTERIOR(List datos);
//		  @JsonIgnore public abstract void setReferenciaProducto(List datos);
//		  @JsonIgnore public abstract void setTramo(List datos);
//		  @JsonIgnore public abstract void setOrdenElementoLinea(List datos);
//		  @JsonIgnore public abstract void setCATEGORIA(List datos);
//		  @JsonIgnore public abstract void setAhorroBean(List datos);
//		  @JsonIgnore public abstract void setTramoDtoVolumenBean(List datos);
//		  @JsonIgnore public abstract void setDescripcionAhorro(List datos);
//		  @JsonIgnore public abstract void setPtosAhorro(List datos);
//		  @JsonIgnore public abstract void setImporteGama(List datos);
//		  @JsonIgnore public abstract void setProductoSKU(List datos);
//		  @JsonIgnore public abstract void setProductoBean(List datos);
//		  @JsonIgnore public abstract void setDatosAutorizadoCIFBean(List datos);
//		  @JsonIgnore public abstract void setID_CUENTA(List datos);
//		  @JsonIgnore public abstract void setMSISDN(List datos);
//		  @JsonIgnore public abstract void setDatosDistribuidorBean(List datos);
//		  @JsonIgnore public abstract void setHistoricoPedidosEmpresaBean(List datos);
//		  @JsonIgnore public abstract void setHistoricoPuntosEmpresaBean(List datos);
//		  @JsonIgnore public abstract void setTerminalPedidoEmpresa(List datos);
//		  @JsonIgnore public abstract void setPAGO_APLAZADO(List datos);
		  
		  @JsonIgnore public abstract void setDatosAdicionales(List datos);
		  @JsonIgnore public abstract void setDatosIdentificacion(List datos);
		  @JsonIgnore public abstract void setDatosContacto(List datos);	  
		}

} 
