package br.com.mobicare.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import br.com.mobicare.modelo.Medicamento;
import br.com.mobicare.modelo.Paciente;
import br.com.mobicare.modelo.Plano;
import br.com.mobicare.servico.MedicamentoServico;
import br.com.mobicare.servico.PacienteServico;
import br.com.mobicare.servico.PlanoServico;

/**
 * This Spring controller class implements a CSV file download functionality.
 * 
 * @author www.codejava.net
 *
 */
@Controller
public class ExcelController {
	@Autowired
	private PacienteServico servicoPaciente;
	@Autowired
	private MedicamentoServico servicoMedicamento;
	@Autowired
	private PlanoServico servicoPlano;

	@RequestMapping(value = "/downloadCSVPaciente")
	public void downloadCSV(HttpServletResponse response) throws IOException {

		String csvFileName = "pacientes.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);

		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "idPaciente", "Nome", "Email", "DataNascimento",
				"Telefone", "Ativo" };

		csvWriter.writeHeader(header);

		for (Paciente paciente : servicoPaciente.listarPacientes()) {
			csvWriter.write(paciente, header);
		}

		csvWriter.close();
	}

	@RequestMapping(value = "/downloadCSVPlano")
	public void downloadCSVPlano(HttpServletResponse response)
			throws IOException {

		String csvFileName = "planos.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);

		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "idPlano", "nome", "ans", "cnpj", "dataEntrega",
				"desconto" };

		csvWriter.writeHeader(header);

		for (Plano plano : servicoPlano.listarPlanos()) {
			csvWriter.write(plano, header);
		}

		csvWriter.close();
	}

	@RequestMapping(value = "/downloadCSVMedicamento")
	public void downloadCSVMedicamento(HttpServletResponse response)
			throws IOException {

		String csvFileName = "medicamentos.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);

		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "idMedicamento", "descricao", "preco",
				"dataValidade", "indicacao" };

		csvWriter.writeHeader(header);

		for (Medicamento medicamento : servicoMedicamento.listarMedicamento()) {
			csvWriter.write(medicamento, header);
		}

		csvWriter.close();
	}

	@RequestMapping(value = "/downloadCSVServico")
	public void downloadCSVServico(HttpServletResponse response)
			throws IOException {

		String csvFileName = "servico.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);

		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "idPaciente", "Nome", "Email", "DataNascimento",
				"Telefone", "Ativo" };

		csvWriter.writeHeader(header);

		for (Paciente paciente : servicoPaciente.listarPacientes()) {
			csvWriter.write(paciente, header);
		}
		csvWriter.close();
	}
}