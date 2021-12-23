package akad2021.vakcina;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReactErrorController implements ErrorController {
	@RequestMapping("/error")
	public String index() {
		return "index.html"; // paprastai kol be security
	}
	
//	pasalinamas migruojant is 2.4.0->2.6.0
//	@Override
//	public String getErrorPath() {
//	return "index.html";
//	}
}