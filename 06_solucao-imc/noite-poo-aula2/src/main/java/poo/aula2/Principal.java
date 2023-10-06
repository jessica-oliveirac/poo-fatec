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
		JOptionPane.showMessageDialog(null, String.format("%s, seu IMC é %.2f.\n", p.getNome(), imc));
		JOptionPane.showMessageDialog(null, String.format("Você está na categoria %s.\n", mensagemCategoria));
		
		// Pode quebrar o envio de e-mail se o IMC for guardado como
		// atributo de Pessoa e não for recalculado após alterar a massa.
		// p.massaKg = 100;
		
		enviarEmail(p);
	}

	private static String getTextoCategoria(CategoriasIMC categoria) {
		String mensagemCategoria;
		if(categoria == CategoriasIMC.SOBPESO) {
			mensagemCategoria = "Está magrinho(a)!";
		} else if(categoria == CategoriasIMC.NORMAL) {
			mensagemCategoria = "Está bem, mas não engorde!";
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
		
		String mensagem = "%s, você calculou o IMC e obtivemos o valor %.2f.\n";
		mensagem += "Sua categoria é %s.";
		JOptionPane.showMessageDialog(null, String.format(mensagem, p.getNome(), p.calcularIMC(), getTextoCategoria(categoria)));
	}
	
}
