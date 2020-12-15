package metodos;

import cadastro.Cliente;
import cadastro.Conta;

import java.io.IOException;

import javax.swing.JOptionPane;

public class CadastrarCliente {

	public static void main(String[] args)throws IOException  {
		
		Cliente cliente = new Cliente();
		Conta conta = new Conta();
		MetodosGerais metodos = new MetodosGerais();
		
		Long cont = Long.parseLong("1");
		
		JOptionPane.showMessageDialog(null, "Para iniciar, vamos cadastrar um novo cliente!");
		String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente");
		String enderecoCliente = JOptionPane.showInputDialog("Digite o endereço do cliente");
		
		cliente.setCodigo(cont);
		cliente.setNome(nomeCliente);
		cliente.setEndereco(enderecoCliente);
		
		Long saldoConta = Long.parseLong(JOptionPane.showInputDialog("Agora digite um saldo inicial para o cliente"));
		
		conta.setCodigo(cont);
		conta.setCliente(cliente);
		conta.setSaldo(saldoConta);
		
		JOptionPane.showMessageDialog(null, "Agora vamos para o tipo de operação que deseja iniciar!");
		Long tipoOperacao = Long.parseLong(JOptionPane.showInputDialog("Digite : " + "\n" + "1 - para crédito" + "\n" + "2 - para débito." + "\n" + "\n"));
		Long saldoOperacao = Long.parseLong(JOptionPane.showInputDialog("Agora digite o valor que deseja operar."));
		
		metodos.setContaCliente(conta);
		
        metodos.efetuarOperacao(saldoOperacao, conta, tipoOperacao);
		
		metodos.salvarArquivo();
		
		cont++;
	}
	
}
