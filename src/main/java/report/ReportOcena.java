package report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ExamDataRepo;
import data.ExamData;
import data.ReportCheckBox;

@Component("reportOcena")
public class ReportOcena implements Report {

	private ExamDataRepo dao;
	
	public void printReport(ReportCheckBox reportCheckBox) {
		// TODO Auto-generated method stub
		List<ExamData> examData = dao.getExamdata();
		Map<String, int[]> ocene = new HashMap<>();
		StringBuilder report = new StringBuilder("Average grade by class ");
		boolean first = true;
		for (ExamData e : examData) {

			Boolean indeks = null;
			Boolean nastavnik = null;
			Boolean sifra = true;
			Boolean ocena = null;
			if(reportCheckBox.sifraExists()) {
				 sifra = e.getSifra() == reportCheckBox.getSifra(); 
				 if(first) {
				 report.append(" sifra: " + reportCheckBox.getSifra());
				 }
			}
			if (reportCheckBox.indeksExists()) {
				indeks = e.getIndeks() == reportCheckBox.getIndeks();
				if (first) {
					report.append("indeks: " + reportCheckBox.getIndeks());
				}
			}
			if (reportCheckBox.nastavnikExists()) {
				nastavnik = e.getNastavnik() == reportCheckBox.getNastavnik();
				if (first) {
					report.append(" nastavnik: " + reportCheckBox.getNastavnik());
				}
			}

			if (reportCheckBox.ocenaExists()) {
				ocena = e.getOcena() > reportCheckBox.getOcena();
				if (first) {
					report.append(" ocena higher than: " + reportCheckBox.getOcena() + "\n");
				}
			}
			first = false;
			List<Boolean> checks = new ArrayList<Boolean>();
			checks.add(indeks);
			checks.add(nastavnik);
			checks.add(sifra);
			checks.add(ocena);

			boolean signal = true;
			for (Boolean b : checks) {

				if (b != null && !b) {
					signal = false;
				}
			}

			if (signal) {
				if (ocene.get(e.getPredmet()) == null) {
					ocene.put(e.getPredmet(), new int[2]);
				}
				int[] totalNumber = ocene.get(e.getPredmet());
				totalNumber[0] += 1;
				totalNumber[1] += e.getOcena();

				// report.append("\t" + studentNumber + ". " + e.getIndeks() + "\n");
			}

		}
		for (String s : ocene.keySet()) {
			int total = ocene.get(s)[0];
			int sum = ocene.get(s)[1];
			report.append("\t" + "predmet: " + s + "prosecna ocena: " + (double) sum / total);
		}
		// report.append("\tTotal: " + studentNumber);
		System.out.println(report);

	}

	@Autowired
	public void setDao(ExamDataRepo dao) {
		this.dao = dao;
	}
}
