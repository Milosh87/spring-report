package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyBeanConfig;
import data.ReportCheckBox;
import service.ReportService;

@Component
public class Main {
	
	
	private ReportService reportService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		Main main = container.getBean("main", Main.class);
		ReportCheckBox reportCheckBox = container.getBean("reportCheckBox", ReportCheckBox.class);
		
	//	reportCheckBox.setNastavnik("milos");
		reportCheckBox.setSifra("124");
	//	reportCheckBox.setType("matematika");
		reportCheckBox.setOcena(7);
		reportCheckBox.setType("predmet");
		
		main.printReport(reportCheckBox);
		
		System.out.println("=================PROSEK======================");
		

		reportCheckBox = container.getBean("reportCheckBox", ReportCheckBox.class);
		
			reportCheckBox.setNastavnik("milos");
			//reportCheckBox.setSifra("124");
		//	reportCheckBox.setType("matematika");
			reportCheckBox.setOcena(6);
			reportCheckBox.setSifra("124");
			reportCheckBox.setType("ocena");
		
		main.printReport(reportCheckBox);
		
		
	}

	
	@Autowired
	@Qualifier(value = "reportServiceImpl")
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	public void printReport(ReportCheckBox reportCheckBox) {
		reportService.print(reportCheckBox);
	}
	
	

}
