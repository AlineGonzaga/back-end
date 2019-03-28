package com.banana.comercial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	//@Size(max = 50)
	@Column(name = "local_filial")
	private String localFilial;
	
    private int sala;
	@NotEmpty
    @Column(name = "data_hora_inicial")
    private String dataHoraInicial;
	@NotEmpty
    @Column(name = "data_hora_final")
    private String dataHoraFinal;
	@NotEmpty
    private String responsavel;
    private boolean cafe;
    private int quantidade;
    private String descricao;
    
	public String getDataHoraInicial() {
		return dataHoraInicial;
	}
	public void setDataHoraInicial(String dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}
	public String getDataHoraFinal() {
		return dataHoraFinal;
	}
	public void setDataHoraFinal(String dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}
	public String getLocalFilial() {
		return localFilial;
	}
	public void setLocalFilial(String localFilial) {
		this.localFilial = localFilial;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}


	public boolean isCafe() {
		return cafe;
	}
	public void setCafe(boolean cafe) {
		this.cafe = cafe;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// Gerar so para o id porque o id é o identificador do objeto de reserva para a minha classe poder fazer comparacoes
	// de objetos atraves do id
	@Override 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}