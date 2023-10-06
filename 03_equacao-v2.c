#include <stdio.h>
#include <math.h>

typedef struct {
    double a, b, c;
    double delta, x1, x2;
} Equacao;

double calcularDelta(Equacao eq) {
    return eq.b * eq.b - 4 * eq.a * eq.c;
}

double calcularX1(Equacao eq) {
    return (-eq.b - sqrt(calcularDelta(eq))) / (2 * eq.a);
}

double calcularX2(Equacao eq) {
    return (-eq.b + sqrt(calcularDelta(eq))) / (2 * eq.a);
}

void calcularRaizes(Equacao *eq) {
    eq->delta = calcularDelta(*eq);
    eq->x1 = calcularX1(*eq);
    eq->x2 = calcularX2(*eq);
}

void lerCoeficientes(Equacao *eq) {
    printf("===== Coeficientes da equação =====\n");
    printf("Informe o valor do coeficiente a: ");
    scanf("%lf", &eq->a);
    printf("Informe o valor do coeficiente b: ");
    scanf("%lf", &eq->b);
    printf("Informe o valor do coeficiente c: ");
    scanf("%lf", &eq->c);
}

void imprimirResultado(Equacao eq) {
    if(eq.delta < 0) {
        printf("A equação não tem raízes reais\n");
    } else if (eq.delta == 0) {
        printf("A raiz única é %.2f\n", eq.x1);
    } else {
        printf("As raízes são %.2f e %.2f\n", eq.x1, eq.x2);
    }
}

int main()
{
    Equacao eq1, eq2, eq3;
    
    lerCoeficientes(&eq1);
    lerCoeficientes(&eq2);
    lerCoeficientes(&eq3);
    
    calcularRaizes(&eq1);
    calcularRaizes(&eq2);
    calcularRaizes(&eq3);
    
    imprimirResultado(eq1);
    imprimirResultado(eq2);
    imprimirResultado(eq3);

    return 0;
}
