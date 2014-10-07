package br.com.mobicare.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.dao.ServicoDao;
import br.com.mobicare.modelo.Servico;

@Service
@Transactional
public class ServServico {
	@Autowired
	private ServicoDao dao;
	
	public void salvarServico(Servico servico){
		try {
			dao.adicionarServico(servico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(readOnly=true)
	public List<Servico> listarPacientes(){
		try {
			return dao.getServicos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void excluirServico(int id)throws Exception{
			dao.excluirServico(id);
	}
	
	public Servico getServicoPorId(int id){
		try {
			return dao.getServicoPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarServico(Servico servico) throws Exception{
		dao.atualizarServico(servico);
	}

}
	