package akad2021.vakcina.centras;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import akad2021.vakcina.dao.CentrasDao;

@Service
public class CentrasService {
	@Autowired
	private CentrasDao centrasDao;
	

	@Transactional(readOnly = true)
	public List<CentrasFromService> getCentrai() {
		return centrasDao.findAll().stream()
				.map(centras -> new CentrasFromService(centras.getPavadinimas(),centras.getImgNuoroda(),centras.getAprasymas()))
				.collect(Collectors.toList()); 
	}
	@Transactional
	public void setCentras(CentrasFromService centrasFromService) {
		var centras = new Centras(centrasFromService.getPavadinimas(),centrasFromService.getImgNuoroda(),centrasFromService.getAprasymas());
		centrasDao.save(centras);
	}


	public CentrasDao getCentrasDao() {
		return centrasDao;
	}


	public void setCentrasDao(CentrasDao centrasDao) {
		this.centrasDao = centrasDao;
	}

}
