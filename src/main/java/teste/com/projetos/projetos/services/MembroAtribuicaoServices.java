package teste.com.projetos.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.com.projetos.projetos.model.MembroAtribuicao;
import teste.com.projetos.projetos.repositories.MembroAtribuicaoRepository;

@Service
public class MembroAtribuicaoServices {

	@Autowired
	private MembroAtribuicaoRepository repository;

	public boolean salvar(MembroAtribuicao membroAtribuicao) {
		repository.save(membroAtribuicao);
		if (membroAtribuicao.getId() != null) {
			return true;
		}
		return false;
	}

	public List<MembroAtribuicao> getAll() {
		return repository.findAll();
	}

	public boolean validarAtribuicao(Long id) {		
		return repository.existsById(id);
	}
}
