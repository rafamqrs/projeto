package br.com.mobicare.dao;

import java.util.List;

import br.com.mobicare.modelo.Medicamento;

public interface MedicamentoDao {
	public void adicionarMedicamento(Medicamento medicamento) throws Exception;
	public void atualizarMedicamento(Medicamento medicamento) throws Exception;
	public Medicamento getMedicamentoPorId(int id) throws Exception;

	public void excluirMedicamento(int id) throws Exception;

	public List<Medicamento> getMedicamentos() throws Exception;
}
