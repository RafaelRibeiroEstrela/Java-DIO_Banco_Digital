package bancodigital.domain;

public class ContaCorrente extends Conta{

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(Integer numero, Cliente cliente, Agencia agencia) {
		super(numero, cliente, agencia);
	}

	@Override
	public void mostrarSaldo() {
		System.out.println("Saldo da conta corrente numero " + getNumero() + " = " + getSaldo());
	}
	
	
}
