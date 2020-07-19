package com.algaworks.algafood.client.api.model.input;

import java.math.BigDecimal;

public class RestauranteInput {
	
	private String nome;
	private BigDecimal taxaFrete;  
	private CozinhaIdInput cozinha;
	private EnderecoInput endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}
	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}
	public CozinhaIdInput getCozinha() {
		return cozinha;
	}
	public void setCozinha(CozinhaIdInput cozinha) {
		this.cozinha = cozinha;
	}
	public EnderecoInput getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoInput endereco) {
		this.endereco = endereco;
	}
	
}
