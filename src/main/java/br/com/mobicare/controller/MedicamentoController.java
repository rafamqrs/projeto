package br.com.mobicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Medicamento;
import br.com.mobicare.servico.MedicamentoServico;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoServico servico;
	private String message = null;
	private String errorMessage = null;
	private String infoMessage = null;

	
	@RequestMapping(value="/medicamentos", method=RequestMethod.GET)
	public ModelAndView paginaMedicamento(){
		try {
			ModelAndView mv = new ModelAndView("/usuario/medicamento/cadMedicamento");
			mv.addObject("medicamento", new Medicamento());
			mv.addObject("listaMedicamento", servico.listarMedicamento());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/criarMedicamento", method=RequestMethod.POST)
	public ModelAndView cadastrarMedicamento(@ModelAttribute("medicamento")Medicamento medicamento){
		ModelAndView mv = new ModelAndView("/usuario/medicamento/cadMedicamento");
		try {
			servico.salvarMedicamento(medicamento);
			message = "Medicamento Cadastrado com sucesso!";
			mv.addObject("listaMedicamento", servico.listarMedicamento());
			mv.addObject("message", message);
			return mv;
		} catch (Exception e) {
			errorMessage="Ocorreu um erro ao cadastrar!";
			mv.addObject("errorMessage", errorMessage);
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletarMedicamento(@RequestParam(value = "idMedicamento", required = true) Integer id,
									    @ModelAttribute("medicamento") Medicamento medicamento){
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/medicamento/cadMedicamento");
		try {
			servico.excluirMedicamento(id);
			message = "Medicamento excluido com sucesso!";
			modelAndView.addObject("message", message);
			modelAndView.addObject("listaMedicamentos", servico.listarMedicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarMedicamentoPagina(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/medicamento/editarMedicamento");
		try {
			Medicamento medicamento = servico.getMedicamentoPorId(id);
			modelAndView.addObject("medicamento", medicamento);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao selecionar a edi����o do medicamento";
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public ModelAndView editarMedicamentos(
			@ModelAttribute("medicamento") Medicamento medicamento,@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/medicamento/cadMedicamento");
		String message = null;
		try {
			medicamento.setIdMedicamento(id);
			System.out.println(id);
			servico.atualizarMedicamento(medicamento);
			message = "Medicamento Atualizado com sucesso!";
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao atualizar o medicamento";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
