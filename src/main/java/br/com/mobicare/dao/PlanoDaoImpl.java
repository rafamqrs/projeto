package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Plano;

@Repository
public class PlanoDaoImpl implements PlanoDao {

	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(PacienteDaoImpl.class);

	@Override
	public void adicionarPlano(Plano plano) throws Exception {
		try {
			logger.info("####Cadastro de Plano####");
			factory.getCurrentSession().save(plano);
		} catch (Exception e) {
			logger.error("####Erro ao cadastrar o Plano: " + e.getMessage());
		}
	}

	@Override
	public void atualizarPlano(Plano plano) throws Exception {
		logger.info("####Update de Plano####");
		Plano planoToUpdate = getPlanoPorId(plano.getIdPlano());
		planoToUpdate.setAns(plano.getAns());
		planoToUpdate.setCnpj(plano.getCnpj());
		planoToUpdate.setDataEntrega(plano.getDataEntrega());
		planoToUpdate.setDesconto(plano.getDesconto());
		planoToUpdate.setNome(plano.getNome());
		factory.getCurrentSession().update(planoToUpdate);
		logger.info("####Update Realizado de Plano####");
	}

	@Override
	public Plano getPlanoPorId(int id) throws Exception {
		logger.info("####getPlanoPorID ####");
		Plano plano = (Plano)factory.getCurrentSession().get(Plano.class, id);
		logger.info("####getPlanoPorID encontrado####" + plano.getIdPlano() + " / " + plano.getNome());
		return plano;
	}

	@Override
	public void excluirPlano(int id) throws Exception {
		logger.info("####excluirPlano ####");
		Plano plano = getPlanoPorId(id);
		if(plano != null){
			factory.getCurrentSession().delete(plano);
		}
		logger.info("####excluirPlano - Plano Excluido ####" + id);
	}

	@Override
	public List<Plano> getPlanos() throws Exception {
		List<Plano> planos = new ArrayList<Plano>();
		logger.info("####Buscando Plano####");
		planos = factory.getCurrentSession().createQuery("from Plano").list();
		return planos;
	}

}
