package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Medicamento;

@Repository
public class MedicamentoDaoImpl implements MedicamentoDao {

	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(MedicamentoDaoImpl.class);
	
	@Override
	public void adicionarMedicamento(Medicamento medicamento) throws Exception {
		logger.info("####Cadastro de Medicamento####");
		factory.getCurrentSession().save(medicamento);
		logger.info("####Cadastro de Medicamento####" + medicamento.getDescricao() + "CADASTRADO");
	}
	@Override
	public void atualizarMedicamento(Medicamento medicamento) throws Exception {
		logger.info("####Atualizar Medicamento####");
		Medicamento mediToUpdate = getMedicamentoPorId(medicamento.getIdMedicamento());
		mediToUpdate.setIndicacao(medicamento.getIndicacao());
		mediToUpdate.setDescricao(medicamento.getDescricao());
		mediToUpdate.setDataValidade(medicamento.getDataValidade());
		mediToUpdate.setPreco(medicamento.getPreco());
		factory.getCurrentSession().merge(medicamento);
		logger.info("####Atualizado o Medicamento####");
	}
	@Override
	public Medicamento getMedicamentoPorId(int id) throws Exception {
		Medicamento medicamento = new Medicamento();			
		logger.info("####getMedicamentoPorID ####");
		medicamento = (Medicamento)factory.getCurrentSession().get(Medicamento.class, id);
		logger.error("####Retornando o medicamento:");
		return medicamento;
	}
	@Override
	public void excluirMedicamento(int id) throws Exception {

		logger.info("#### excluirMedicamento ####");
		Medicamento medicamento = null;
		medicamento = getMedicamentoPorId(id);
		if (medicamento != null) {
			factory.getCurrentSession().delete(medicamento);
		}
		logger.info("#### excluido - medicamento -  ####" + id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Medicamento> getMedicamentos() throws Exception {
		logger.info("####getMedicamentos ####");
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		medicamentos = factory.getCurrentSession().createQuery("from Medicamento").list();
		logger.info("####Retornando os medicamentos -getMedicamentos ####");
		return medicamentos;
	}

}
