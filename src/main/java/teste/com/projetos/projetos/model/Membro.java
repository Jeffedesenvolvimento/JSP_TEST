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

@Entity
@Table(name = "Membro")
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "MembroAtribuicao_id")
	private MembroAtribuicao tipo;

	public Membro() {
		super();
	}

	public Membro(Long id, String nome, MembroAtribuicao tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

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

	public MembroAtribuicao getTipo() {
		return tipo;
	}

	public void setTipo(MembroAtribuicao tipo) {
		this.tipo = tipo;
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
		Membro other = (Membro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Membro [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
	}

}
