package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import data.ReportCheckBox;
import report.Report;

import service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	
	private Report reportPredmet;
	
	private Report reportOcena;


	
	public void print(ReportCheckBox reportCheckBox) {
		
		if(reportCheckBox.getType().equals("predmet")) {
			reportPredmet.printReport(reportCheckBox);
		}
		else if (reportCheckBox.getType().equals("ocena")) {
			reportOcena.printReport(reportCheckBox);
		}
		
	}
	@Autowired
	@Qualifier(value = "reportPredmet")
	public void setReportPredmet(Report reportPredmet) {
		this.reportPredmet = reportPredmet;
	}
	@Autowired
	@Qualifier(value = "reportOcena")
	public void setReportProsek(Report reportOcena) {
		this.reportOcena = reportOcena;
	}

}
