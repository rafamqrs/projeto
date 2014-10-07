package br.com.mobicare.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empregado")
public class Empregado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEmpregado;
	private String nome;
	private String funcao;
	private Double salario;
	@ManyToOne
    @JoinColumn(name = "idDepartamento")
	private Departamento departamento;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private boolean ativo;
	
	public Empregado() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEmpregado() {
		return idEmpregado;
	}

	public void setIdEmpregado(int idEmpregado) {
		this.idEmpregado = idEmpregado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
