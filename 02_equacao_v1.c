#include <stdio.h>
#include <math.h>

int main1()
{
    double a, b, c, delta, raizDelta, x1, x2;
    
    printf("Informe o valor do coeficiente a:");
    scanf("%lf", &a);
    printf("Informe o valor do coeficiente b:");
    scanf("%lf", &b);
    printf("Informe o valor do coeficiente c:");
    scanf("%lf", &c);
    
    delta = b * b - 4 * a * c;
    raizDelta = sqrt(delta);
    
    if(delta < 0) {
        printf("A equação não tem raízes reais");
    } else if (delta == 0) {
        x1 = -b / (2 * a);
        printf("A raiz única é %.2f", x1);
    } else {
        x1 = -b - raizDelta / (2 * a);
        x2 = -b + raizDelta / (2 * a);
        printf("As raízes são %.2f e %.2f", x1, x2);
    }

    return 0;
}
