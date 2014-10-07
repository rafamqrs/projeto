package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Empregado;

public interface EmpregadoDao {

	public void adicionarEmpregado(Empregado empregado) throws Exception;
	public void atualizarEmpregado(Empregado empregado) throws Exception;
	public Empregado getEmpregadoPorId(int id) throws Exception;
	public void excluirEmpregado(int id) throws Exception;
	public List<Empregado> getEmpregados() throws Exception;
}
