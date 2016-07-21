package com.tecmaral.simulador.servicios.abstraccion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.controller.FacturasController;

public  class JsonConverter {

	private static final Logger LOG = LoggerFactory.getLogger(FacturasController.class);

	 public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private Class<?> targetClass;
		
	public static <T> T fromJSON(final TypeReference<T> type,
		      final String jsonPacket) throws ApplicationException {
		   T data = null;

		   try {
		      data = OBJECT_MAPPER.readValue(jsonPacket, type);
		   } catch (Exception e) {
			   LOG.debug("[fromJSON]",e);
				   throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
		   }
		   return data;
		}
	
	
	
	
	public List<?> jsonToJava(File file) throws ApplicationException{
		List<?> objeto = null;
		try {
			 objeto = OBJECT_MAPPER.readValue(file, List.class);
			
		}catch (Exception e){
	        throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
		}
		return objeto;
	}

	public Map<String, ?> jsonToMap(String file) throws ApplicationException{
		//converting json to Map
		
		Map<String, Object> map = new HashMap<String, Object>();

		// convert JSON string to Map
		try {
			map = OBJECT_MAPPER.readValue(file, new TypeReference<Map<String, ?>>(){});
		}catch (Exception e){
	        throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
		}	
		LOG.debug("map",map);
		
		return map;
	}
	

   
	public ArrayList<?> jsonToList(File json) throws ApplicationException{
		try {
	        AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
	
	        OBJECT_MAPPER.getDeserializationConfig().with(introspector);
	        OBJECT_MAPPER.getSerializationConfig().with(introspector);
	
	        JavaType type = OBJECT_MAPPER.getTypeFactory().
	                    constructCollectionType(ArrayList.class, targetClass) ;
	    
	               ArrayList<?> temp = (ArrayList<?>) OBJECT_MAPPER.readValue(json,  type);
	        return temp ;
        }catch (Exception e){
         throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
        }
    }  
	 
	 public List<?> jsonToList2(File json) throws ApplicationException{
       
		 try{             
			 List<?> temp = (List<?>) OBJECT_MAPPER.readValue(json,  new TypeReference<List<?>>(){});
			 return temp ;
		 }catch (Exception e){
			 throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
		 }
	 }
	 
	 public List<?> jsonToList2(String json) throws ApplicationException{
	       
		 try{             
			 List<?> temp = (List<?>) OBJECT_MAPPER.readValue(json,  new TypeReference<List<?>>(){});
			 return temp ;
		 }catch (Exception e){
			 throw new ApplicationException(ApplicationException.JSON_CONVERTER_ERROR, e.getMessage());
		 }
	 }
	 
}
