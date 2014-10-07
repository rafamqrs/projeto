package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Servico;

public interface ServicoDao {
	public void adicionarServico(Servico servico) throws Exception;
	public void atualizarServico(Servico servico) throws Exception;
	public Servico getServicoPorId(int id) throws Exception;
	public void excluirServico(int id) throws Exception;
	public List<Servico> getServicos() throws Exception;
}
