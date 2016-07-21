package com.tecmaral.simulador.servicios.abstraccion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SerializationServiceXStream implements SerializationService {
	
    private String path;
    
    private static final String encoding = "ISO-8859-1";
    private static final String XML = ".xml";
        
    private static final Logger log = LoggerFactory.getLogger(SerializationServiceXStream.class);
	
	private static SerializationServiceXStream instance = new SerializationServiceXStream();
	
	private static Map<String, String> mapaSessionContexto = new HashMap<String, String>();
	
	public static SerializationServiceXStream getInstance(){
		return instance;
	}
	/**
	 * Guarda un objeto en la carpeta: path/servicio_nombreClase
	 * 
	 * El archivo se llama: msisdn_contextoSimulador_currentTimeMillis.xml
	 * 
	 * @param objeto Objeto a guardar
	 * @param request request para sacar el msisdn
	 * @param servicio Nombre indentificativo del servicio
	 */
	public void save(Object objeto, String idSession, String msisdn, String servicio){
    	if(path == null || path.length() == 0 || idSession == null  || msisdn == null || servicio == null)return;
    	if(objeto == null)return;  
    	
    	FileOutputStream fos = null;
    	OutputStreamWriter osw = null;
    	
    	try {
    		
    		String nombreArchivo = msisdn;
    		String contextoSimulador = this.getContextoSimulador(idSession);
    		if(contextoSimulador != null)nombreArchivo = nombreArchivo + "_" + contextoSimulador;
    		
//    		if(!isSimuladorRegistradoBBDD(servicio, contextoSimulador))return;
    		
    		String nombreCarpeta = servicio.replace('.', File.separatorChar);
        	String pathCarpeta = path + nombreCarpeta;  
    		
    		crearCarpeta(pathCarpeta);
    		
    		File file = new File(pathCarpeta + File.separator + nombreArchivo + "_" + System.currentTimeMillis() + XML);

            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, encoding);
            
            XStream xStream = new XStream(new DomDriver(encoding));
            osw.write("<?xml version=\"1.0\" encoding=\"" + encoding + "\" ?>\n");
            xStream.toXML(objeto, osw);
            
            log.debug("Objeto guardado en simulador: " + file.toString());
            
        }catch(Exception e){
        	log.debug("Excepcion al guardar el objeto: "+e.getMessage());
        }
        finally{
        	try{
        		if(fos!=null)fos.close();
        		if(osw!=null)osw.close();
        	}catch(Exception e1){
        		log.debug("Excepcion al cerrar el Flujo de salida: "+e1.getMessage());
        	}
        }
    }
    
    /**
     * Carga el objeto dummy para la simulacion de la carpeta: path/servicio_nombreClase
     * Primero busca el objeto cuyo nombre es: msisdn_contextoSimulador.xml, si no lo encuentra
     * busca el objeto default_contextoSimulador.xml, asi se consiguen respuestas personalizadas por MSISDN.
     * 
     * Para que el simulador funcione debe existir en la configuraci�n una propiedad que se llame simulador.servicio_nombreClase puesta a true.
     * 
     * @param clase Clase que especifica el tipo de clase a recuperar
     * @param msisdn MSISDN del usuario
	 * @param servicio Nombre indentificativo del servicio
     * @return Objeto objeto dummy para simulacion
     */
    public Object load(String idSession, String msisdn, String servicio) throws com.tecmaral.simulador.excepciones.ApplicationException{
    	if(path == null || path.length() == 0 || idSession == null  || msisdn == null || servicio == null)return null;

    	Object objeto = null;
    	File file = null;
    	InputStreamReader reader = null;
        try {

    		String contextoSimulador = this.getContextoSimulador(idSession);
    		
        	file = getFile(contextoSimulador, msisdn, servicio);
        	if(file == null)return null;

        	reader = new InputStreamReader(new FileInputStream(file), encoding);

            XStream xStream = new XStream(new DomDriver(encoding));
            objeto = xStream.fromXML(reader);
            
            log.debug("Objeto recuperado del servicio: " + servicio);
            
        }catch(ApplicationException e){
        	throw e;
        }catch(Exception e){
        	log.debug("Excepcion al recuperar el objeto: "+e.getMessage());        	
        }finally {
            if (reader != null) {
            	try{
            		reader.close();
            	}catch(Exception e1){
            		log.debug("Excepcion al cerrar el Flujo de entrada: "+e1.getMessage());
            	}
            	
            }
        }
        return objeto;
    }
    
    private File getFile(String contextoSimulador, String msisdn, String servicio) throws Exception{
    	
//    	if(!isSimuladorRegistradoBBDD(servicio, contextoSimulador))return null;
    	
    	String nombreArchivo = msisdn;
    	String nombreDefault = "default";
		if(contextoSimulador != null)nombreArchivo = nombreArchivo + "_" + contextoSimulador;
		if(contextoSimulador != null)nombreDefault = nombreDefault + "_" + contextoSimulador;
		
    	String nombreCarpeta = servicio.replace('.', File.separatorChar);
    	String pathCarpeta = path + nombreCarpeta;  
    	
    	File file = new File(pathCarpeta + File.separator + nombreArchivo + XML);        	
    	if(!file.exists())file = new File(pathCarpeta + File.separator + nombreDefault + XML);
    	if(!file.exists()){
    		log.debug("No se encuentran los archivos: " + pathCarpeta + File.separator + nombreArchivo + XML + " o " + pathCarpeta + File.separator + nombreDefault + XML);
    		return null;
    	}
    	
    	return file;
    }
        
    public boolean isActivo(String idSession, String msisdn, String servicio){
    	if(path == null || path.length() == 0 || idSession == null  || msisdn == null || servicio == null)return false;
    	
        try {            	
        	File file = getFile(getContextoSimulador(idSession), msisdn, servicio);
        	if(file != null)return true;
            
        }catch(Exception e){
        	log.debug("Error en Simulador.esActivo");
        }
        
        return false;
    }
    
