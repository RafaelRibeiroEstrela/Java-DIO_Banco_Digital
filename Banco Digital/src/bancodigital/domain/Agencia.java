package bancodigital.domain;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private String nome;
	private String codigo;
	
	private Telefone telefone;
	
	private Endereco endereco;
	
	private Banco banco;
	
	private List<Conta> contas = new ArrayList<>();
	
	public Agencia() {
		
	}

	public Agencia(String nome, String codigo, Telefone telefone, Endereco endereco, Banco banco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.telefone = telefone;
		this.endereco = endereco;
		this.banco = banco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Conta> getContas(){
		return contas;
	}
	
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Agencia other = (Agencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agencia [nome=" + nome + ", codigo=" + codigo + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", banco=" + banco + "]";
	}

	
	
	
	
	

}
