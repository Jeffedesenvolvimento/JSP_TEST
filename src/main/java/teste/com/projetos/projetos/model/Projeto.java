package teste.com.projetos.projetos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import teste.com.projetos.projetos.enums.CriticidadeEnum;
import teste.com.projetos.projetos.enums.StatusEnum;

@Entity
@Table(name = "Projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "membro_id")
	private Membro gpResponsavel;
	private String orcamento;
	private String dtInicio;
	private String dtPrevisaoTermino;
	private String dtRealTermino;
	private String descricao;
	private Integer status;
	private Integer criticidade;

	@Transient
	private String statusDescricao;

	@Transient
	private String criticidadeDescricao;

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

	public Membro getGpResponsavel() {
		return gpResponsavel;
	}

	public void setGpResponsavel(Membro gpResponsavel) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(Integer criticidade) {
		this.criticidade = criticidade;
	}

	public String getStatusDescricao() {
		this.statusDescricao = StatusEnum.getDescricaoEnum(this.getStatus());
		return statusDescricao;
	}

	public void setStatusDescricao(String statusDescricao) {
		this.statusDescricao = statusDescricao;
	}

	public String getCriticidadeDescricao() {
		this.criticidadeDescricao = CriticidadeEnum.getDescricaoEnum(this.getCriticidade());
		return criticidadeDescricao;
	}

	public void setCriticidadeDescricao(String criticidadeDescricao) {
		this.criticidadeDescricao = criticidadeDescricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", gpResponsavel=" + gpResponsavel + ", orcamento=" + orcamento
				+ ", dtInicio=" + dtInicio + ", dtPrevisaoTermino=" + dtPrevisaoTermino + ", dtRealTermino="
				+ dtRealTermino + ", descricao=" + descricao + ", status=" + status + ", criticidade=" + criticidade
				+ ", statusDescricao=" + statusDescricao + ", criticidadeDescricao=" + criticidadeDescricao + "]";
	}

	
}
