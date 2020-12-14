package operacao;

public abstract class OperacaoBancaria {

	private Long codigo;
	
	private String data;
	
	public abstract void efetuarOperacao (Long valor, Long codigoConta);

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public String getData()
   {
      return data;
   }

   public void setData(String data)
   {
      this.data = data;
   }
	
 	
	
}
