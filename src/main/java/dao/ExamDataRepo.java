package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import data.ExamData;

@Repository
public class ExamDataRepo {
	
	private List<ExamData> examdata;
 
	public ExamDataRepo() {
		examdata = new ArrayList<ExamData>() {
			{
			add(new ExamData("123", "matematika", "milos", 2222, 6));	
			add(new ExamData("124", "srpski", "neko", 2223, 9));
			add(new ExamData("124", "matematika", "milos", 2224, 10));
			}
		};
	}

	public List<ExamData> getExamdata() {
		return examdata;
	}
	
	
	
}
