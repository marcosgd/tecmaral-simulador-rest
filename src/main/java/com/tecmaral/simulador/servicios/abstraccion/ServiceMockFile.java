package com.tecmaral.simulador.servicios.abstraccion;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.controller.IService;

public class ServiceMockFile implements IService {

	
	private static final String PATH_DEFAULT= "json/";
	private static final String EXT_DEFAULT= ".json";
	
	private  String basePath= PATH_DEFAULT;
	private  String extension= EXT_DEFAULT;
	
	
	
	private static JsonConverter jsonConverter = new JsonConverter();
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceMockFile.class);


	public ServiceMockFile(){
		this.basePath = PATH_DEFAULT;
		  LOG.debug("[ServiceMockFile][CONF][basePath:{}]",this.basePath);
	}

	public ServiceMockFile(String resource,String extension){
		
	  if (StringUtils.isBlank(resource)){
		  this.basePath = resource;
	  } 
	  
	  if (StringUtils.isBlank(extension)){
		  this.extension = extension;
	  } 
	  LOG.debug("[ServiceMockFile][CONF][update][basePath:{}]",this.basePath);
	}
	
	

	@Override
	public ResponseEntity<?> findById(String id) throws ApplicationException {
		LOG.debug("[findById][CONF][id:{}]",id);
		try{
			String path = this.basePath+"facturas.json";
			
			if (id.equals("30")) throw new ApplicationException(ApplicationException.JSON_SERVICE_ERROR, "No es normal ese valor !!!!");
			InputStream jsonIS = ClassLoader.getSystemResourceAsStream(path);
			String json = IOUtils.toString(jsonIS);	
			List<?>  valores = jsonConverter.jsonToList2(json); 
			Object valor = valores.get(Integer.parseInt(String.valueOf(id)));
			ResponseEntity<?> reponseEntity=  new ResponseEntity<Object>(valor, HttpStatus.OK);
			return reponseEntity	;
		} catch (Exception e) {
			LOG.error("[getServicioMapa]",e);
			throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR);
		}

	}
	
	@Override
	public Map<String, ?> getServicioMapa() throws ApplicationException {
	
		LOG.debug("[ServiceMockFile][getServicioMapa]");
		try {
			String path = this.basePath+"facturas"+this.extension;
			InputStream jsonIS = ClassLoader.getSystemResourceAsStream(path);
			String json = IOUtils.toString(jsonIS);	
			Map<String, ?>  valores = jsonConverter.jsonToMap(json); 
			return valores;
		} catch (Exception e) {
			LOG.error("[getServicioMapa]",e);
			throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR);
		}
	}
	
	
	@Override
	public List<?> getServicioLista() throws ApplicationException {
		LOG.debug("[ServiceMockFile][getServicioLista]");
		try {
			String path = this.basePath+"facturas"+this.extension;
			InputStream jsonIS = ClassLoader.getSystemResourceAsStream(path);
			String json = IOUtils.toString(jsonIS);
			List<?>  valores = jsonConverter.jsonToList2(json);
			return valores;
		} catch (Exception e) {
			LOG.error("[getServicioLista]",e);
			throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR);
		}
		
	}


	@Override
	public ResponseEntity<?> getEntity(String servicio, String operacion,String id) throws ApplicationException {
		LOG.debug("[ServiceMockFile][getEntity]");
		ResponseEntity<?> reponseEntity=null;
		try{
			String path = this.basePath+servicio+operacion+id+EXT_DEFAULT;
			LOG.debug("[ServiceMockFile][getEntity:{}]",path);
			InputStream jsonIS = ClassLoader.getSystemResourceAsStream(path);
			String json =IOUtils.toString(jsonIS);
			//Map<String,?>  valores = jsonConverter.jsonToMap(json); 
			 reponseEntity=  new ResponseEntity<Object>(json, HttpStatus.OK);
			 return reponseEntity;
		
		}catch (Exception es){
			LOG.error("[getEntity]",es);
			throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR);
		}
		
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
	
	
	
}
