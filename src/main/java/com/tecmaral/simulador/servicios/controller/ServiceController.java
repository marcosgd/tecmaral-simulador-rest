package com.tecmaral.simulador.servicios.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.excepciones.ErrorDetail;
import com.tecmaral.simulador.servicios.abstraccion.ServiceMockFile;

/**
 * Anotaciones en esta clase
 * @author mgonzalezdi
 *
 */

@RestController
public class ServiceController implements IService {

	   
    private IService serviceMockFile = new ServiceMockFile();
    
	private static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);

   
	@Override
	public Map<String, ?> getServicioMapa() throws ApplicationException {
		LOG.debug("[getServicioMapa]");
		return serviceMockFile.getServicioMapa();
	}


	@Override
	public List<?> getServicioLista() throws ApplicationException {
		LOG.debug("[getServicioLista]");
		return serviceMockFile.getServicioLista();
	}

	public ResponseEntity<?> findById(@PathVariable String id) throws ApplicationException {
		LOG.debug("[findById]");
		return serviceMockFile.findById(id);
		
	}
     
	  

	
	@Override
	public ResponseEntity<?> getEntity(@PathVariable String servicio,@PathVariable String operacion,@PathVariable String id) throws ApplicationException {
		
		LOG.debug("[getJson][servicio:{}][operacion:{}]",servicio,operacion);
		LOG.debug("[getJson][id:{}]",id);
		return serviceMockFile.getEntity(servicio,operacion,id);
	}


	@Override
	public ResponseEntity<?> createEntity(String servicio, String operacion,
			Map<String, ?> mapa) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<?> updateEntity(String servicio, String operacion,
			String id, Map<String, ?> mapa) {
		// TODO Auto-generated method stub
		return null;
	}

	@ExceptionHandler(Exception.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
		LOG.error("[myError]",exception);
	    ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().toString());
	    LOG.error("[myError][error:{}]",error);
	    return error;
	}

}