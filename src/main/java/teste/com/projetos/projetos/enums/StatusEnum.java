package teste.com.projetos.projetos.enums;

public enum StatusEnum {
	ANALISE (1,"Análise"),
	ANALISE_REALIZADA (2,"Análise realizada"),
	ANALISE_APROVADA (3,"Análise Aprovada"),
	INICIADO (4,"Iniciado"),
	PLANEJADO (5,"Planejado"),
	EM_ANDAMENTO(6,"Em andamento"),
	ENCERRADO(7,"Encerrado"),
	CANCELADO(8,"Cancelado");

	private int valor;
	private String descricao;
	
	StatusEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public static String getDescricaoEnum(Integer valor) {
		for (StatusEnum origem : StatusEnum.values()) {
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
