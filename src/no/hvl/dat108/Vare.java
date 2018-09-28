package no.hvl.dat108;

public class Vare {
	private String navn;
	private  double pris;
	
	public Vare(String navn, double pris) {
		super();
		this.navn = navn;
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public double getPris() {
		return pris;
	}

	@Override
	public String toString() {
		return "Vare [navn=" + navn + ", pris=" + pris + "]";
	}
	
	
	

}
