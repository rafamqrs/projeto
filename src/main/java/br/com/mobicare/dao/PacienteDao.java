package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Paciente;

public interface PacienteDao {

	public void adicionarPaciente(Paciente paciente) throws Exception;
	public void atualizarPaciente(Paciente paciente) throws Exception;
	public Paciente getPacientePorId(int id) throws Exception;

	public void excluirPaciente(int id) throws Exception;

	public List<Paciente> getPacientes() throws Exception;
}
