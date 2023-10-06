package poo.aula2;

import java.util.Objects;

public class Pessoa {
	
	// Nunca coloque IO (entrada e saída) de dados nestas classes
	// de domínio.

	private String nome;
	private double massaKg;
	private double alturaM;
	
	// Se um objeto da sua classe tiver dados obrigatórios, sempre
	// crie construtores (métodos executados no momento da criação
	// de objetos) que recebem os dados obrigatórios.
	public Pessoa(String nome, double massaKg, double alturaM) {
		// Invoque os métodos set no construtor para alterar
		// os dados, pois você pode colocar a validação dentro deles
		// e ela será executada daqui também.
		setNome(nome);
		setMassaKg(massaKg);
		setAlturaM(alturaM);
	}
	
	double calcularIMC() {
		return massaKg / Math.pow(alturaM, 2);
	}
	
	// Prefira retornar enumerações, ao invés de String ou número,
	// pois isso evita que o programador imprima a String retornada
	// diretamente no programa principal (o que é ruim) ou que ele
	// tenha que entender o significado de números (1 para categoria X,
	// (2 para categoria y etc.). Por fim, usando enumerações, o método
	// sempre retornará um resultado válido, pois uma enumeração só
	// aceita valores válidos (os valores que foram definidos nela).
	CategoriasIMC classificarIMC() {
		double imc = calcularIMC();
		if(imc < 18.5) {
			return CategoriasIMC.SOBPESO;
		} else if(imc < 24.9) {
			return CategoriasIMC.NORMAL;
		} else if(imc < 29.9) {
			return CategoriasIMC.SOBREPESO;
		} else if(imc < 34.9) {
			return CategoriasIMC.OBESIDADE1;
		} else if(imc < 39.9) {
			return CategoriasIMC.OBESIDADE2;
		} else {
			return CategoriasIMC.OBESIDADE3;
		}
	}

	public String getNome() {
		return nome;
	}

	// Adicione validações nos métodos set para garantir
	// valores válidos nas classes.
	public void setNome(String nome) {
		Objects.requireNonNull(nome);
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		this.nome = nome.trim().toUpperCase();
	}

	public double getMassaKg() {
		return massaKg;
	}

	// Adicione validações nos métodos set para garantir
	// valores válidos nas classes.
	public void setMassaKg(double massaKg) {
		if(massaKg <= 0) {
			throw new IllegalArgumentException("A massa deve ser um real positivo");
		}
		this.massaKg = massaKg;
	}

	public double getAlturaM() {
		return alturaM;
	}

	// Adicione validações nos métodos set para garantir
	// valores válidos nas classes.
	public void setAlturaM(double alturaM) {
		if(alturaM <= 0) {
			throw new IllegalArgumentException("A altura deve ser um real positivo");
		}
		this.alturaM = alturaM;
	}
	
	
	
}
