package br.com.mobicare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mobicare.dao.MedicamentoDaoImpl;
import br.com.mobicare.modelo.Medicamento;
import br.com.mobicare.modelo.Servico;
import br.com.mobicare.servico.MedicamentoServico;
import br.com.mobicare.servico.PacienteServico;
import br.com.mobicare.servico.PlanoServico;

@Controller
@RequestMapping(value = "/servico")
public class ServicoController {
	@Autowired
	private PacienteServico servicoPaciente;
	@Autowired
	private PlanoServico servicoPlano;
	@Autowired
	private MedicamentoServico servicoMedicamento;

	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	@RequestMapping(value = "/servicos", method = RequestMethod.GET)
	public ModelAndView indexServico() {
		try {
			Servico servico = new Servico();
			servico.setMedicamentos(servicoMedicamento.listarMedicamento());
			return new ModelAndView("/usuario/servico/cadServico")
					.addObject("servico", servico)
					.addObject("listaPacientes",
							servicoPaciente.listarPacientes())
					.addObject("listaPlanos", servicoPlano.listarPlanos())
					.addObject("listaMedicamentos",
							servicoMedicamento.listarMedicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/criarServico", method = RequestMethod.POST)
	public ModelAndView efetuarServico(@ModelAttribute Servico servico,
			BindingResult result) {
		try {
			medicamentos.size();
			return new ModelAndView("/usuario/servico/cadServico")
					.addObject("servico", new Servico())
					.addObject("listaPacientes",
							servicoPaciente.listarPacientes())
					.addObject("listaPlanos", servicoPlano.listarPlanos())
					.addObject("listasMedicamentos",
							servicoMedicamento.listarMedicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
