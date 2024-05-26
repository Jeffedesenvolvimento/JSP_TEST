package teste.com.projetos.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.com.projetos.projetos.model.Membro;
import teste.com.projetos.projetos.repositories.MembroRepository;

@Service
public class MembroServices {

	@Autowired
	private MembroRepository repository;

	public boolean salvar(Membro membro) {
		repository.save(membro);
		if (membro.getId() != null) {
			return true;
		}
		return false;
	}

	public List<Membro> getAll() {
		return repository.findAll();
	}

	public boolean validarAtribuicao(Long id) {		
		return repository.existsById(id);
	}
}
