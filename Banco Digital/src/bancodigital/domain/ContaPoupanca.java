package bancodigital.domain;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Integer numero, Cliente cliente, Agencia agencia) {
		super(numero, cliente, agencia);
	}
	
	@Override
	public void mostrarSaldo() {
		System.out.println("Saldo da poupanca numero " + getNumero() + " = " + getSaldo());
	}

}
