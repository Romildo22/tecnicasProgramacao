package metodos;

import operacao.OperacaoBancaria;
import cadastro.conta;

public class metodosGerais extends OperacaoBancaria {
   conta contaCliente = new conta();
   Long novoSaldo = null;
   Long saldoSub = null;
   
   public static final long OPERACAO_CREDITO = 1;

   public static final long OPERACAO_DEBITO = 2;
   
   @Override
   public void efetuarOperacao(Long valor, Long codigoConta)
   {
     this.credito(valor, codigoConta);
     
     this.debito(valor, codigoConta);
   }
   
   public void credito( Long valor, Long codigoConta) {
      
      if(codigoConta != null)
      {
      contaCliente.setCodigo(codigoConta);
      novoSaldo = contaCliente.getSaldo() + valor;
      contaCliente.setSaldo(novoSaldo);
      }
   }
    
   public void debito(Long valor, Long codigoConta) {
      
      if(codigoConta != null) {
         contaCliente.setCodigo(codigoConta);
         
         if(valor <= 0) 
         {
            if(contaCliente.getSaldo() >= valor)
            {
               
               saldoSub = contaCliente.getSaldo() - valor;
               contaCliente.setSaldo(saldoSub);
               
            }
            else 
            {
               System.out.println("SaldoInsuficienteException: saldo em conta inferior ao valor do débito!");
            }
         }
         else
         {
            System.out.println("DebitoIndevidoException: um valor indevido foi enviado para débito!");
         }
      }
   }
   
   
   
}