package bancodigital.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private String codigo;
	private List<Agencia> agencias = new ArrayList<>();

	public Banco() {
		
	}
	
	public Banco(String nome, String codigo, List<Agencia> agencias) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.agencias = agencias;
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

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void adicionarAgencia(Agencia agencia) {
		agencias.add(agencia);
	}

}
