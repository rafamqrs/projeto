package br.com.mobicare.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDepartamento;
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	private boolean ativo;
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "departamento")
	private List<Empregado> funcionarios;
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Empregado> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Empregado> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
