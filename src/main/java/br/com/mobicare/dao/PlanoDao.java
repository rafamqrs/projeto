package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Plano;

public interface PlanoDao {
	public void adicionarPlano(Plano plano) throws Exception;
	public void atualizarPlano(Plano plano) throws Exception;
	public Plano getPlanoPorId(int id) throws Exception;
	public void excluirPlano(int id) throws Exception;
	public List<Plano> getPlanos() throws Exception;

}
