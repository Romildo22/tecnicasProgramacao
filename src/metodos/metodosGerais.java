package metodos;

import operacao.HistoricoBancario;
import operacao.OperacaoBancaria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cadastro.Conta;

public class metodosGerais extends OperacaoBancaria{
	
   static Conta contaCliente = new Conta();
   HistoricoBancario historicoBancario = new HistoricoBancario();
   
   Long novoSaldo = null;
   Long saldoSub = null;
   
   public static final long OPERACAO_CREDITO = 1;

   public static final long OPERACAO_DEBITO = 2;
   
   static ArrayList<HistoricoBancario> operacao = new ArrayList<HistoricoBancario>();
   
   public static Conta setContaCliente(Conta conta ) {
	   return contaCliente = conta;
   }
   
   public static void testeOperacao(Long valor, Long codigoConta, Long tipoOperacao) {
	   
   }
   
   @Override
   public void efetuarOperacao(Long valor, Conta conta, Long tipoOperacao)
   {
	   if(tipoOperacao == OPERACAO_CREDITO)
	   {
		   historicoBancario.setCodigo(contaCliente.getCodigo());
		   historicoBancario.setDescricaoTipoOperacao("Crédito");
		   historicoBancario.setValor(valor);
		   adicionarHistoricoBancario(historicoBancario);
		   this.credito(valor, conta.getCodigo());
	   }
	   
	   if(tipoOperacao == OPERACAO_DEBITO)
	   {
		   historicoBancario.setCodigo(contaCliente.getCodigo());
		   historicoBancario.setDescricaoTipoOperacao("Débito");
		   historicoBancario.setValor(valor);
		   adicionarHistoricoBancario(historicoBancario);
		   this.debito(valor, conta.getCodigo());
	   }
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
            	JOptionPane.showMessageDialog(null, "SaldoInsuficienteException: saldo em conta inferior ao valor do debito!" +
            			"\n" + "CLiente :" + contaCliente.getCliente().getNome());
            }
         }
         else
         {
        	 JOptionPane.showMessageDialog(null, "DebitoIndevidoException: um valor indevido foi enviado para debito!" +
         			"\n" + "CLiente :" + contaCliente.getCliente().getNome());
         }
      }
   }
   
   public void adicionarHistoricoBancario(HistoricoBancario historico) {
	   operacao.add(historico);
   }
   
   public void getHistoricoBancario(int opcao)
   {
	   for (HistoricoBancario item : operacao)
	   {
			if(opcao == 1)
			{
				if(item.getDescricaoTipoOperacao() == "Crédito")
				{
					System.out.println(item);
				}
			}
			else if(opcao == 2)
			{
				if(item.getDescricaoTipoOperacao() == "Debito")
				{
					System.out.println(item);
				}
			}
			else
			{
				System.out.println(item);
			}
	   }
   }
   
   public static void salvarArquivo() {
	   File file = new File("C:\\Users\\Romildo\\Desktop\\teste\\banco.txt");
	   
	   try{
           file.createNewFile();
       }
       catch(IOException io){
           io.printStackTrace();
       }
           //tratamento para criacao do arquivo
       try{
           FileWriter fw  = new FileWriter(file.getAbsoluteFile());
           BufferedWriter wr = new BufferedWriter(fw);

           wr.write(contaCliente + "\n");
           
           for(HistoricoBancario item : operacao){
               wr.write(item + "\n");
           } 
           
           wr.close();
           
       }catch(IOException io){
           io.printStackTrace();
       }
   }
   
}