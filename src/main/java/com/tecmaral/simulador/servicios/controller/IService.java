package com.tecmaral.simulador.servicios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import com.tecmaral.simulador.excepciones.ApplicationException;

public interface IService {

	/**
	 * 
    GET /servicio/operacion- Devuelve una lista de tickets
    GET /servicio/operacion/id- Devuelve un ticket específico
    POST /servicio/operacion- Crea un nuevo ticket
    PUT /servicio/operacion/12- Actualiza el ticket #12
    PATCH /servicio/operacion/12- Actualiza parcialmente el ticket #12
    DELETE /servicio/operacion/12- Elimina el ticket #12
    
      @PathVariable is very useful for dynamic URIs.
    There is no limit on the number of parameters used in a single method. You can use more than one dynamic parameter in a single method’s parameter.
    This can be used with Map argument. Parameters will be populated to the Map object.
     Argument can be of any simple type such as int, long, Date, etc.
	 */
	
	@RequestMapping(method =	RequestMethod.GET,value = "/srv/mapa")
	public Map<String, ?> getServicioMapa() throws ApplicationException;
	

	@RequestMapping(method =	RequestMethod.GET,value = "/srv/lista")
	public List<?> getServicioLista() throws ApplicationException;


	@RequestMapping( method = RequestMethod.GET, value = "/srv/lista/{id}")
	public ResponseEntity<?>  findById(@PathVariable String id) throws ApplicationException;


    //-------------------  GETFind Entity--------------------------------------------------------
	//srv/login/user
	
    //-------------------  GETFind Entity--------------------------------------------------------
	//,method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE
	@RequestMapping(value = "/srv/{servicio}/{operacion}/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>  getEntity(@PathVariable String servicio,@PathVariable String operacion,@PathVariable String id) throws ApplicationException;

	
    
    //-------------------Create a Entity--------------------------------------------------------
    @RequestMapping(value = "/srv/{servicio}/{operacion}/{id}", method = RequestMethod.POST)
    public  ResponseEntity<?> createEntity(@PathVariable String servicio,@PathVariable String operacion,@RequestBody Map<String,?> mapa);
 
     
    //------------------- Update a Entity --------------------------------------------------------
    @RequestMapping(value = "/srv/{servicio}/{operacion}/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEntity(@PathVariable String servicio,@PathVariable String operacion, @PathVariable("id") String id, @RequestBody Map<String,?> mapa) ;
        
       
    
	
//	@RequestMapping(method = RequestMethod.GET, value= "/srv/{name}")
//	String hello(@PathVariable String name) ;

}
