package br.com.mobicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Equipamento;
import br.com.mobicare.servico.EquipamentoServico;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {
	@Autowired
	private EquipamentoServico servico;
	private String message = null;
	private String errorMessage = null;
	private String infoMessage = null;

	
	@RequestMapping(value="/equipamentos", method=RequestMethod.GET)
	public ModelAndView paginaEquipamento(){
		try {
			ModelAndView mv = new ModelAndView("/usuario/equipamento/cadEquipamento");
			mv.addObject("equipamento", new Equipamento());
			mv.addObject("listaEquipamentos", servico.listarEquipamentos());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/criarEquipamento", method=RequestMethod.POST)
	public ModelAndView cadastrarEquipamento(@ModelAttribute("equipamento")Equipamento equipamento){
		ModelAndView mv = new ModelAndView("/usuario/equipamento/cadEquipamento");
		try {
			servico.salvarPaciente(equipamento);
			message = "Equipamento Cadastrado com sucesso!";
			mv.addObject("listaEquipamentos", servico.listarEquipamentos());
			mv.addObject("message", message);
		} catch (Exception e) {
			errorMessage="Ocorreu um erro ao cadastrar!";
			mv.addObject("errorMessage", errorMessage);
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletarEquipamento(@RequestParam(value = "idEquipamento", required = true) Integer id,
											@ModelAttribute("equipamento") Equipamento equipamento){
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/equipamento/cadEquipamento");
		try {
			servico.excluirEquipamento(id);
			message = "Equipamento excluido com sucesso!";
			modelAndView.addObject("message", message);
			modelAndView.addObject("listaEquipamentos", servico.listarEquipamentos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarEquipamentoPagina(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/equipamento/cadEquipamento");
		try {
			Equipamento equipamento = servico.getEquipamentoPorId(id);
			modelAndView.addObject("equipamento", equipamento);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao selecionar a editar o Equipamento";
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public ModelAndView editarEquipamentos(
			@ModelAttribute("equipamento") Equipamento equipamento,@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/equipamento/cadEquipamento");
		String message = null;
		try {
			equipamento.setIdEquipamento(id);
			servico.atualizarEquipamento(equipamento);
			message = "Equipamento Atualizado com sucesso!";
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao atualizar o Equipamento";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
