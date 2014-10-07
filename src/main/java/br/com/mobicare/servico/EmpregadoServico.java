package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.EmpregadoDaoImpl;
import br.com.mobicare.modelo.Empregado;

@Service
@Transactional
public class EmpregadoServico {

	@Autowired
	private EmpregadoDaoImpl dao;

	public void adicionarEmpregado(Empregado empregado)throws Exception{
		dao.adicionarEmpregado(empregado);
	}
	public List<Empregado> listarEmpregados()throws Exception{
		return dao.getEmpregados();
	}
	public void excluirEmpregado(int id)throws Exception{
		dao.excluirEmpregado(id);
	}
	public Empregado getDepartamentoPorId(Integer id)throws Exception {
		return dao.getEmpregadoPorId(id);
	}
	public void atualizarEmpregado(Empregado empregado) throws Exception{
		dao.atualizarEmpregado(empregado);
	}
}
