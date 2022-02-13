package akad2021.vakcina.centras;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import akad2021.vakcina.PagingData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "centras-servisas")
@RequestMapping(value = "/vakcinacija/centrai")
public class CentrasController {
	@Autowired
	private final CentrasService centrasService;
	@Autowired
	@Qualifier("pagingData")
	private PagingData pagingData;
	
    public CentrasController(@Qualifier("centrasService") CentrasService centrasService) {
		super();
		this.centrasService = centrasService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get centre",notes="Returns all vaccination centres")
    public List<Centras> getCentrai() {
		pagingData.setLimit(10);
		return centrasService.getCentrai()
				.stream()
				.map(centras->new Centras(centras.getPavadinimas(), centras.getImgNuoroda(), centras.getAprasymas(), centras.getVieta(), centras.getKabinos(), centras.getVakcinos()))
				.collect(Collectors.toList()); 
    }
	@RequestMapping(method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Save vaccination center",notes="Requares all parameters: name, img link, description")
	public void createCentras( @RequestBody Centras centras) {
		centrasService.setCentras(new CentrasFromService(
				centras.getPavadinimas(),
				centras.getImgNuoroda(),
				centras.getAprasymas(),
				centras.getVieta(),
				centras.getKabinos(), 
				centras.getVakcinos()
				));
	}
}
