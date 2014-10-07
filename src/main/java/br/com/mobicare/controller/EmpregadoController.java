package br.com.mobicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.modelo.Departamento;
import br.com.mobicare.modelo.Empregado;
import br.com.mobicare.servico.DepartamentoServico;
import br.com.mobicare.servico.EmpregadoServico;

@Controller
@RequestMapping(value = "/empregado")
public class EmpregadoController {

	@Autowired
	private EmpregadoServico servico;
	@Autowired
	private DepartamentoServico departamentoServico;
	private String message = null;
	private String errorMessage = null;
	private String infoMessage = null;

	@RequestMapping(value = "/criarEmpregado", method = RequestMethod.GET)
	public ModelAndView paginaEmpregado() {
		ModelAndView view = new ModelAndView("/empregado/cadEmpregado");
		view.addObject("empregado", new Empregado());
		try {
			view.addObject("listDepartamento",
					departamentoServico.departamentos());
			view.addObject("listaEmpregados", servico.listarEmpregados());
			if (departamentoServico.departamentos().size() < 1) {
				infoMessage = "é necessário cadastrar um departamento para continuar solicite ao adm do sistema!";
				view.addObject("infoMessage", infoMessage);
			}
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro os dados da página de empregados";
			view.addObject("errorMessage", errorMessage);
		}
		return view;
	}

	@RequestMapping(value = "/criarEmpregado", method = RequestMethod.POST)
	public ModelAndView cadastrarEmpregado(
			@ModelAttribute("empregado") Empregado empregado,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("/empregado/cadEmpregado");

		try {
			if (result.getFieldValue("departamento").toString().isEmpty()) {
				errorMessage = "Todos os campos são obrigatórios";
				modelAndView.addObject("errorMessage", errorMessage);
			} else {
				int idDepartamento = Integer.parseInt(result.getFieldValue(
						"departamento").toString());
				Departamento deparmtamento = departamentoServico
						.getDepartamentoPorId(idDepartamento);
				empregado.setDepartamento(deparmtamento);
				servico.adicionarEmpregado(empregado);
				message = "Empregado: " + empregado.getNome()
						+ " Cadastrado com sucesso!";
			}
			modelAndView.addObject("listDepartamento",
					departamentoServico.departamentos());
			modelAndView.addObject("listaEmpregados",
					servico.listarEmpregados());
			modelAndView.addObject("message", message);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao salvar o empregado" + "<br/>"
					+ " Entre em contato com o administrador do sistemas";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletarEmpregado(
			@RequestParam(value = "idEmpregado", required = true) Integer id,
			@ModelAttribute("empregado") Empregado emp) {
		ModelAndView modelAndView = new ModelAndView("/empregado/cadEmpregado");
		try {
			servico.excluirEmpregado(id);
			modelAndView.addObject("listDepartamento",
					departamentoServico.departamentos());
			modelAndView.addObject("listaEmpregados",
					servico.listarEmpregados());
			message = "Excluido com sucesso!";
			modelAndView.addObject("message", message);
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao excluir o empregado" + "<br/>"
					+ " Entre em contato com o administrador do sistemas";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarEmpregadoPagina(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(
				"/empregado/editarEmpregado");
		try {
			Empregado empregado = servico.getDepartamentoPorId(id);
			modelAndView.addObject("empregado", empregado);
			modelAndView.addObject("listDepartamento",
					departamentoServico.departamentos());
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao selecionar a edição do cliente";
		}
		return modelAndView;
	}

	@RequestMapping(value = "/editarEmpregado", method = RequestMethod.POST)
	public ModelAndView editarEmpregados(
			@ModelAttribute("empregado") Empregado empregado,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView(
				"/empregado/editarEmpregado");
		String message = null;
		try {
			int idDepartamento = Integer.parseInt(result.getFieldValue(
					"departamento").toString());
			Departamento departamento = new Departamento();
			departamento = departamentoServico
					.getDepartamentoPorId(idDepartamento);
			empregado.setDepartamento(departamento);
			servico.atualizarEmpregado(empregado);
			message = "Empregado Atualizado com sucesso!";
		} catch (Exception e) {
			errorMessage = "Ocorreu um erro ao atualizar o cliente";
			modelAndView.addObject("errorMessage", errorMessage);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
