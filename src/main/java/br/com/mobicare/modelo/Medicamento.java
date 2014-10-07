package br.com.mobicare.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="medicamento")
public class Medicamento {
	@Id
	@GeneratedValue
	private int idMedicamento;
	private String descricao;
	private double preco;
	@Temporal(value = TemporalType.DATE)
	private Date dataValidade;
	private String indicacao;
	@ManyToOne
    @JoinColumn(name = "idServico")
	private Servico servico;
	
	public Medicamento() {

	}
	
	public int getIdMedicamento() {
		return idMedicamento;
	}
	
	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
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
