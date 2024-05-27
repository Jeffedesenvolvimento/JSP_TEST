package teste.com.projetos.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.com.projetos.projetos.model.Projeto;
import teste.com.projetos.projetos.repositories.ProjetoRepository;

@Service
public class ProjetoServices {

	@Autowired
	private ProjetoRepository projetoRepository;

	public void salvar(Projeto projeto) {
		projetoRepository.save(projeto);
	}

	public List<Projeto> getAll() {
		return projetoRepository.findAll(); 
	}

	public boolean delete(Long id) {
		if(this.validarStatusExclucao(id)) {
			projetoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Projeto findById(Long id) {
		return projetoRepository.findById(id).orElse(null);
	}

	public boolean validarStatusExclucao(Long id) {
		Projeto p = this.findById(id);
		if (p != null && p.getStatus() != null && p.getStatus() !=4 && p.getStatus() !=6 && p.getStatus() !=7 ) {
			return true;
		}

		return false;

	}
}
