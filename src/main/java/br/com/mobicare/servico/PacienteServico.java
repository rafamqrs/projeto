package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.PacienteDao;
import br.com.mobicare.modelo.Paciente;

@Service
@Transactional
public class PacienteServico {
	@Autowired
	private PacienteDao dao;

	public void salvarPaciente(Paciente paciente){
		try {
			dao.adicionarPaciente(paciente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(readOnly=true)
	public List<Paciente> listarPacientes(){
		try {
			return dao.getPacientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void excluirPaciente(int id)throws Exception{
			dao.excluirPaciente(id);
	}
	
	public Paciente getPacientePorId(int id){
		try {
			return dao.getPacientePorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarPaciente(Paciente paciente) throws Exception{
		dao.atualizarPaciente(paciente);
	}

}
	