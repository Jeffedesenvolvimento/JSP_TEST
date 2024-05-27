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

import teste.com.projetos.projetos.model.Membro;
import teste.com.projetos.projetos.repositories.MembroRepository;
import teste.com.projetos.projetos.services.MembroServices;

@ExtendWith(MockitoExtension.class)
public class MembroServicesTest {

	@InjectMocks
	private MembroServices membroServices;
	
	@Mock
	private MembroRepository repository;
	
	List<Membro> list;
	
	Membro membro;
	
	@BeforeEach
	public void setUp() {
		this.membro = new Membro();
		membro.setId(1l);
		this.list = new ArrayList<Membro>();
	}
	
	@Test
	void salvarTrue() {
		when(repository.save(this.membro)).thenReturn(this.membro);
		var response = membroServices.salvar(this.membro);
		
		assertEquals(true, response);
	
	}
	
	@Test
	void salvarFalse() {
		this.membro.setId(null);
		when(repository.save(this.membro)).thenReturn(this.membro);
		var response = membroServices.salvar(this.membro);
		
		assertEquals(false, response);
	
	}
	
	@Test
	void getAll() {
		when(repository.findAll()).thenReturn(this.list);
		
		var response = membroServices.getAll();
		
		assertEquals(this.list, response);
	}
	
	@Test
	void validarAtribuicaoTrue() {
		when(repository.existsById(1l)).thenReturn(true);
		
		var response = membroServices.validarAtribuicao(1l);
		
		assertEquals(response, true);
	}
}
