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
	
	public boolean salvar (Projeto projeto) {			
		projetoRepository.save(projeto);
		if(projeto.getId() != null) {
			return true;
		}
		return false;
	}

	public List<Projeto> getAll() {
		// TODO Auto-generated method stub
		return projetoRepository.findAll();
	}
}
