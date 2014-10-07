package br.com.mobicare.excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.supercsv.io.ICsvBeanWriter;

import br.com.mobicare.modelo.Paciente;

public class CsvViewImpl extends AbstractCsvViewn {

	@Override
	protected void buildCsvDocument(ICsvBeanWriter csvWriter,
			Map<String, Object> model) throws IOException {
		List<Paciente> listBooks = (List<Paciente>) model.get("csvData");
        String[] header = (String[]) model.get("csvHeader");
 
        csvWriter.writeHeader(header);
 
        for (Paciente aBook : listBooks) {
            csvWriter.write(aBook, header);
        }
	}

}
