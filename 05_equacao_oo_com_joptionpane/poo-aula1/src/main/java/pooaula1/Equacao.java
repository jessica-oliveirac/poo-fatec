package pooaula1;

public class Equacao {
	double a, b, c;
    double delta, x1, x2;
    
    double calcularDelta() {
        return b * b - 4 * a * c;
    }

    double calcularX1() {
        return (b - Math.sqrt(calcularDelta())) / (2 * a);
    }

    double calcularX2() {
        return (b + Math.sqrt(calcularDelta())) / (2 * a);
    }

    void calcularRaizes() {
        delta = calcularDelta();
        x1 = calcularX1();
        x2 = calcularX2();
    }
}
