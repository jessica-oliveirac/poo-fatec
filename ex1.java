/*
1. Ler 3 números reais da entrada padrão: a, b, c.
2.Calcular as raízes reais da equação de 2º grau
3. Imprimir os resultados ou uma mensagem dizendo que não há raízes (delta<0)
4. Alterar o rograma para ler a1, b1, c1, a2, b2, c2,a3, b3, c4 e calcular as raízes de 3 equações
e imprimir todos os resultados no final.
*/
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        double delta;
        System.out.print("A: ");
        double a = scan.nextDouble();
        System.out.print("B: ");
        double b = scan.nextDouble();
        System.out.print("C: ");
        double c = scan.nextDouble();

        delta = (b*b) - 4*a*c; 
        
        delta = Math.sqrt(delta);
        double x1 = (-b + delta)/(2*a);
        double x2 = (-b - delta)/(2*a);

        
        if(delta>0){
            System.out.println("Delta: "+  delta);
            System.out.println("X1: "+  x1);
            System.out.println("X2: "+  x2);
        }else{
            System.out.println("Não há raízes!");
        }
	}
}

---------------------------------------------------------------------------------------------
package novoJava.Proj;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        double delta;
        int cont = 0;
        while(cont>=3){
            System.out.print("A: ");
            double a = scan.nextDouble();
            System.out.print("B: ");
            double b = scan.nextDouble();
            System.out.print("C: ");
            double c = scan.nextDouble();

            delta = (b*b) - 4*a*c; 
        
            delta = Math.sqrt(delta);
            double x1 = (-b + delta)/(2*a);
            double x2 = (-b - delta)/(2*a);

        
            if(delta>0){
                System.out.println("Delta: "+  delta);
                System.out.println("X1: "+  x1);
                System.out.println("X2: "+  x2);
            }else{
                System.out.println("Não há raízes!");
            }
            cont++;
        }
        scan.close();
	}

}
-----------------------------------
package novoJava.Proj;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        double delta;
        int cont = 0;
        for(cont=0;cont<=3;cont++){
            System.out.print("A: ");
            double a = scan.nextDouble();
            System.out.print("B: ");
            double b = scan.nextDouble();
            System.out.print("C: ");
            double c = scan.nextDouble();

            delta = (b*b) - 4*a*c; 
        
            delta = Math.sqrt(delta);
            double x1 = (-b + delta)/(2*a);
            double x2 = (-b - delta)/(2*a);

        
            if(delta>0){
                System.out.println("Delta: "+  delta);
                System.out.println("X1: "+  x1);
                System.out.println("X2: "+  x2);
            }else{
                System.out.println("Não há raízes!");
            }
        }
        scan.close();
	}

}
