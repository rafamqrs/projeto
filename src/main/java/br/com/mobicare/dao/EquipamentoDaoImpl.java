package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Equipamento;

@Repository
public class EquipamentoDaoImpl implements EquipamentoDao {
	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(EquipamentoDaoImpl.class);
	
	@Override
	public void adicionarEquipamento(Equipamento Equipamento){
			logger.info("####Cadastro de Equipamento####");
			factory.getCurrentSession().save(Equipamento);
			logger.info("####Cadastro de Equipamento#### - CADASTRADO!");

	}
	@Override
	public void atualizarEquipamento(Equipamento equipamento){
			logger.info("####Update de Equipamento####");
			Equipamento equipamentoUpdate = getEquipamentoPorId(equipamento.getIdEquipamento());
			equipamentoUpdate.setDescricao(equipamento.getDescricao());
			equipamentoUpdate.setIndicacao(equipamento.getIndicacao());
			equipamentoUpdate.setStatus(equipamento.getStatus());
			equipamentoUpdate.setAluguel(equipamento.getAluguel());
			factory.getCurrentSession().update(equipamentoUpdate);
			logger.info("####Update de Equipamento####");
	}
	@Override
	public Equipamento getEquipamentoPorId(int id){
		Equipamento equipamento = new Equipamento();			
		try {
			logger.info("####getEquipamentoPorID ####");
			equipamento = (Equipamento)factory.getCurrentSession().get(Equipamento.class, id);
		} catch (Exception e) {
			logger.error("####Erro ao getEquipamentoPorID:" + e.getMessage());
		}
		return equipamento;
	}
	@Override
	public void excluirEquipamento(int id){
		try {
			logger.info("####excluirEmpregado ####");
			Equipamento equipamento = getEquipamentoPorId(id);
			if (equipamento != null) {
				factory.getCurrentSession().delete(equipamento);
			}
		} catch (Exception e) {
			logger.error("####Erro ao excluir Equipamento: " + e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipamento> getEquipamentos() throws Exception {
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		try {
			logger.info("####Buscando Empregados####");
			equipamentos = factory.getCurrentSession().createQuery("from Equipamento").list();
		} catch (Exception e) {
			logger.error("####Erro ao buscarEmpregados: " + e.getMessage());
		}
		return equipamentos;
	}

	
}
