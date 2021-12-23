package akad2021.vakcina.centras;

public class CentrasFromService {
	
	public String pavadinimas;
	public String imgNuoroda;
	public String aprasymas;
	
	public CentrasFromService() {
	}
	
	
	public CentrasFromService(String pavadinimas, String imgNuoroda, String aprasymas) {
		super();
		this.pavadinimas = pavadinimas;
		this.imgNuoroda = imgNuoroda;
		this.aprasymas = aprasymas;
	}


	public String getPavadinimas() {
		return pavadinimas;
	}


	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}


	public String getImgNuoroda() {
		return imgNuoroda;
	}


	public void setImgNuoroda(String imgNuoroda) {
		this.imgNuoroda = imgNuoroda;
	}


	public String getAprasymas() {
		return aprasymas;
	}


	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}



}
