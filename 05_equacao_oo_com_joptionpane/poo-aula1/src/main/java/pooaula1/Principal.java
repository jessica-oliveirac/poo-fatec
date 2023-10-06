package pooaula1;

import javax.swing.JOptionPane;

public class Principal {

	static void lerCoeficientes(Equacao eq) {
	    eq.a = Double.valueOf(JOptionPane.showInputDialog("Informe o valor do coeficiente a"));
	    eq.b = Double.valueOf(JOptionPane.showInputDialog("Informe o valor do coeficiente b"));
	    eq.c = Double.valueOf(JOptionPane.showInputDialog("Informe o valor do coeficiente c"));
	}

	static void imprimirResultado(Equacao eq) {
	    if(eq.delta < 0) {
	    	JOptionPane.showMessageDialog(null, "A equação não tem raízes reais");
	    } else if (eq.delta == 0) {
	    	JOptionPane.showMessageDialog(null, String.format("A raiz única é %.2f\n", eq.x1));
	    } else {
	    	JOptionPane.showMessageDialog(null, String.format("As raízes são %.2f e %.2f\n", eq.x1, eq.x2));
	    }
	}

	public static void main(String[] args)
	{
	    Equacao eq1, eq2, eq3;
	    eq1 = new Equacao();
	    eq2 = new Equacao();
	    eq3 = new Equacao();
	    
	    lerCoeficientes(eq1);
	    lerCoeficientes(eq2);
	    lerCoeficientes(eq3);
	    
	    eq1.calcularRaizes();
	    eq2.calcularRaizes();
	    eq3.calcularRaizes();
	    
	    imprimirResultado(eq1);
	    imprimirResultado(eq2);
	    imprimirResultado(eq3);
	}
	
}