//    private boolean isSimuladorRegistradoBBDD(String servicio, String contextoSimulador){
//    	
//    	if(contextoSimulador != null)servicio = servicio + "_" + contextoSimulador;
//    	
//    	try{
//    		return ConfigurationManager.getConfiguration(ConfigurationManager.PortalConfiguration.SPECIFIC).getBoolean("simulador." + servicio);
//    	}catch(Exception e){
//    		log.debug("Error en simulador.isSimuladorRegistradoBBDD - simulador." + servicio);
//    	}
//    	
//    	try{
//        	return ConfigurationManager.getConfiguration(ConfigurationManager.PortalConfiguration.SPECIFIC).getBoolean("simulador." + contextoSimulador);  	
//    	}catch(Exception e){
//    		log.debug("Error en simulador.isSimuladorRegistradoBBDD - simulador." + contextoSimulador);
//    	}
//    	
//    	if(contextoSimulador != null)log.debug("Simulador desactivado, da de alta la clave en BBDD : simulador." + servicio);
//    	
//    	return false;
//    }
    
    private void crearCarpeta(String path){
    	try{
    		File file = new File(path);    		
    		if(!file.getParentFile().exists())file.getParentFile().mkdir();
        	if(!file.exists())file.mkdir();
    	}catch (Exception e){
    		log.debug("Excepcion al crear la carpeta: "+e.getMessage());
    	}    	
    }
    
    public String getContextoSimulador(String idSession){
    	return mapaSessionContexto.get(idSession);
    }
    
    public String setContextoSimulador(String idSession, String contextoSimulador){
    	return mapaSessionContexto.put(idSession, contextoSimulador);
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toXml(Object o) {
		
    		
    	  XStream xStream = new XStream(new DomDriver(encoding));
	       return xStream.toXML(o);
   
    }
	@Override
	public Object toObject(Class classType, String xml) {
		
//		if(path == null || path.length() == 0 || idSession == null  || msisdn == null || servicio == null)return null;

    	Object objeto = null;
    	
    	InputStreamReader reader = null;
        try {

//    		String contextoSimulador = this.getContextoSimulador(idSession);
//    		
//        	file = getFile(contextoSimulador, msisdn, servicio);
//        	if(file == null)return null;

        	reader = new InputStreamReader(new FileInputStream(xml), encoding);

            XStream xStream = new XStream(new DomDriver(encoding));
            objeto = xStream.fromXML(reader);
            
     //       log.debug("Objeto recuperado del servicio: " + servicio);
           
        }catch(Exception e){
        	
        }finally {
            if (reader != null) {
            	try{
            		reader.close();
            	}catch(Exception e1){
            		log.debug("Excepcion al cerrar el Flujo de entrada: "+e1.getMessage());
            	}
            	
            }
        }
        return objeto;
	}
    
    
}
