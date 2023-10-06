package poo.aula2;

import java.util.Objects;

public class Pessoa {
	
	// Nunca coloque IO (entrada e sa�da) de dados nestas classes
	// de dom�nio.

	private String nome;
	private double massaKg;
	private double alturaM;
	
	// Se um objeto da sua classe tiver dados obrigat�rios, sempre
	// crie construtores (m�todos executados no momento da cria��o
	// de objetos) que recebem os dados obrigat�rios.
	public Pessoa(String nome, double massaKg, double alturaM) {
		// Invoque os m�todos set no construtor para alterar
		// os dados, pois voc� pode colocar a valida��o dentro deles
		// e ela ser� executada daqui tamb�m.
		setNome(nome);
		setMassaKg(massaKg);
		setAlturaM(alturaM);
	}
	
	double calcularIMC() {
		return massaKg / Math.pow(alturaM, 2);
	}
	
	// Prefira retornar enumera��es, ao inv�s de String ou n�mero,
	// pois isso evita que o programador imprima a String retornada
	// diretamente no programa principal (o que � ruim) ou que ele
	// tenha que entender o significado de n�meros (1 para categoria X,
	// (2 para categoria y etc.). Por fim, usando enumera��es, o m�todo
	// sempre retornar� um resultado v�lido, pois uma enumera��o s�
	// aceita valores v�lidos (os valores que foram definidos nela).
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

	// Adicione valida��es nos m�todos set para garantir
	// valores v�lidos nas classes.
	public void setNome(String nome) {
		Objects.requireNonNull(nome);
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome n�o pode ser vazio");
		}
		this.nome = nome.trim().toUpperCase();
	}

	public double getMassaKg() {
		return massaKg;
	}

	// Adicione valida��es nos m�todos set para garantir
	// valores v�lidos nas classes.
	public void setMassaKg(double massaKg) {
		if(massaKg <= 0) {
			throw new IllegalArgumentException("A massa deve ser um real positivo");
		}
		this.massaKg = massaKg;
	}

	public double getAlturaM() {
		return alturaM;
	}

	// Adicione valida��es nos m�todos set para garantir
	// valores v�lidos nas classes.
	public void setAlturaM(double alturaM) {
		if(alturaM <= 0) {
			throw new IllegalArgumentException("A altura deve ser um real positivo");
		}
		this.alturaM = alturaM;
	}
	
	
	
}
