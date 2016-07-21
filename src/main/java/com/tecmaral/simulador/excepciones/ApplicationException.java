package com.tecmaral.simulador.excepciones;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




/**
 * Excepcion generica utilizada en la aplicacion. Encapsula informacion del codigo de error y la descripcion del error
 * @author Indra
 *
 */

@ControllerAdvice
public class ApplicationException extends Exception {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationException.class);

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7302408439888305112L;

	/**
	 * Constante que identifica un error generico (no identificado)
	 */
	public final static String GENERIC_ERROR="1000";
	
	public final static String JSON_CONVERTER_ERROR="2000";
	
	public final static String JSON_SERVICE_ERROR="3000";
	
	private String code;
	private String description;
	private String originSystem;
	private boolean technicalError;
	//private ServiceResponseDTO ssoResponse;
	private int numIntentos;
	
	public ApplicationException(){
		
		this.code = GENERIC_ERROR;
		this.originSystem = "SimuladorRest";
	}
	
//	public ServiceResponseDTO getSsoResponse() {
//		return ssoResponse;
//	}
//
//	public void setSsoResponse(ServiceResponseDTO ssoResponse) {
//		this.ssoResponse = ssoResponse;
//	}

	
	
	public int getNumIntentos() {
		return numIntentos;
	}

	public void setNumIntentos(int numIntentos) {
		this.numIntentos = numIntentos;
	}

	/**
	 * A�ade el codigo de error y descripci�n al message de la excepci�n
	 */
	@Override
	public String getMessage() {
		
		String message = super.getMessage();
		String detailMessage = "Code: "  + getCode() + "; Description: " + getDescription();
		
		if (StringUtils.isEmpty(message))		
			return detailMessage;
		else 
			return message + "; " + detailMessage;
	}

	/**
	 * Obtiene el codigo del error
	 * @return String Codigo de la excepcion
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Especifica el codigo del error
	 * @param code Codigo de error
	 */
	public void setCode(String code) {
		this.code=code;
		
	}
	
	/**
	 * Constructor
	 * @param code Codigo del error
	 */
	public ApplicationException(String code) {
		super();
		this.code = code;
		this.description = "Not Available";
	}
	
	/**
	 * Constructor
	 * @param code Codigo del error
	 * @param description Descripcion del error
	 */
	public ApplicationException(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	/**
	 * Constructor
	 * @param code Codigo del error
	 * @param description Descripcion del error
	 * @param techincalError  Booleano que indica si el error es técnico
 	 */
	public ApplicationException(String code, String description, boolean technicalError) {
		super();
		this.code = code;
		this.description = description;
		this.technicalError = technicalError;
	}	
	
	/**
	 * Constructor
	 * @param code Codigo del error
	 * @param description Descripcion del error
	 */
	public ApplicationException(String code, String description, String originSystem, boolean technicalError) {
		super();
		this.code = code;
		this.description = description;
		this.originSystem = originSystem;
		this.technicalError = technicalError;
	}	
	

	/**
	 * Obtiene la descripcion del error
	 * @return String Descripcion del error
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Especifica la descripcion del error
	 * @param description Descripcion del error
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginSystem() {
		return originSystem;
	}

	public void setOriginSystem(String originSystem) {
		this.originSystem = originSystem;
	}

	/**
	 * Obtiene si es un error tecnico. 
	 * @return boolean
	 */
	public boolean isTechnicalError() {
		return technicalError;
	}

	/**
	 * Especifica si es un error tecnico.
	 * @param boolean technicalError
	 */
	public void setTechnicalError(boolean technicalError) {
		this.technicalError = technicalError;
	}
	
	
	/**
	 * Errores genericos no controlados
	 * @param request
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleSQLException(HttpServletRequest request, Exception ex){
		LOG.error("[ApplicationException][URL:{}][message:{}][!!!!]",request.getRequestURL(),ex.getLocalizedMessage());
		ErrorDetail error = new ErrorDetail();
		error.setCode(JSON_SERVICE_ERROR);
		error.setMessage(ex.getMessage());
		
		
		ResponseEntity<ErrorDetail> response = new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
        return response;
    }
}
