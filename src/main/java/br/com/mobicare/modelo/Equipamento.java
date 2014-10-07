package br.com.mobicare.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="equipamento")
public class Equipamento {
	@Id
	@GeneratedValue
	private int idEquipamento;
	private String descricao;
	private double aluguel;
	private String status;
	private String indicacao;
	@Transient
	private Servico servico;
	
	public Equipamento() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAluguel() {
		return aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
