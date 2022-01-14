package bancodigital.domain.interfaces;

import bancodigital.domain.Conta;

public interface ContaOperacoes {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino);
	
	void imprimirExtrato();

}
