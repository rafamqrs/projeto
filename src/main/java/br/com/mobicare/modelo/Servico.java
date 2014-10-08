package br.com.mobicare.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "servico_planos", joinColumns = @JoinColumn(name = "idServico"), inverseJoinColumns = @JoinColumn(name = "idPlano"))
	@Fetch(FetchMode.SUBSELECT)
	private List<Plano> planos;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "servico_medicamento", joinColumns = @JoinColumn(name = "idServico"), inverseJoinColumns = @JoinColumn(name = "idMedicamento"))
	@Fetch(FetchMode.SUBSELECT)
	private List<Medicamento> medicamentos;
	private double precoTotal;

	public Servico() {
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
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
