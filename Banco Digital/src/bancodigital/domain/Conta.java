package bancodigital.domain;

import bancodigital.domain.interfaces.ContaOperacoes;

public abstract class Conta implements ContaOperacoes{
	
	private Integer numero;
	private Double saldo = 0.0;
	
	private Cliente cliente;
	
	private Agencia agencia;
	
	public Conta() {
		
	}

	public Conta(Integer numero, Cliente cliente, Agencia agencia) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.agencia = agencia;
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
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public void sacar(Double valor) {
		if (valor > saldo) {
			System.out.println("ERRO: O VALOR A SER SACADO É MENOR QUE O SEU SALDO");
		}else {
			saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}
	}

	@Override
	public void depositar(Double valor) {
		saldo += valor;
		System.out.println("Deposito realizado com sucesso");
	}

	@Override
	public void transferir(Conta conta, Double valor) {
		sacar(valor);
		conta.depositar(valor);
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

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + ", agencia=" + agencia + "]";
	}
	
	
	

}
