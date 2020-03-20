package report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ExamDataRepo;
import data.ExamData;
import data.ReportCheckBox;
@Component
public class ReportPredmet implements Report {

	
ExamDataRepo dao;


public void  printReport(ReportCheckBox reportCheckBox) {

	List<ExamData> examData = dao.getExamdata();
	int studentNumber =0;
	StringBuilder report = new StringBuilder("Students that passed the exam");
	boolean first = true;
	for(ExamData e: examData) {
		
		Boolean indeks =null;
		Boolean nastavnik =null;
		Boolean sifra =null;
		Boolean ocena =null;
	
		if(reportCheckBox.indeksExists()) {
		 indeks = e.getIndeks() == reportCheckBox.getIndeks();
		 if(first) {
		 report.append("indeks: " + reportCheckBox.getIndeks());
		 }
		}
		if(reportCheckBox.nastavnikExists()) {
			 nastavnik = e.getNastavnik() == reportCheckBox.getNastavnik(); 
			 if(first) {
			 report.append(" nastavnik: " + reportCheckBox.getNastavnik());
			 }
		}
		if(reportCheckBox.sifraExists()) {
			 sifra = e.getSifra() == reportCheckBox.getSifra(); 
			 if(first) {
			 report.append(" sifra: " + reportCheckBox.getSifra());
			 }
		}
		if(reportCheckBox.ocenaExists()) {
			ocena = e.getOcena() > reportCheckBox.getOcena(); 
			 if(first) {
			 report.append(" ocena higher than: " + reportCheckBox.getOcena()  + "\n");
			 }
		}
		first = false;
		List<Boolean> checks = new ArrayList<Boolean>();
		checks.add(indeks);
		checks.add(nastavnik);
		checks.add(sifra);
		checks.add(ocena);
		
		boolean signal=true;
		for(Boolean b: checks) {
			
			if(b != null && !b) {
				signal = false;
			}
		}
		
		if(signal) {
			studentNumber++;
			report.append("\t" + studentNumber + ". " + e.getIndeks() + "\n");
		}
		
	}
	report.append("\tTotal: " + studentNumber);
	System.out.println(report);
	
}
@Autowired
public void setDao(ExamDataRepo dao) {
	this.dao = dao;
}


	
	


}
