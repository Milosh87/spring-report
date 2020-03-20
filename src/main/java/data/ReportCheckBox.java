package data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope (scopeName="prototype")
public class ReportCheckBox {
	String type;
	private String sifra;
	private String predmet;
	private String nastavnik;
	private Integer indeks;
	private Integer ocena;
	private Double prosek;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getPredmet() {
		return predmet;
	}
	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}
	public String getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(String nastavnik) {
		this.nastavnik = nastavnik;
	}
	public Integer getIndeks() {
		return indeks;
	}
	public void setIndeks(Integer indeks) {
		this.indeks = indeks;
	}
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	
	public boolean sifraExists() {
		return sifra!= null;
	}
	public boolean predmetExists() {
		return predmet!= null;
	}
	public boolean nastavnikExists() {
		return nastavnik!= null;
	}
	public boolean indeksExists() {
		return indeks!= null;
	}
	public boolean ocenaExists() {
		return ocena!= null;
	}
	public Double getProsek() {
		return prosek;
	}
	public void setProsek(Double prosek) {
		this.prosek = prosek;
	}
	public boolean prosekExists() {
		return prosek!= null;
	}
	
	
	
}
