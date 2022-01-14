package bancodigital;

import bancodigital.domain.Cidade;
import bancodigital.domain.Endereco;
import bancodigital.domain.Estado;

public class Main {

	public static void main(String[] args) {
		
		Estado matoGrosso = new Estado("MT", "Mato Grosso");
		
		Cidade cuiaba = new Cidade("Cuiabá", matoGrosso);
		
		Endereco endereco1 = new Endereco("20-A", "10", "Jardim Tropical", "78095665", cuiaba);
		
		
		
		

	}

}
