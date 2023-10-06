# Ambiente de desenvolvimento

## IDEs

- IntelliJ IDEA: melhor opção (minha opinião);
  - IntelliJ student pack: 
    - https://www.jetbrains.com/shop/eform/students
    - https://www.jetbrains.com/student/
    Preencha o formulário com o e-mail da Fatec e faça o download/instalação do IntelliJ.
    Depois de acessar sua conta de estudante -> Baixar IntelliJ IDEA Ultimate
    Executar e seguir os passos da instalação.
    Marque todas as opções (caixas de verificação)
    Após instalação, você terá que informar usuário/senha.
    (Log in to jetbeains account)
    New Project -> vai aparecer que não tem SDK (em vermelho)
      Selecione Add SDK -> Download SDK > Selecione a versão 17 do Java
- Eclipse: https://eclipse.org/
- Netbeans: https://netbeans.org/ (não recomendo!)
- VSCode/Atoms/Sublime: são interessantes, leves, mas mais difíceis de configurar.

## Criando projeto no Eclipse

1. New > Maven project
2. Marque a opção 'Create a simple project (skip archetype selection)
3. Next
4. Informe um groupId: br.com.fatecmogidascruzes
5. Informe um artifaceId: poo-aula1
6. Finish

Estrutura do projeto:
poo-aula1 (nome do projeto)
  - (POR ENQUANTO SÓ ESSE AQUI SERÁ USADO) src/main/java (aqui vai o seu código-fonte)
  - src/main/resources (aqui vão outros arquivos: imagens, sons etc.)
  - src/test/java (código que testa o seu código-fonte - USAREMOS NO FUTURO)
  - src/test/resources (arquivos de teste)
  - JRE System Library (só é a referência à biblioteca do Java usada)
  - src (repetição das pastas acima)
  - target (onde o Java irá gerar o seu código compilado)
  - pom.xml (aqui você coloca as referências para outras bibliotecas que você usa - USAREMOS NO FUTURO)

Criando uma classe:
1. Clique com o botão direito em src/main/java
2. New > Class
3. Preencher o package: pooaula1
4. Preencher o name: 
5. Finish