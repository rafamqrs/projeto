package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.MedicamentoDao;
import br.com.mobicare.modelo.Medicamento;

@Service
@Transactional
public class MedicamentoServico {
	@Autowired
	private MedicamentoDao dao;

	public void salvarMedicamento(Medicamento medicamento){
		try {
			dao.adicionarMedicamento(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(readOnly=true)
	public List<Medicamento> listarMedicamento(){
		try {
			return dao.getMedicamentos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void excluirMedicamento(int id)throws Exception{
			dao.excluirMedicamento(id);
	}
	
	public Medicamento getMedicamentoPorId(int id){
		try {
			return dao.getMedicamentoPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarMedicamento(Medicamento medicamento) throws Exception{
		dao.atualizarMedicamento(medicamento);
	}

}
	