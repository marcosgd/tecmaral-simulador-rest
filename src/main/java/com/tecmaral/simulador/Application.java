package com.tecmaral.simulador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * POSTMAN para chrome
 * @author mgonzalezdi
 *
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application{

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	
  	public static String getHelloWorld() {

			return "Hello World";

	}

	public static String getHelloWorld2() {

			return "Hello World 2";
	}
	
	public static void main(String[] args) {

		LOG.debug("[Iniciando aplicacion][!!!]" );
		
		SpringApplication.run(Application.class, args);
	}
	
//	@Override
//    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
}