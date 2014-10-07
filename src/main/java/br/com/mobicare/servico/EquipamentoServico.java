package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.EquipamentoDao;
import br.com.mobicare.modelo.Equipamento;

@Service
@Transactional
public class EquipamentoServico {
	@Autowired
	private EquipamentoDao dao;

	public void salvarPaciente(Equipamento equipamento){
		try {
			dao.adicionarEquipamento(equipamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(readOnly=true)
	public List<Equipamento> listarEquipamentos(){
		try {
			return dao.getEquipamentos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void excluirEquipamento(int id)throws Exception{
			dao.excluirEquipamento(id);
	}
	
	public Equipamento getEquipamentoPorId(int id){
		try {
			return dao.getEquipamentoPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarEquipamento(Equipamento equipamento) throws Exception{
		dao.atualizarEquipamento(equipamento);
	}

}
	