package akad2021.vakcina.centras;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CentrasFromService {
	
	public String pavadinimas;
	public String imgNuoroda;
	public String aprasymas;
	public String vieta;
	public List<Kabina> kabinos;
	public List<Vakcina> vakcinos;
	
	
	public CentrasFromService() {
	}

	public CentrasFromService(String pavadinimas, String imgNuoroda, String aprasymas,String vieta, List<Kabina> kabinos,
			List<Vakcina> vakcinos) {
		super();
		this.pavadinimas = pavadinimas;
		this.imgNuoroda = imgNuoroda;
		this.aprasymas = aprasymas;
		this.vieta=vieta;
		this.kabinos = kabinos;
		this.vakcinos = vakcinos;
	}


	public String getVieta() {
		return vieta;
	}

	public void setVieta(String vieta) {
		this.vieta = vieta;
	}

	public void setKabinos(List<Kabina> kabinos) {
		this.kabinos = kabinos;
	}

	public void setVakcinos(List<Vakcina> vakcinos) {
		this.vakcinos = vakcinos;
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


	public List<Vakcina> getVakcinos() {
		return vakcinos;
	}


	public List<Kabina> getKabinos() {
		return kabinos;
	}





}
