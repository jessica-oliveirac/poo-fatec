package poo.aula2;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		double massaKg = Double.valueOf(JOptionPane.showInputDialog("Informe a massa (Kg):"));
		double alturaM = Double.valueOf(JOptionPane.showInputDialog("Informe a altura (m):"));
		
		Pessoa p = new Pessoa(nome, massaKg, alturaM);
		
		double imc = p.calcularIMC();
		CategoriasIMC categoria = p.classificarIMC();
		String mensagemCategoria = getTextoCategoria(categoria);
		JOptionPane.showMessageDialog(null, String.format("%s, seu IMC � %.2f.\n", p.getNome(), imc));
		JOptionPane.showMessageDialog(null, String.format("Voc� est� na categoria %s.\n", mensagemCategoria));
		
		// Pode quebrar o envio de e-mail se o IMC for guardado como
		// atributo de Pessoa e n�o for recalculado ap�s alterar a massa.
		// p.massaKg = 100;
		
		enviarEmail(p);
	}

	private static String getTextoCategoria(CategoriasIMC categoria) {
		String mensagemCategoria;
		if(categoria == CategoriasIMC.SOBPESO) {
			mensagemCategoria = "Est� magrinho(a)!";
		} else if(categoria == CategoriasIMC.NORMAL) {
			mensagemCategoria = "Est� bem, mas n�o engorde!";
		} else if(categoria == CategoriasIMC.SOBREPESO) {
			mensagemCategoria = "Sobrepeso";
		} else if(categoria == CategoriasIMC.OBESIDADE1) {
			mensagemCategoria = "Obesidade grau 1";
		} else if(categoria == CategoriasIMC.OBESIDADE2) {
			mensagemCategoria = "Obesidade grau 2";
		} else {
			mensagemCategoria = "Obesidade grau 3";
		}
		return mensagemCategoria;
	}
	
	public static void enviarEmail(Pessoa p) {
		CategoriasIMC categoria = p.classificarIMC();
		
		String mensagem = "%s, voc� calculou o IMC e obtivemos o valor %.2f.\n";
		mensagem += "Sua categoria � %s.";
		JOptionPane.showMessageDialog(null, String.format(mensagem, p.getNome(), p.calcularIMC(), getTextoCategoria(categoria)));
	}
	
}
