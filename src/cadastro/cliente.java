package cadastro;

public class cliente
{

   private Long codigo;

   private String nome;

   private String endereco;

   public cliente(Long codigo, String nome, String endereco)
   {
      super();
      this.codigo = codigo;
      this.nome = nome;
      this.endereco = endereco;
   }

   public cliente()
   {
      super();
   }

   public Long getCodigo()
   {
      return codigo;
   }

   public void setCodigo(Long codigo)
   {
      this.codigo = codigo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getEndereco()
   {
      return endereco;
   }

   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }

}
