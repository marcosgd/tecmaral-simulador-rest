package com.tecmaral.simulador;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
 
/**
 * 
 * @author mgonzalezdi
 *mvn -Dtest=FacturasControllerTest test -Djava.net.preferIPv
 *
 *
 *C:\Users\mgonzalezdi>curl -XGET http://127.0.0.1:8080/srv/
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ServiceControllerTest {

	//Test RestTemplate to invoke the APIs.
	 private RestTemplate restTemplate = new TestRestTemplate();
	 public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	 private static final Logger LOG = LoggerFactory.getLogger(ServiceControllerTest.class);
	 final String BASE_URL = "http://127.0.0.1:8080/srv/";

	  
	@Test
	public void testGetLoginUser() {
		
		LOG.debug("[testGetLoginUser][ini]");
		
		// fallo sinproxy
		String apiResponse  = restTemplate.getForObject(BASE_URL+"login/user/99999805Z",String.class);

		 //Asserting la respuesta
		assertNotNull(apiResponse);
		assertTrue(!apiResponse.isEmpty());

		LOG.debug("[testGetLoginUser][testGetLoginUser:{}]",apiResponse);
		
		  
		LOG.debug("[testGetLoginUser][fin]");
		  
		  	 
	}

	

}
