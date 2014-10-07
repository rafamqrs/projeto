package br.com.mobicare.controller;

import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Plano;
import br.com.mobicare.servico.PlanoServico;

@Controller
@RequestMapping("/plano")
public class PlanoController {
	@Autowired
	private PlanoServico servico;
	private String message = null;
	private String errorMessage = null;
	private String infoMessage = null;

	
	@RequestMapping(value="/planos", method=RequestMethod.GET)
	public ModelAndView paginaPlano(){
		try {
			ModelAndView mv = new ModelAndView("/usuario/plano/cadPlano");
			mv.addObject("plano", new Plano());
			mv.addObject("listaPlano", servico.listarPlanos());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/criarPlano", method=RequestMethod.POST)
	public ModelAndView cadastrarPlano(@ModelAttribute("plano")Plano plano){
		ModelAndView mv = new ModelAndView("/usuario/plano/cadPlano");
		try {
			servico.salvarPlano(plano);
			message = "Plano Cadastrado com sucesso!";
			mv.addObject("listaPlanos", servico.listarPlanos());
			mv.addObject("message", message);
		} catch (Exception e) {
			errorMessage="Ocorreu um erro ao cadastrar!";
			mv.addObject("errorMessage", errorMessage);
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletarPlano(@RequestParam(value = "idPlano", required = true) Integer id,
									    @ModelAttribute("plano") Plano plano){
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/plano/cadPlano");
		try {
			servico.excluirPlano(id);
			message = "Plano excluido com sucesso!";
			modelAndView.addObject("message", message);
			modelAndView.addObject("listaPlanos", servico.listarPlanos());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarPlanoPagina(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/plano/editarPlano");
		try {
			Plano plano = servico.getPlanoPorId(id);
			modelAndView.addObject("plano", plano);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao selecionar a editar o plano";
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/editarPlano/{id}", method=RequestMethod.POST)
	public ModelAndView editarPlanos(
			@ModelAttribute Plano plano, BindingResult result, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/plano/cadPlano");
		String message = null;
		try {
			plano.setIdPlano(id);
			servico.atualizarPlano(plano);
			message = "Plano Atualizado com sucesso!";
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao atualizar o Plano";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
