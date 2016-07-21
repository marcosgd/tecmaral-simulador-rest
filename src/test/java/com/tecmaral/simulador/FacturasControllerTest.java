package com.tecmaral.simulador;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.abstraccion.JsonConverter;
import com.tecmaral.simulador.servicios.model.facturas.Factura;

/**
 * 
 * @author mgonzalezdi
 *mvn -Dtest=FacturasControllerTest test -Djava.net.preferIPv
 *
 *
 *C:\Users\mgonzalezdi>curl -XGET http://127.0.0.1:8080/facturas/
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class FacturasControllerTest {

	//Test RestTemplate to invoke the APIs.
	 private RestTemplate restTemplate = new TestRestTemplate();
	 public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	 private static final Logger LOG = LoggerFactory.getLogger(FacturasControllerTest.class);
	 final String BASE_URL = "http://127.0.0.1:8080/facturas/";

	  
	@Test
	public void testGetFacturas() {
		
		LOG.debug("[testGetFacturas][ini]");
		
		// fallo sinproxy
		List<Factura> apiResponse  = restTemplate.getForObject(BASE_URL,List.class);

		  //Asserting la respuesta
		assertNotNull(apiResponse);
		assertTrue(!apiResponse.isEmpty());

		LOG.debug("[testGetFacturas][apiResponse:{}]",apiResponse);
		
		  
		LOG.debug("[testGetFacturas][fin]");
		  
		  	 
	}

	
	@Test
	public void testGetFacturas2() {
		
		LOG.debug("[testGetFacturas2][ini]");
		
		// fallo sinproxy
		//String apiResponse  = restTemplate.getForObject("http://127.0.0.1:8080/facturas/ultima",String.class);
		//assertNotNull(apiResponse);
		ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL, String.class);

		LOG.debug("[testGetFacturas2][Headers:{}]", response.getHeaders());
    	LOG.debug("[testGetFacturas2][Body:{}]", response.getBody());
    	LOG.debug("[testGetFacturas2][StatusCode:{}]", response.getStatusCode());
    	
	    assertTrue(response.getStatusCode() == HttpStatus.OK);
	    
	    try {
	    
	    	List<Factura> facturas = JsonConverter.fromJSON(new TypeReference<List<Factura>>() {}, response.getBody());
			LOG.debug("[testGetFacturas2][Facturas:{}]", facturas);
	    } catch (ApplicationException e) {
			
			LOG.error("[testGetFacturas2][error:{}][!!!!]", e);
			
		}
		    	
		    
		    
		    
		
	
	    //assertThat( messageJson.isMissingNode() , is(false) );
	  //  assertThat( messageJson.asText() , equalTo(EXPECTED_ANSWER_MESSAGE) );
		 //Asserting the response of the API.
		  
		LOG.debug("[testGetFacturas][fin]");
		  
		  	 
	}

}
