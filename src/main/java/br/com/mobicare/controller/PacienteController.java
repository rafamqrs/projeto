package br.com.mobicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Paciente;
import br.com.mobicare.servico.PacienteServico;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteServico servico;
	private String message = null;
	private String errorMessage = null;
	private String infoMessage = null;

	
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
	public ModelAndView paginaPaciente(){
		try {
			ModelAndView mv = new ModelAndView("/usuario/paciente/cadPaciente");
			mv.addObject("paciente", new Paciente());
			mv.addObject("listaPacientes", servico.listarPacientes());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/criarPaciente", method=RequestMethod.POST)
	public ModelAndView cadastrarPaciente(@ModelAttribute("paciente")Paciente paciente){
		ModelAndView mv = new ModelAndView("/usuario/paciente/cadPaciente");
		try {
			servico.salvarPaciente(paciente);
			message = "Paciente Cadastrado com sucesso!";
			mv.addObject("listaPacientes", servico.listarPacientes());
		} catch (Exception e) {
			errorMessage="Ocorreu um erro ao cadastrar!";
			mv.addObject("errorMessage", errorMessage);
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletarPaciente(@RequestParam(value = "idPaciente", required = true) Integer id,
									    @ModelAttribute("paciente") Paciente paciente){
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/paciente/cadPaciente");
		try {
			servico.excluirPaciente(id);
			message = "Paciente excluido com sucesso!";
			modelAndView.addObject("message", message);
			modelAndView.addObject("listaPacientes", servico.listarPacientes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarPacientePagina(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/paciente/editarPaciente");
		try {
			Paciente paciente = servico.getPacientePorId(id);
			modelAndView.addObject("paciente", paciente);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao selecionar a edição do cliente";
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public ModelAndView editarPacientes(
			@ModelAttribute("paciente") Paciente paciente,@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/usuario/paciente/cadPaciente");
		String message = null;
		try {
			paciente.setIdPaciente(id);
			System.out.println(id);
			servico.atualizarPaciente(paciente);
			message = "Paciente Atualizado com sucesso!";
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao atualizar o cliente";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
