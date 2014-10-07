package br.com.mobicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.servico.DepartamentoServico;

@Controller
@RequestMapping(value="/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoServico servico;
	private String message = null;
	private String errorMessage = null;
	
	@RequestMapping(value="/departamentos", method = RequestMethod.GET)
	public ModelAndView departamento() throws Exception{
		ModelAndView modelAndView = new ModelAndView("/departamento/consultarDepartamento");
		try {
			List<Departamento> departamentos =servico.departamentos();
			modelAndView.addObject("listaDepartamentos", departamentos);
			modelAndView.addObject("total", departamentos.size());
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao carregar os dados";
		}
		modelAndView.addObject("message", "");
		return modelAndView;
	}
	@RequestMapping(value="/deletar", method=RequestMethod.GET)
	public ModelAndView deletarEmpregado(@RequestParam(value="idDepartamento", required=true) Integer id) {
		ModelAndView modelAndView = new ModelAndView("/departamento/consultarDepartamento");
		try {
			servico.excluirDepartamento(id);
			message = "Departamento e os empregados associados foram excluidos com sucesso!";
			List<Departamento> departamentos =servico.departamentos();
			modelAndView.addObject("message", message);
			modelAndView.addObject("listaDepartamentos", departamentos);
			modelAndView.addObject("total", departamentos.size());
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao excluir Departamento e os empregados associados";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		return modelAndView;
	}

}
