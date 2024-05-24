package teste.com.projetos.projetos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Projeto")
public class Projeto {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nome;
	private String gpResponsavel;
	private String orcamento;
	private String dtInicio;
	private String dtPrevisaoTermino;
	private String dtRealTermino;
	private String descricao;
	private String status;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGpResponsavel() {
		return gpResponsavel;
	}
	public void setGpResponsavel(String gpResponsavel) {
		this.gpResponsavel = gpResponsavel;
	}
	public String getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getDtPrevisaoTermino() {
		return dtPrevisaoTermino;
	}
	public void setDtPrevisaoTermino(String dtPrevisaoTermino) {
		this.dtPrevisaoTermino = dtPrevisaoTermino;
	}
	public String getDtRealTermino() {
		return dtRealTermino;
	}
	public void setDtRealTermino(String dtRealTermino) {
		this.dtRealTermino = dtRealTermino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", gpResponsavel=" + gpResponsavel + ", orcamento=" + orcamento + ", dtInicio="
				+ dtInicio + ", dtPrevisaoTermino=" + dtPrevisaoTermino + ", dtRealTermino=" + dtRealTermino
				+ ", descricao=" + descricao + ", status=" + status + "]";
	}
	
	
}
