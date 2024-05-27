package teste.com.projetos.projetos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import teste.com.projetos.projetos.model.Membro;
import teste.com.projetos.projetos.model.MembroAtribuicao;
import teste.com.projetos.projetos.services.MembroAtribuicaoServices;
import teste.com.projetos.projetos.services.MembroServices;

@ExtendWith(MockitoExtension.class)
public class ProjetoControllerTest {


	@InjectMocks
	private MembroController membroController;
	
	@Mock
	private MembroServices service;
	
	@Mock
	private MembroAtribuicaoServices atribuicaoServices;


	Membro membro;

	MembroAtribuicao membroAtribuicao;
	
	@BeforeEach
	public void setUp() {
		this.membro = new Membro();
		this.membroAtribuicao = new MembroAtribuicao();
		membro.setNome("Teste");
		membroAtribuicao.setId(1l);
		membro.setTipo(membroAtribuicao);
	}

	@Test
	void home() throws Exception {
		when(service.getAll()).thenReturn(Collections.singletonList(this.membro));
		var response = membroController.home();
		assertNotNull(response);;
	}


	@Test
	void doPostTrue() throws Exception {
		when(atribuicaoServices.validarAtribuicao(1l)).thenReturn(true);
		when(service.salvar(membro)).thenReturn(true);
		var response = membroController.doPost(membro);
		assertEquals("criado com sucesso.", response);
	}
	
	@Test
	void doPostError() throws Exception {
		when(atribuicaoServices.validarAtribuicao(1l)).thenReturn(true);
		when(service.salvar(membro)).thenReturn(false);
		var response = membroController.doPost(membro);
		assertEquals("erro", response);
	}
	
	
	@Test
	void doPostSemAtribuicaoInexistente() throws Exception {
		when(atribuicaoServices.validarAtribuicao(1l)).thenReturn(false);
		var response = membroController.doPost(membro);
		assertEquals("Atribuição não existe.", response);
	}
}
