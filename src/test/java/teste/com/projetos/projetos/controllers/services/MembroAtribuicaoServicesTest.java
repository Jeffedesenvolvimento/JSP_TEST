package teste.com.projetos.projetos.controllers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import teste.com.projetos.projetos.model.MembroAtribuicao;
import teste.com.projetos.projetos.repositories.MembroAtribuicaoRepository;
import teste.com.projetos.projetos.services.MembroAtribuicaoServices;

@ExtendWith(MockitoExtension.class)
public class MembroAtribuicaoServicesTest {

	@InjectMocks
	private MembroAtribuicaoServices atribuicaoServices;
	
	@Mock
	private MembroAtribuicaoRepository repository;
	
	List<MembroAtribuicao> atribuicaos;
	
	MembroAtribuicao membroAtribuicao;
	
//	Membro membro;
	
	@BeforeEach
	public void setUp() {
		this.membroAtribuicao = new MembroAtribuicao();
		membroAtribuicao.setId(1l);
		this.atribuicaos = new ArrayList<MembroAtribuicao>();
	}
	
	@Test
	void salvarTrue() {
		when(repository.save(this.membroAtribuicao)).thenReturn(this.membroAtribuicao);
		var response = atribuicaoServices.salvar(this.membroAtribuicao);
		
		assertEquals(true, response);
	
	}
	
	@Test
	void salvarFalse() {
		this.membroAtribuicao.setId(null);
		when(repository.save(this.membroAtribuicao)).thenReturn(this.membroAtribuicao);
		var response = atribuicaoServices.salvar(this.membroAtribuicao);
		
		assertEquals(false, response);
	
	}
	
	@Test
	void getAll() {
		when(repository.findAll()).thenReturn(this.atribuicaos);
		
		var response = atribuicaoServices.getAll();
		
		assertEquals(this.atribuicaos, response);
	}
	
	@Test
	void validarAtribuicaoTrue() {
		when(repository.existsById(1l)).thenReturn(true);
		
		var response = atribuicaoServices.validarAtribuicao(1l);
		
		assertEquals(response, true);
	}
}
