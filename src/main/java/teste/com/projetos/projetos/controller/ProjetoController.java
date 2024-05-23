package teste.com.projetos.projetos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjetoController {

	@RequestMapping(value = "/")
	public String teste() {
		return "projeto";
	}
}
