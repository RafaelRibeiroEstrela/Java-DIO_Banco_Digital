package bancodigital.domain.interfaces;

import bancodigital.domain.Conta;

public interface ContaOperacoes {
	
	void sacar(Double valor);
	
	void depositar(Double valor);
	
	void transferir(Conta conta, Double valor);
	
	void mostrarSaldo();

}
