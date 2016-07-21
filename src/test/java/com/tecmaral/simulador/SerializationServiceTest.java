package com.tecmaral.simulador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecmaral.domain.user.*;
import com.tecmaral.simulador.servicios.abstraccion.SerializationService;
import com.tecmaral.simulador.servicios.abstraccion.SerializationServiceJAXB;

/**
 * 
 * @author mgonzalezdi
 *mvn -Dtest=TestApp1 test -Djava.net.preferIPv
 *
 */
public class SerializationServiceTest {

	
		SerializationService service = new SerializationServiceJAXB();
		
		ObjectMapper JSON_MAPPER = new ObjectMapper();


		
		@Test
		public void testJsonDTO() {

		
			 InputStream xmlis = ClassLoader.getSystemResourceAsStream("xml/user.xml");
			 String 	xml = "";
			 try {
				xml =IOUtils.toString(xmlis);
			
					
			//toObject 
			Object o = service.toObject(com.tecmaral.domain.user.Usuario.class, xml);
			Usuario user = (Usuario) o;
			Assert.assertNotNull(user);
//			User user = getUserFromSsoResponse(ssoResponse);
//			System.out.println(user);
			JSON_MAPPER.writeValue(new File("src/main/resources/xml/mijsonFronJava.json"), user);
			
			 } catch (IOException e) {
					
					e.printStackTrace();
					Assert.fail("Failure here");
				}
			
			
			//toXml
		
			
			//toObject

		}
		


	
}
