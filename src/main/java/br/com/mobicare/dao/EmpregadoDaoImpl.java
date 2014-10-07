package br.com.mobicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Empregado;

@Repository
public class EmpregadoDaoImpl implements EmpregadoDao {
	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(EmpregadoDaoImpl.class);

	
	@Override
	public void adicionarEmpregado(Empregado empregado){
		try {
			logger.info("####Cadastro de Empregado####");
			factory.getCurrentSession().save(empregado);
		} catch (Exception e) {
			logger.error("####Erro ao cadastrar o empregado: " + e.getMessage());
		}
	}

	@Override
	public void atualizarEmpregado(Empregado empregado){
		try {
			logger.info("####Cadastro de Empregado####");
			factory.getCurrentSession().merge(empregado);
		} catch (Exception e) {
			logger.error("####Erro ao excluir o empregado:" + e.getMessage());
		}
	}

	@Override
	public Empregado getEmpregadoPorId(int id){
		Empregado empregado = new Empregado();			
		try {
			logger.info("####getEmpregadoPorID ####");
			empregado = (Empregado)factory.getCurrentSession().get(Empregado.class, id);
		} catch (Exception e) {
			logger.error("####Erro ao getEmpregadoPorID:" + e.getMessage());
		}
		return empregado;
	}

	@Override
	public void excluirEmpregado(int id) {
		try {
			logger.info("####excluirEmpregado ####");
			Empregado empregado = getEmpregadoPorId(id);
			if (empregado != null) {
				factory.getCurrentSession().delete(empregado);
			}
		} catch (Exception e) {
			logger.error("####Erro ao excluirEmpregado: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empregado> getEmpregados(){
		List<Empregado> empregados = new ArrayList<Empregado>();
		try {
			logger.info("####Buscando Empregados####");
			empregados = factory.getCurrentSession().createQuery("from Empregado").list();
		} catch (Exception e) {
			logger.error("####Erro ao buscarEmpregados: " + e.getMessage());
		}
		return empregados;
	}
}
