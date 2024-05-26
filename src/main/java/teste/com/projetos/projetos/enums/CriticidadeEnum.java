package teste.com.projetos.projetos.enums;

public enum CriticidadeEnum {
	BAIXA(1, "Baixa"), MEDIA(2, "Média"), ALTA(3, "Alta");

	private int valor;
	private String descricao;

	CriticidadeEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public static String getDescricaoEnum(Integer valor) {
		for (CriticidadeEnum origem : CriticidadeEnum.values()) {
			if(valor != null) {
				if(origem.valor == valor) {
					return origem.descricao;
				}				
			}
		}
		return null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
