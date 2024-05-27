package teste.com.projetos.projetos.controllers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import teste.com.projetos.projetos.model.Membro;
import teste.com.projetos.projetos.model.Projeto;
import teste.com.projetos.projetos.repositories.ProjetoRepository;
import teste.com.projetos.projetos.services.ProjetoServices;

@ExtendWith(MockitoExtension.class)
public class ProjetoServicesTest {

	@InjectMocks
	private ProjetoServices projetoServices;
	
	@Mock
	private ProjetoRepository repository;
	
	List<Projeto> list;
	
	Projeto projeto;
	
	@BeforeEach
	public void setUp() {
		this.projeto = new Projeto();
		this.projeto.setId(1l);
		this.projeto.setStatus(1);
		this.list = new ArrayList<Projeto>();
	}
	
	@Test
	void salvar() {
		when(repository.save(this.projeto)).thenReturn(this.projeto);
		projetoServices.salvar(this.projeto);
	
	}
	
	@Test
	void getAll() {
		when(repository.findAll()).thenReturn(this.list);
		
		var response = projetoServices.getAll();
		
		assertEquals(this.list, response);
	}
	
	@Test
	void deletarTrue() {
		Optional<Projeto> projetos = Optional.of(this.projeto);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, true);
	}
	
	@Test
	void deletarFalseStatusIniciado() {
		this.projeto.setStatus(4);
		Optional<Projeto> projetos = Optional.of(this.projeto);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, false);
	}
	
	@Test
	void deletarFalseStatusEmAndamento() {
		this.projeto.setStatus(6);
		Optional<Projeto> projetos = Optional.of(this.projeto);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, false);
	}
	
	@Test
	void deletarFalseStatusEncerado() {
		this.projeto.setStatus(7);
		Optional<Projeto> projetos = Optional.of(this.projeto);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, false);
	}
	
	@Test
	void deletarFalseProjetoNull() {
		Optional<Projeto> projetos = Optional.ofNullable(null);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, false);
	}
	
	@Test
	void deletarFalseStatusNull() {
		this.projeto.setStatus(null);
		Optional<Projeto> projetos = Optional.of(this.projeto);
		when(repository.findById(1l)).thenReturn(projetos);
		var response = projetoServices.delete(1l);
		assertEquals(response, false);
	}
}
