package bancodigital.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String email;
	private String cpf;
	private Integer idade;
	private Character sexo;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(String nome, String email, String cpf, Integer idade, Character sexo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void adicionarEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}
	
	public void adicionarTelefone(Telefone telefone) {
		telefones.add(telefone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", idade=" + idade + ", sexo=" + sexo
				+ ", telefones=" + telefones + ", enderecos=" + enderecos + "]";
	}
	
	
	
	

}
