package bancodigital.service;

import java.util.Scanner;

import bancodigital.domain.Agencia;
import bancodigital.domain.Cidade;
import bancodigital.domain.Cliente;
import bancodigital.domain.Conta;
import bancodigital.domain.ContaCorrente;
import bancodigital.domain.ContaPoupanca;
import bancodigital.domain.Endereco;
import bancodigital.domain.Telefone;

public class AgenciaOperacoes {
	
	public static void criarConta(Scanner sc, Cidade cidade, Agencia agencia) {
		System.out.println("--CRIAR CONTA-- \n");
		
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Email: ");
		String email = sc.nextLine();
		
		System.out.println("CPF: ");
		String cpf = sc.nextLine();
		
		if (verificaRegraDeNegiocio(agencia, cpf)) {
			criarConta(sc, cidade, agencia);
		}
		
		System.out.println("Idade: ");
		Integer idade = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Sexo: ");
		String sexo = sc.nextLine();
		
		System.out.println("Telefone: ");
		String telefone = sc.nextLine();
		
		System.out.println("--ENDERECO-- \n");
		
		System.out.println("Rua: ");
		String rua = sc.nextLine();
		
		System.out.println("Numero: ");
		String numero = sc.nextLine();
		
		System.out.println("Bairro");
		String bairro = sc.nextLine();
		
		System.out.println("CEP: ");
		String cep = sc.nextLine();
		
		System.out.println("Qual a conta deseja criar?(CC - Conta Corrente/ CP - Conta Poupanca)");
		String tipoConta = sc.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cpf, idade, sexo);
		cliente.adicionarEndereco(new Endereco(rua, numero, bairro, cep, cidade));
		cliente.adicionarTelefone(new Telefone(telefone));
		
		Conta conta = null;
		
		if (tipoConta.equals("CC")) {
			conta = new ContaCorrente(gerarNumeroContaCorrente(agencia), cliente, agencia);
			agencia.adicionarConta(conta);
		}else{
			conta = new ContaPoupanca(gerarNumeroContaPoupanca(agencia), cliente, agencia);
			agencia.adicionarConta(conta);
		}
		
		System.out.println("Conta criada com sucesso. Dados da conta");
		System.out.println(conta);
				
	}
	
	public static boolean verificaRegraDeNegiocio(Agencia agencia, String cpf) {
		for (Conta conta : agencia.getContas()) {
			if (conta.getCliente().getCpf().equals(cpf)) {
				System.out.println("ERRO: JÁ EXISTE UMA CONTA COM CPF = " + cpf);
				return true;
			}
		}
		return false;
	}
	
	public static int gerarNumeroContaCorrente(Agencia agencia) {
		int cc = 0;
		for (Conta conta : agencia.getContas()) {
			if (conta.getClass().getSimpleName().equals("ContaCorrente")) {
				cc += 1;
			}
		}
		return cc + 1; 
	}
	
	public static int gerarNumeroContaPoupanca(Agencia agencia) {
		int cp = 0;
		for (Conta conta : agencia.getContas()) {
			if (conta.getClass().getSimpleName().equals("ContaPoupanca")) {
				cp += 1;
			}
		}
		return cp + 1; 
	}

	public static void sacar(Scanner sc, Agencia agencia) {
		System.out.println("--SACAR-- \n");
		
		int temp = 0;
		
		System.out.println("Informe o numero da conta: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Informe o valor a ser sacado: ");
		double valor = sc.nextDouble();
		sc.nextLine();
		
		for (Conta conta : agencia.getContas()) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);
				temp = 1;
			}
		}
		
		if (temp == 0) {
			System.out.println("ERRO: NÃO FOI POSSIVEL REALIZAR O SAQUE");
		}
	}
	
	public static void depositar(Scanner sc, Agencia agencia) {
		System.out.println("--DEPOSITAR-- \n");
		
		int temp = 0;
		
		System.out.println("Informe o numero da conta: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Informe o valor a ser depositado: ");
		double valor = sc.nextDouble();
		sc.nextLine();
		
		for (Conta conta : agencia.getContas()) {
			if (conta.getNumero() == numeroConta) {
				conta.depositar(valor);
				temp = 1;
			}
		}
		
		if (temp == 0) {
			System.out.println("ERRO: NÃO FOI POSSIVEL REALIZAR O DEPOSITO");
		}
	}
	
	public static void transferir(Scanner sc, Agencia agencia) {
		System.out.println("--DEPOSITAR-- \n");
		
		int temp = 0;
		
		System.out.println("Informe o numero da conta: ");
		int numeroConta1 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Informe o numero da conta que deseja transferir: ");
		int numeroConta2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Informe o valor a ser transferido: ");
		double valor = sc.nextDouble();
		sc.nextLine();
		
		for (Conta conta : agencia.getContas()) {
			if (conta.getNumero() == numeroConta1) {
				for (Conta contaT : agencia.getContas()) {
					if (conta.getNumero() == numeroConta2) {
						conta.transferir(contaT, valor);
						temp = 1;
					}
				}
			}
		}
		
		if (temp == 0) {
			System.out.println("ERRO: NÃO FOI POSSIVEL REALIZAR A TRANSFERENCIA");
		}
	}

	public static void verSaldo(Scanner sc, Agencia agencia) {
		System.out.println("--VER SALDO-- \n");
		
		int temp = 0;
		
		System.out.println("Informe o numero da conta: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		
		for (Conta conta : agencia.getContas()) {
			if (conta.getNumero() == numeroConta) {
				conta.mostrarSaldo();
				temp = 1;
			}
		}
		if (temp == 0) {
			System.out.println("ERRO: NÃO FOI POSSIVEL VISUALIZAR O SALDO");
		}
	}

}