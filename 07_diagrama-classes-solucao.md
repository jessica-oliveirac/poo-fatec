# Diagrama yUML

[Pessoa_inicial|~nome:String;~massa:double;~altura:double|+calcularIMC():double;+classificarIMC():String;+imprimirResultados():void]

[Pessoa|-nome:String;-massa:double;-altura:double|+calcularIMC():double;+classificarIMC():CategoriasIMC]
[«enum»CategoriasIMC|SOBPESO;NORMAL;SOBREPESO;OBESIDADE1;OBESIDADE2;OBESIDADE3]

