package bancodigital.domain;

public class Conta {
	
	private Integer numero;
	private Double saldo;
	
	private Cliente cliente;
	
	public Conta() {
		
	}

	public Conta(Integer numero, Double saldo, Cliente cliente) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	public void sacar(double valor) {
		saldo -= valor;
		
	}

	public void depositar(double valor) {
		saldo += valor;
		
	}

	public void transferir(double valor, Conta contaDestino) {
		contaDestino.depositar(valor);
		sacar(valor);
	}

	public String imprimirExtrato() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}
	
	

}
