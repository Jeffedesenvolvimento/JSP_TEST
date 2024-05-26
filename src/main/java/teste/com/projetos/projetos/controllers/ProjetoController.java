package teste.com.projetos.projetos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import teste.com.projetos.projetos.model.Projeto;
import teste.com.projetos.projetos.services.ProjetoServices;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoServices projetoServices;

	@RequestMapping(value = "/")
	public String home(Model model) { 
		List<Projeto> lista = projetoServices.getAll();
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("projetoList", lista);
		return "projetoHome";
	}

	@RequestMapping(value = "/projetoCadastro")
	public String getCadastro(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("message", message);
		return "projetoCadastro";
	}

	@PostMapping(value = "/cadastrar")
	public String doPost(Projeto projeto) {
		this.projetoServices.salvar(projeto);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		if (projetoServices.delete(id)) {
			return "redirect:/";
		}else {
			return "Projeto com status sem permissão para exclusão";
		}
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Projeto p = projetoServices.findById(id);
		model.addAttribute("projeto", p);
		return "projetoEditar";
	}

	@PostMapping("/editar")
	public String editSave(Projeto projeto) {
		projetoServices.salvar(projeto);
		return "redirect:/";
	}

}
