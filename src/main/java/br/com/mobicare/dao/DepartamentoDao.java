package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Departamento;

public interface DepartamentoDao {
	public List<Departamento> listarDepartamento() throws Exception;
	public void excluirDepartamento(int idDepartamento) throws Exception;
	public Departamento getDepartamentoPorId(int idDepartamento) throws Exception;
}
