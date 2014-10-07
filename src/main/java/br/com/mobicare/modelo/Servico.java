package br.com.mobicare.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {
	@Id
	@GeneratedValue
	private int idServico;
	private String descricao;
	private String tipo;
	@OneToOne
	@JoinColumn(name = "idPaciente")
	private Paciente usuario;
	@OneToOne
	@JoinColumn(name = "idPlano")
	private Plano plano;
	@OneToMany(mappedBy = "servico")
	private List<Medicamento> medicamentos;
	private double precoTotal;

	public Servico() {
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Paciente getUsuario() {
		return usuario;
	}

	public void setUsuario(Paciente usuario) {
		this.usuario = usuario;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
}
