package com.algaworks.algafood.client.api;

import org.springframework.web.client.RestClientResponseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ClientApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Problema problema;
	
	public Problema getProblema() {
		return problema;
	}
	
	public ClientApiException(String message, RestClientResponseException cause) {
		super(message, cause);
		
		converteExceptionToProblema(cause);
	}
	
	public void converteExceptionToProblema(RestClientResponseException cause) {
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		mapper.registerModule(new JavaTimeModule());
		mapper.findAndRegisterModules();
		
		try {
			this.problema = mapper.readValue(cause.getResponseBodyAsString(), Problema.class);
		} catch (JsonMappingException e) {
			System.out.println("Não foi possível realizar a conversão de Excpetion para erro");
		} catch (JsonProcessingException e) {
			System.out.println("Não foi possível realizar a conversão de Excpetion para erro");
		}
	}
}
