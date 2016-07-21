package com.tecmaral.simulador.servicios.model;

/**
 * Interfaz de respuesta del Servicio
 * @author Indra
 */
public interface ServiceResponseDTO 
{
    /**
     * Si/No el objeto esta acorde con su correspondiente esquema
     * @return boolean
     */
    public boolean isValid();
    
    /**
     * Escribe en el out el xml que corresponde con esta respuesta
     * @param out
     * @throws org.exolab.castor.xml.MarshalException
     * @throws org.exolab.castor.xml.ValidationException
     
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException;
*/
    /**
     * Devuelve la version de la respuesta
     * @return java.lang.String
     */
    public java.lang.String getVer();
    
    /**
     * Devuelve el codigo de respuesta asociado a la solicitud
     * @return long
     */
    public long getResponseCode();
    
    /**
     * Devuelve la descripcion del codigo de respuesta asociado a la solicitud
     * @return java.lang.String
     */
    public java.lang.String getResponseDesc();
    
    /**
     * Devuelve el token asociado a la respuesta
     * @return java.lang.String
     */
    public java.lang.String getToken();
    
    /**
     * Devuelve el token uuid a la respuesta.
     * Donde uuid es "universal user identifier" o identificador de usuario universal
     * @return java.lang.String
     */
    public java.lang.String getUuid();
    
    /**
     * Devuelve el tipo de uuid a la respuesta.
     * Donde uuid es "universal user identifier" o identificador de usuario universal
     * @return java.lang.String
     */
    public java.lang.String getUuidType();    
    
    /**
     * Devuelve el perfil asociado a la respuesta en formato String.<br>
     * Solo valido para versiones iguales o superiores a la 2.0.<br>
     * Para versiones inferiores se devuelve null.
     * 
     * @return java.lang.String
     */
    public java.lang.String getProfileString();
    
    /**
     * Devuelve el identificador del cliente asociado a la respuesta.<br>
     * Solo valido para versiones iguales o superiores a la 2.0.<br>
     * Para versiones inferiores se devuelve null.
     * 
     * @return java.lang.String
     */
    public java.lang.String getCustomerId();
    
	/**
	 * Devuelve las variables asociadas a la respuesta en formato Map.<br>
     * Solo valido para versiones iguales o superiores a la 2.1.<br>
     * Para versiones inferiores se devuelve null.
     * 
	 * @return java.util.Map{String, String}
	 */
	public java.util.Map<java.lang.String, java.lang.String> getVariablesMap();
	
	/**
	 * Devuelve la jerarquia de cuentas asociada al token.<br>
     * Solo valido para versiones iguales o superiores a la 3.0.<br>
     * Para versiones inferiores se devuelve null.
     * 
	 * @return es.indra.vodafone.sso.response.xml.ver30.Accounts
	
	public es.indra.vodafone.sso.response.xml.ver30.Accounts getAccounts();	
	 */
    /**
     * Devuelve el numero de intentos de validacion de clave con clave incorrecta.
     */
    public Long getNumInvalidPasswords();	
    
    /**
     * Devuelve informacion adicional sobre la creacion del token
     
    public es.indra.vodafone.sso.response.xml.ver30.CreationInfo getCreationInfo();
    */
    /**
     * Devuelve informacion adicional sobre el error. Solo para version 3.0
    
    public es.indra.vodafone.sso.response.xml.ver30.ErrorDetail getErrorDetail();
     */
}
