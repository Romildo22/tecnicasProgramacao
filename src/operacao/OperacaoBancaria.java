package operacao;

public abstract class OperacaoBancaria {

	private int codigo;
	
	private String data;
	
	public OperacaoBancaria(int codigo, String data) {
		super();
		this.codigo = codigo;
		this.data = data;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
