package operacao;

public class HistoricoBancario {
	
	private Long codigo;
	
	private String descricaoTipoOperacao;
	
	private Long valor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoTipoOperacao() {
		return descricaoTipoOperacao;
	}

	public void setDescricaoTipoOperacao(String descricaoTipoOperacao) {
		this.descricaoTipoOperacao = descricaoTipoOperacao;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

}
