package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.api.model.RestauranteModel;
import com.algaworks.algafood.client.api.model.input.CidadeIdInput;
import com.algaworks.algafood.client.api.model.input.CozinhaIdInput;
import com.algaworks.algafood.client.api.model.input.EnderecoInput;
import com.algaworks.algafood.client.api.model.input.RestauranteInput;

public class InclusaoRestauranteMain {
	
	public static void main(String[] args) {
	    try {
	      var restTemplate = new RestTemplate();
	      var restauranteClient = new RestauranteClient("http://localhost:8080",restTemplate);

	      var cozinha = new CozinhaIdInput();
	      cozinha.setId(null);
	      //cozinha.setId(4L);
	      
	      var cidade = new CidadeIdInput();
	      cidade.setId(6L);

	      var endereco = new EnderecoInput();
	      endereco.setCidade(cidade);
	      endereco.setCep("14090-010");
	      endereco.setLogradouro("Avenida Doutor Plinio de Castro Prado");
	      endereco.setNumero("130");
	      endereco.setBairro("Jardim Paulista");

	      var restaurante = new RestauranteInput();
	      restaurante.setNome("");
	      //restaurante.setNome("Donna Restaurante ");
	      restaurante.setTaxaFrete(new BigDecimal(9.5));
	      restaurante.setCozinha(new CozinhaIdInput());
	      restaurante.setCozinha(cozinha);
	      restaurante.setEndereco(endereco);

	      RestauranteModel restauranteModel = restauranteClient.adicionar(restaurante);

	      System.out.println(restauranteModel);
	    } catch (ClientApiException e) {
	      if (e.getProblema() != null) {
	        System.out.println(e.getProblema().getDetail());
	        
	        e.getProblema().getObjects().stream()
	          .forEach(p -> System.out.println(p.getFieldName() + ": " + p.getFieldUserMessage()));
	        
	      } else {
	        System.out.println("Erro desconhecido");
	        e.printStackTrace();
	      }
	    }
	  }
}
