package cadastro;

public class conta
{

   private Long codigo;

   private cliente cliente;

   private Long saldo;

   public conta(Long codigo, cadastro.cliente cliente, Long saldo)
   {
      super();
      this.codigo = codigo;
      this.cliente = cliente;
      this.saldo = saldo;
   }

   public conta()
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

   public cliente getCliente()
   {
      return cliente;
   }

   public void setCliente(cliente cliente)
   {
      this.cliente = cliente;
   }

   public Long getSaldo()
   {
      return saldo;
   }

   public void setSaldo(Long saldo)
   {
      this.saldo = saldo;
   }

}
