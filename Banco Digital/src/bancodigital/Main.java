package bancodigital;

import java.util.Scanner;

import bancodigital.domain.Agencia;
import bancodigital.domain.Banco;
import bancodigital.domain.Cidade;
import bancodigital.domain.Endereco;
import bancodigital.domain.Estado;
import bancodigital.domain.Telefone;
import bancodigital.service.AgenciaOperacoes;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * @author Rafael Ribeiro Estrela
		 * @Date 14/01/2022
		 */
		
		Scanner sc = new Scanner(System.in);
		
		Estado estado = new Estado("MT", "Mato Grosso");
		
		Cidade cidade = new Cidade("Cuiabá", estado);
		
		Endereco endereco_agencia = new Endereco("20-A", "10", "Jardim Tropical", "78095665", cidade);
		
		Banco banco = new Banco("Banco Mato Grosso", "BR-MT-BA-001");
		
		Agencia agencia = new Agencia("Agencia Boa Vista", "AG-001", new Telefone("6530555555"), endereco_agencia, banco);
		
		banco.adicionarAgencia(agencia);
		
		int decisao = -1;
		
		while(decisao != 0) {
			
			System.out.println("MENU DO BANCO \n");
			System.out.println("1 - Criar uma conta");
			System.out.println("2 - Sacar");
			System.out.println("3 - Depositar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Ver saldo");
			System.out.println("0 - Sair");
			
			System.out.println("Comando: ");
			decisao = sc.nextInt();
			sc.nextLine();
			
			if (decisao == 1) {
				AgenciaOperacoes.criarConta(sc, cidade, agencia);
			}else if (decisao == 2) {
				AgenciaOperacoes.sacar(sc, agencia);
			}else if (decisao == 3) {
				AgenciaOperacoes.depositar(sc, agencia);
			}else if (decisao == 4) {
				AgenciaOperacoes.transferir(sc, agencia);
			}else if (decisao == 5) {
				AgenciaOperacoes.verSaldo(sc, agencia);
			}else if (decisao == 0) {
				break;
			}else{
				System.out.println("COMANDO INVALIDO \n");
			}
			
		}
		
		System.out.println("PROGRAMA FINALIZADO");

	}

}
