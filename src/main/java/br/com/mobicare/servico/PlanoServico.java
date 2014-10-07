package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.PlanoDao;
import br.com.mobicare.modelo.Plano;

@Service
@Transactional
public class PlanoServico {
	@Autowired
	private PlanoDao dao;

	public void salvarPlano(Plano plano){
		try {
			dao.adicionarPlano(plano);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(readOnly=true)
	public List<Plano> listarPlanos(){
		try {
			return dao.getPlanos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void excluirPlano(int id){
		try {
			dao.excluirPlano(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Plano getPlanoPorId(int id){
		try {
			return dao.getPlanoPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarPlano(Plano plano) throws Exception{
		dao.atualizarPlano(plano);
	}

}
	