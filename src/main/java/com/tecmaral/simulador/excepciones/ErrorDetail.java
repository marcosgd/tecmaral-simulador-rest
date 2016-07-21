package com.tecmaral.simulador.excepciones;

public class ErrorDetail {

	
		private int status;
		private String message;
		private String url;
		private String code;
		private String description;
		private String originSystem;
		private boolean technicalError;
		//private ServiceResponseDTO ssoResponse;
		private int numIntentos;
		

		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getOriginSystem() {
			return originSystem;
		}
		public void setOriginSystem(String originSystem) {
			this.originSystem = originSystem;
		}
		public boolean isTechnicalError() {
			return technicalError;
		}
		public void setTechnicalError(boolean technicalError) {
			this.technicalError = technicalError;
		}
		public int getNumIntentos() {
			return numIntentos;
		}
		public void setNumIntentos(int numIntentos) {
			this.numIntentos = numIntentos;
		}

		
}
