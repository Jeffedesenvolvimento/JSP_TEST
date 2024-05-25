package teste.com.projetos.projetos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/home")
	public String home(@ModelAttribute("message") String message, Model model) {
		List<Projeto> lista = projetoServices.getAll();
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("projetoList", lista);
		model.addAttribute("message", message);
		return "projetoHome";
	}

	@RequestMapping(value = "/projetoCadastro")
	public String getCadastro(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("message", message);
		return "projetoCadastro";
	}

	@PostMapping(value = "/cadastrar")
	public String doPost(Projeto projeto, RedirectAttributes redirectAttributes, Model model) {
		if (this.projetoServices.salvar(projeto)) {
			model.addAttribute("projetoList", projetoServices.getAll());
			model.addAttribute("projeto", new Projeto());
			redirectAttributes.addFlashAttribute("message", "Cadastrado com sucesso");
			projeto = null;
		} else {
			redirectAttributes.addFlashAttribute("message", "Erro ao cadastrar");
		}
		return "redirect:/home";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
		projetoServices.delete(id);
		return "redirect:/home";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Projeto p = projetoServices.findById(id);
		model.addAttribute("projeto", p);
		return "projetoEditar";
	}

	@PostMapping("/editSave")
	public String editSave(Projeto projeto, RedirectAttributes redirectAttributes) {
		if (projetoServices.salvar(projeto)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/home";
		}

		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/home";
	}
	
	@ResponseBody
	@GetMapping(value = "projeto/all")
	public List<Projeto> home() {

		return projetoServices.getAll();
	}
}
