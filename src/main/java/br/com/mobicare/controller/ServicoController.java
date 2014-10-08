package br.com.mobicare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.cellprocessor.ParseInt;

import br.com.mobicare.modelo.Medicamento;
import br.com.mobicare.modelo.Paciente;
import br.com.mobicare.modelo.Plano;
import br.com.mobicare.modelo.Servico;
import br.com.mobicare.servico.MedicamentoServico;
import br.com.mobicare.servico.PacienteServico;
import br.com.mobicare.servico.PlanoServico;
import br.com.mobicare.servico.ServServico;

@Controller
@RequestMapping(value = "/servico")
public class ServicoController {
	@Autowired
	private PacienteServico servicoPaciente;
	@Autowired
	private PlanoServico servicoPlano;
	@Autowired
	private MedicamentoServico servicoMedicamento;
	@Autowired
	private ServServico servicoServ;

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
			BindingResult result,
			@RequestParam(value = "valorPlano") String[] valorPlano,
			@RequestParam(value = "valorMedicamento") String[] valorMedicamento,
			@RequestParam(value = "valorPaciente") String valorPaciente) {
		try {
			
			servico.setMedicamentos(adicionarMedicamentoPedido(valorMedicamento));
			servico.setPlanos(adicionarSaboresPedido(valorPlano));
			Paciente paciente = servicoPaciente.getPacientePorId(Integer.parseInt(valorPaciente));
			servico.setUsuario(paciente);
			servicoServ.salvarServico(servico);
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

	public List<Plano> adicionarSaboresPedido(String[] sabores) {
		List<Plano> listaSabores = new ArrayList<Plano>();
		int idSabor = 0;
		try {
			for (int i = 0; i < sabores.length; i++) {
				idSabor = Integer.parseInt(sabores[i]);
				Plano sabor = servicoPlano.getPlanoPorId(idSabor);
				listaSabores.add(sabor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaSabores;
	}
	
	public List<Medicamento> adicionarMedicamentoPedido(String[] sabores) {
		List<Medicamento> listaSabores = new ArrayList<Medicamento>();
		int idSabor = 0;
		try {
			for (int i = 0; i < sabores.length; i++) {
				idSabor = Integer.parseInt(sabores[i]);
				Medicamento sabor = servicoMedicamento.getMedicamentoPorId(idSabor);
				listaSabores.add(sabor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaSabores;
	}
	
}
