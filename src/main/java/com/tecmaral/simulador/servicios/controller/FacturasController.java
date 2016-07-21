package com.tecmaral.simulador.servicios.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.abstraccion.FacturasMock;
import com.tecmaral.simulador.servicios.model.facturas.Factura;



@RestController
public class FacturasController implements FacturasService {

	  /**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;
             
    /**
     * Path of the file to be downloaded, relative to application's directory
     */
    private String filePath = "/downloads/SpringProject.zip";
     
  
    
	private static final Logger LOG = LoggerFactory.getLogger(FacturasController.class);

	public List<Factura> getFacturas() throws ApplicationException {
		LOG.debug("[getUltimasFacturas][ini]" );
		List<Factura> facturas= FacturasMock.getFacturas();
		LOG.debug("[getUltimasFacturas][facturas:{}]",facturas );
		LOG.debug("[getUltimasFacturas][fin]" );
		return facturas;
	}

	public Factura getUltimaFactura() throws ApplicationException {
		LOG.debug("[getUltimasFacturas][ini]" );
		List<Factura> facturas= FacturasMock.getFacturas();
		Factura factura = facturas.get(facturas.size()-1);
		LOG.debug("[getUltimasFacturas][factura:{}]",factura );
		LOG.debug("[getUltimasFacturas][fin]" );
		return factura;
	}
	
  
	public void doDownload(HttpServletRequest request,  HttpServletResponse response) throws ApplicationException  {
      
		 try{
		 // get absolute path of the application
	        ServletContext context = request.getServletContext();
	        String appPath = context.getRealPath("");
	        System.out.println("appPath = " + appPath);
	 
	        // construct the complete absolute path of the file
	        String fullPath = appPath + filePath;      
	        File downloadFile = new File(fullPath);
	        FileInputStream inputStream = new FileInputStream(downloadFile);
	         
	        // get MIME type of the file
	        String mimeType = context.getMimeType(fullPath);
	        if (mimeType == null) {
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	 
	        // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	 
	        // get output stream of the response
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
		 }catch(Exception es){
			 throw new ApplicationException("1111", "Error recuperando fichero");
		 } 
    }
     
  



}