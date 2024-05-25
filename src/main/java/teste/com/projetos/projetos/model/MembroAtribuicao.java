package teste.com.projetos.projetos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MembroAtribuicao")
public class MembroAtribuicao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String nomeFuncao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
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
		MembroAtribuicao other = (MembroAtribuicao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MembroAtribuicao [id=" + id + ", nomeFuncao=" + nomeFuncao + "]";
	}
	
}
