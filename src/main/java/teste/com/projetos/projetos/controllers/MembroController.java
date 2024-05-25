package teste.com.projetos.projetos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import teste.com.projetos.projetos.model.Membro;
import teste.com.projetos.projetos.services.MembroAtribuicaoServices;
import teste.com.projetos.projetos.services.MembrosServices;

@Controller
public class MembroController {

	@Autowired
	private MembrosServices membrosServices;
	
	@Autowired
	private MembroAtribuicaoServices atribuicaoServices;

	@ResponseBody
	@GetMapping(value = "/membros")
	public List<Membro> home() {

		return membrosServices.getAll();
	}

	@ResponseBody
	@PostMapping(value = "/membro/cadastrar")
	public String doPost(@RequestBody Membro membro) {
		if (this.atribuicaoServices.validarAtribuicao(membro.getTipo().getId())) {
			if (this.membrosServices.salvar(membro)) {
				return "criado com sucesso.";
			}

		}else {
			return "Atribuição não existe.";
		}
		return "erro";
	}
}
