package akad2021.vakcina.centras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name = "vakcinu_partijos")
public class Vakcina {
	
	@Id
	private Long partijosId;
	@ManyToOne
	@JoinColumn(name = "centras_id")
	private Centras centras;
	@Column
	@NotNull
	private String gamintojas;
	@Column
	@NotNull
	private String pavadinimas;
	@Column
	@NotNull
	public int kiekis;
	
	public Vakcina() {
	}

	public Vakcina(Long partijosId, Centras centras, @NotNull String gamintojas, @NotNull String pavadinimas, @NotNull int kiekis) {
		super();
		this.partijosId=partijosId;
		this.centras = centras;
		this.gamintojas = gamintojas;
		this.pavadinimas = pavadinimas;
		this.kiekis = kiekis;
	}
	
	public Long getPartijosId() {
		return partijosId;
	}

	@Qualifier("partija")
	@Autowired
	public void setPartijosId(Long partijosId) {
		this.partijosId = partijosId;
	}

	public String getGamintojas() {
		return gamintojas;
	}

	@Qualifier("gamintojas")
	@Autowired
	public void setGamintojas(String gamintojas) {
		this.gamintojas = gamintojas;
	}
	
	public Centras getCentras() {
		return centras;
	}


	@Qualifier("centras")
	@Autowired
	public void setCentras(Centras centras) {
		this.centras = centras;
	}
	
	public String getPavadinimas() {
		return pavadinimas;
	}

	@Qualifier("vakcinosPavadinimas")
	@Autowired
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public int getKiekis() {
		return kiekis;
	}

	@Qualifier("vakcinosKiekis")
	@Autowired
	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

	
}
