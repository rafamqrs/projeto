package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Paciente;

@Repository
public class PacienteDaoImpl implements PacienteDao {
	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(PacienteDaoImpl.class);
	
	@Override
	public void adicionarPaciente(Paciente paciente){
		try {
			logger.info("####Cadastro de paciente####");
			factory.getCurrentSession().save(paciente);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("####Erro ao cadastrar o paciente: " + e.getMessage());
		}
	}
	@Override
	public void atualizarPaciente(Paciente paciente){
		try {
			logger.info("####Update de Paciente####");
			Paciente pacienteUpdate = getPacientePorId(paciente.getIdPaciente());
			pacienteUpdate.setNome(paciente.getNome());
			pacienteUpdate.setEmail(paciente.getEmail());
			pacienteUpdate.setDataNascimento(paciente.getDataNascimento());
			pacienteUpdate.setTelefone(paciente.getTelefone());
			factory.getCurrentSession().update(pacienteUpdate);
		} catch (Exception e) {
			logger.error("####Erro ao atualizar o paciente:" + e.getMessage());
		}

		
	}
	@Override
	public Paciente getPacientePorId(int id){
		Paciente paciente = new Paciente();			
		try {
			logger.info("####getPacientePorID ####");
			paciente = (Paciente)factory.getCurrentSession().get(Paciente.class, id);
		} catch (Exception e) {
			logger.error("####Erro ao getPacientePorID:" + e.getMessage());
		}
		return paciente;
	}
	@Override
	public void excluirPaciente(int id){
		try {
			logger.info("####excluirEmpregado ####");
			Paciente paciente = getPacientePorId(id);
			if (paciente != null) {
				factory.getCurrentSession().delete(paciente);
			}
		} catch (Exception e) {
			logger.error("####Erro ao excluir Paciente: " + e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getPacientes() throws Exception {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			logger.info("####Buscando Empregados####");
			pacientes = factory.getCurrentSession().createQuery("from Paciente").list();
		} catch (Exception e) {
			logger.error("####Erro ao buscarEmpregados: " + e.getMessage());
		}
		return pacientes;
	}

	
}
