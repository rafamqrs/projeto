package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Equipamento;

public interface EquipamentoDao {
	public void adicionarEquipamento(Equipamento equipamento) throws Exception;
	public void atualizarEquipamento(Equipamento equipamento) throws Exception;
	public Equipamento getEquipamentoPorId(int id) throws Exception;
	public void excluirEquipamento(int id) throws Exception;
	public List<Equipamento> getEquipamentos() throws Exception;

}
