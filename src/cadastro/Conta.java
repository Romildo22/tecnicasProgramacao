package cadastro;

public class Conta
{
   private Long codigo;

   private Cliente cliente;

   private Long saldo;

   public Conta(Long codigo, Cliente cliente, Long saldo)
   {
      super();
      this.codigo = codigo;
      this.cliente = cliente;
      this.saldo = saldo;
   }

   public Conta()
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

   public Cliente getCliente()
   {
      return cliente;
   }

   public void setCliente(Cliente cliente)
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
