package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.DepartamentoDaoImpl;
import br.com.mobicare.modelo.Departamento;

@Service
public class DepartamentoServico {
	@Autowired
	private DepartamentoDaoImpl dao;

	@Transactional(readOnly=true)
	public List<Departamento> departamentos()throws Exception{
		return dao.listarDepartamento();
	}
	@Transactional
	public Departamento getDepartamentoPorId(int idDepartamento) throws Exception{
		return dao.getDepartamentoPorId(idDepartamento);
	}
	@Transactional
	public void excluirDepartamento(int idDepartamento) throws Exception{
		dao.excluirDepartamento(idDepartamento);
	}
}
