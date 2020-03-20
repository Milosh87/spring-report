package data;

public class ExamData {

	private String sifra;
	private String predmet;
	private String nastavnik;
	private int indeks;
	private int ocena;
	public ExamData(String sifra, String predmet, String nastavnik, int indeks, int ocena) {
		super();
		this.sifra = sifra;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.indeks = indeks;
		this.ocena = ocena;
	}
	
	
	public ExamData() {
		super();
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
	public int getIndeks() {
		return indeks;
	}
	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
}
