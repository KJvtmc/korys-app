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
@Table(name = "kabinos")
public class Kabina {
	 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@ManyToOne
		@JoinColumn(name = "centras_id")
		private Centras centras;
		@Column
		@NotNull
		private Long kabinosId;
		@Column
		@NotNull
		public Boolean statusas;
		
		
		public Kabina() {
		}

		public Kabina(Centras centras, @NotNull Long kabinosId , @NotNull Boolean statusas) {
			super();
			this.centras = centras;
			this.kabinosId = kabinosId;
			this.statusas = statusas;
		}

		public Centras getCentras() {
			return centras;
		}

		@Qualifier("centras")
		@Autowired
		public void setCentras(Centras centras) {
			this.centras = centras;
		}

		public Long getId() {
			return kabinosId;
		}

		@Qualifier("kabinosNr")
		@Autowired
		public void setId(Long kabinosId ) {
			this.kabinosId = kabinosId ;
		}

		public Boolean getStatusas() {
			return statusas;
		}

		@Qualifier("statusas")
		@Autowired
		public void setStatusas(Boolean statusas) {
			this.statusas = statusas;
		}
		
		
		

	
}
