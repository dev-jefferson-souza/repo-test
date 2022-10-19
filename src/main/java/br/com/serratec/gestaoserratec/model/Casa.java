package br.com.serratec.gestaoserratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Casa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidadeQuartos;
	
	@Column(nullable = false)
	private Integer quantidadeBanheiro;
	
	private String cor;
	
	@Column(nullable = false)
	private Double metragem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(Integer quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}

	public Integer getQuantidadeBanheiro() {
		return quantidadeBanheiro;
	}

	public void setQuantidadeBanheiro(Integer quantidadeBanheiro) {
		this.quantidadeBanheiro = quantidadeBanheiro;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}
	
	
}
