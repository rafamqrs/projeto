package br.com.mobicare.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mobicare.modelo.Departamento;

@Repository
public class DepartamentoDaoImpl implements DepartamentoDao{
	@Autowired
	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(DepartamentoDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Departamento> listarDepartamento() {
		try {
			logger.info("########Buscando os Departamento########");
			return factory.getCurrentSession().createQuery("from Departamento").list();
		} catch (Exception e) {
			logger.error("########Error ao consultar os departamentos"+ e.getMessage());  
		}
		return null;
	}

	public void excluirDepartamento(int idDepartamento) {
		try {
			logger.info("########Excluido os Departamento########");
			Departamento departamento = getDepartamentoPorId(idDepartamento);
			if (departamento != null) {
				factory.getCurrentSession().delete(departamento);
			}
		} catch (Exception e) {
			logger.error("########Error ao excluir o departamento" + e.getMessage());
		}
	}

	@Override
	public Departamento getDepartamentoPorId(int idDepartamento) {
		Departamento departamento = null;
		try {
			logger.info("########Buscando o DepartamentoPorId########");
			departamento = (Departamento) factory.getCurrentSession().get(Departamento.class, idDepartamento);
		} catch (Exception e) {
			logger.error("########Error ao buscar o departamento por id:" + e.getMessage());
		}
		return departamento;
	}

}
