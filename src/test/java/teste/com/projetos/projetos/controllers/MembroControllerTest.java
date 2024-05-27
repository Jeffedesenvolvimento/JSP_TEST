package teste.com.projetos.projetos.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.lang.Nullable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import teste.com.projetos.projetos.model.Projeto;
import teste.com.projetos.projetos.repositories.ProjetoRepository;
import teste.com.projetos.projetos.services.ProjetoServices;

//@WebMvcTest(ProjetoController.class)
@ExtendWith(MockitoExtension.class)
public class MembroControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private ProjetoController projetoController;
	
	@Mock
	private ProjetoServices service;

	@MockBean
	private ProjetoRepository projetoRepository;

	Projeto projeto;

	@BeforeEach
	public void setUp() {
		this.projeto = new Projeto();
		projeto.setNome("Teste");
	}

	@Test
	void salvar() throws Exception {
		var response = projetoController.doPost(projeto);
		assertEquals("redirect:/", response);
	}
	@Test
	void editar() throws Exception {
		var response = projetoController.editSave(projeto);
		assertEquals("redirect:/", response);
	}

//	@Test
//	void findById() throws Exception {
//		when(service.findById(null)).thenReturn(new Projeto());
//	}

	@Test
	void deletarStatusIniciado() throws Exception {
		when(service.delete(4l)).thenReturn(false);
		var response = projetoController.delete(4l);
		assertEquals("Projeto com status sem permissão para exclusão", response);
	}
	@Test
	void deletarStatusEmAndamento() throws Exception {
		when(service.delete(6l)).thenReturn(false);
		var response = projetoController.delete(6l);
		assertEquals("Projeto com status sem permissão para exclusão", response);
	}

	@Test
	void deletarStatusEncerrado() throws Exception {
		when(service.delete(7l)).thenReturn(false);
		var response = projetoController.delete(7l);
		assertEquals("Projeto com status sem permissão para exclusão", response);
	}
	
	@Test
	void deletarSucesso() throws Exception {
		when(service.delete(5l)).thenReturn(true);
		var response = projetoController.delete(5l);
		assertEquals("redirect:/", response);
	}
	
	@Test
	void home() throws Exception {
		Model model = new ConcurrentModel();
		when(service.getAll()).thenReturn(Collections.singletonList(this.projeto));
		var response = projetoController.home((Model) model);
		assertEquals("projetoHome", response);
	}
	@Test
	void edit() throws Exception {
		Model model = new ConcurrentModel();
		when(service.findById(1l)).thenReturn(this.projeto);
		var response = projetoController.edit(1l, model);
		assertEquals("projetoEditar", response);
	}
	@Test
	void getCadastro() throws Exception {
		Model model = new ConcurrentModel();
		var response = projetoController.getCadastro(null, model);
		assertEquals("projetoCadastro", response);
	}
}
