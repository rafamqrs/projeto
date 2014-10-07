package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Servico;

@Repository
public class ServicoDaoImpl implements ServicoDao {

	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(ServicoDaoImpl.class);
	
	@Override
	public void adicionarServico(Servico servico) throws Exception {
		logger.info("####Cadastro de Servico####");
		factory.getCurrentSession().save(servico);
		logger.info("####Cadastro de Servico####" + servico.getDescricao() + "CADASTRADO");
	}
	@Override
	public void atualizarServico(Servico servico) throws Exception {
		logger.info("####Atualizar Servico####");
		Servico servicoToUpdate = getServicoPorId(servico.getIdServico());
		factory.getCurrentSession().merge(servicoToUpdate);
		logger.info("####Atualizado o Servico####");
	}
	@Override
	public Servico getServicoPorId(int id) throws Exception {
		Servico servico = new Servico();			
		logger.info("####getServicoPorID ####");
		servico = (Servico)factory.getCurrentSession().get(Servico.class, id);
		return servico;
	}
	@Override
	public void excluirServico(int id) throws Exception {

		logger.info("#### excluirServico ####");
		Servico servico = null;
		servico = getServicoPorId(id);
		if (servico != null) {
			factory.getCurrentSession().delete(servico);
		}
		logger.info("#### excluido - servico -  ####" + id);
	}
	@Override
	public List<Servico> getServicos() throws Exception {
		logger.info("####getServico ####");
		List<Servico> servicos = new ArrayList<Servico>();
		servicos = factory.getCurrentSession().createQuery("from Servico").list();
		logger.info("####Retornando os medicamentos -getServico ####");
		return servicos;
	}

}
