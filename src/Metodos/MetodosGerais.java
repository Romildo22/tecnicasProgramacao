package Metodos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Cadastro.Conta;
import Operacao.HistoricoBancario;
import Operacao.OperacaoBancaria;

public class MetodosGerais extends OperacaoBancaria{
	
   Conta contaCliente = new Conta();
   HistoricoBancario historicoBancario = new HistoricoBancario();
   
   Long novoSaldo = null;
   Long saldoSub = null;
   
   public static final long OPERACAO_CREDITO = 1;

   public static final long OPERACAO_DEBITO = 2;
   
   static ArrayList<HistoricoBancario> operacao = new ArrayList<HistoricoBancario>();
   
   public Conta setContaCliente(Conta conta ) {
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
         
         if(valor > 0) 
         {
            if(contaCliente.getSaldo() >= valor)
            {
               saldoSub = contaCliente.getSaldo() - valor;
               contaCliente.setSaldo(saldoSub);
            }
            else 
            {
            	JOptionPane.showMessageDialog(null, "SaldoInsuficienteException: saldo em conta inferior ao valor do débito!" +
            			"\n" + "Cliente : " + contaCliente.getCliente().getNome());
            }
         }
         else
         {
        	 JOptionPane.showMessageDialog(null, "DebitoIndevidoException: um valor indevido foi enviado para débito!" +
         			"\n" + "Cliente : " + contaCliente.getCliente().getNome());
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
				if(item.getDescricaoTipoOperacao() == "Cr�dito")
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
   
   public void salvarArquivo() {
	   File file = new File("C:\\Users\\Aptare Developer 02\\Desktop\\teste\\banco.txt");
	   
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

           wr.write("Código da conta : " + contaCliente.getCodigo() + "\n");
           wr.write("Saldo da conta : " + contaCliente.getSaldo() + "\n");
           wr.write("\n"+"Código do cliente : " + contaCliente.getCliente().getCodigo() + "\n");
           wr.write("Nome do cliente : " + contaCliente.getCliente().getNome() + "\n");
           wr.write("Endereço do cliente : " + contaCliente.getCliente().getEndereco() + "\n");
           
           for(HistoricoBancario item : operacao){
              if(item.getDescricaoTipoOperacao() == "Débito")
              {
                 wr.write("Saldo inicial : " + (item.getValor() + contaCliente.getSaldo()) + "\n");
              }
              else
              {
                 wr.write("Saldo inicial : " + Math.abs(item.getValor() - contaCliente.getSaldo()) + "\n");
              }
               wr.write("\n"+"Código do historico : " + item.getCodigo() + "\n");
               wr.write("Tipo de operação : " + item.getDescricaoTipoOperacao() + "\n");
               wr.write("Valor da operação : " + item.getValor() + "\n");
           } 
           
           wr.close();
           
       }catch(IOException io){
           io.printStackTrace();
       }
   }
   
}