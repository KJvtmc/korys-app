package akad2021.vakcina.centras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@Entity
@Table(name = "centrai")
public class Centras{
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public Centras() {
	}
	public Centras(String title, String imgNuoroda, String aprasymas) {
		super();
		this.pavadinimas = title;
		this.imgNuoroda = imgNuoroda;
		this.aprasymas = aprasymas;
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
