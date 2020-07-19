package com.algaworks.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;

public class ListagemRestaurantesMain {
	
	public static void main(String[] args) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			RestauranteClient restauranteClient = new RestauranteClient("http://localhost:8080",restTemplate);
			
			restauranteClient.listar().stream()
				.forEach(restaurante -> System.out.println(restaurante));
		} catch (ClientApiException e) {
			if (e.getProblema() != null) {
//				System.out.println(e.getProblem());
				System.out.println(e.getProblema().getDetail());
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			} 
		}
	}
}
