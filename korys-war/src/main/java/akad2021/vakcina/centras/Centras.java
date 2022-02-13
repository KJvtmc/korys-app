package akad2021.vakcina.centras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name = "centrai")
public class Centras{
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column
	@NotNull
	@Length(min = 1, max = 30)
	public String pavadinimas;
	@Column
	@NotNull
	public String imgNuoroda;
	@Column
	@NotNull
	@Length(min = 12)
	public String aprasymas;
	@Column
	@NotNull
	public String vieta;
	@OneToMany (mappedBy="centras")
	public List<Kabina> kabinos=new ArrayList<Kabina>();
	
	@OneToMany (mappedBy="centras")
	public List<Vakcina> vakcinos=new ArrayList<Vakcina>();
	
	public Centras() {
	}

	public Centras( @NotNull @Length(min = 1, max = 30) String pavadinimas, @NotNull String imgNuoroda,
			@NotNull @Length(min = 12) String aprasymas, String vieta, List<Kabina> kabinos, List<Vakcina> vakcinos) {
		super();
		this.pavadinimas = pavadinimas;
		this.imgNuoroda = imgNuoroda;
		this.aprasymas = aprasymas;
		this.vieta = vieta;
		this.kabinos = kabinos;
		this.vakcinos = vakcinos;
	}

	
	
	public String getVieta() {
		return vieta;
	}

	@Qualifier("vieta")
	@Autowired
	public void setVieta(String vieta) {
		this.vieta = vieta;
	}

	public List<Kabina> getKabinos() {
		return kabinos;
	}
	
	

	@Qualifier("kabinos")
	@Autowired
	public void setKabinos(List<Kabina> kabinos) {
		this.kabinos = kabinos;
	}
	
	public void addKabinos(Kabina kabina) {
		this.kabinos.add(kabina);
		kabina.setCentras(this);
	}

	public List<Vakcina> getVakcinos() {
		return vakcinos;
	}

	@Qualifier("vakcinos")
	@Autowired
	public void setVakcinos(List<Vakcina> vakcinos) {
		this.vakcinos = vakcinos;
	}
	
	public void addVakcinos(Vakcina vakcina) {
		this.vakcinos.add(vakcina);
		vakcina.setCentras(this);
	}

	public String getPavadinimas() {
		return pavadinimas;
	}
	@Qualifier("pavadinimas")
	@Autowired
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	public String getImgNuoroda() {
		return imgNuoroda;
	}
	@Qualifier("imgNuoroda")
	@Autowired
	public void setImgNuoroda(String imgNuoroda) {
		this.imgNuoroda = imgNuoroda;
	}
	public String getAprasymas() {
		return aprasymas;
	}
	@Qualifier("aprasymas")
	@Autowired
	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	};
}
