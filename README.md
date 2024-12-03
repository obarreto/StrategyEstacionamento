Padrões e Stack Utilizada 
1. Padrões de Projeto (Design Patterns) 
No desenvolvimento do código para o sistema de Tarifa de Estacionamento, alguns padrões de projeto foram seguidos para garantir a escalabilidade, flexibilidade e manutenção do código. Abaixo estão os padrões utilizados: 
1.1. Strategy Pattern (Padrão de Estratégia) 
Motivo da Escolha: O padrão Strategy é utilizado para definir uma família de algoritmos (estratégias) e permitir que um objeto altere seu comportamento em tempo de execução. No nosso caso, a classe TarifaEstacionamento depende do tipo de cálculo de tarifa (por hora, diária, ou com valor inicial), e a estratégia de cálculo é definida através da interface Calculo. 
    • Como foi implementado: 
    • Calculo: Interface que define o método calcularTarifa(). 
    • CalculoHora, CalculoDiaria, e CalculoHoraValorInicial: Implementações concretas da interface Calculo, cada uma representando uma forma distinta de cálculo de tarifa. 
    • TarifaEstacionamento: Classe que utiliza uma instância da interface Calculo para calcular a tarifa de estacionamento. A estratégia pode ser trocada dinamicamente por meio do construtor da classe. 
Vantagens: 
    • Flexibilidade: Facilita a adição de novos tipos de cálculo de tarifa sem modificar o código existente. 
    • Desacoplamento: A classe TarifaEstacionamento não precisa saber como cada cálculo é realizado; ela apenas delega a responsabilidade para as implementações da interface Calculo. 
1.2. Factory Method (Método de Fábrica) 
Motivo da Escolha: O padrão Factory Method é utilizado quando você deseja criar objetos de uma classe, mas quer deixar que subclasses decidam qual classe instanciar. Esse padrão foi utilizado no caso de instanciar as diferentes estratégias de cálculo sem que a classe TarifaEstacionamento tenha que conhecer a classe exata a ser instanciada. 
    • Como foi implementado: 
    • O tipo de cálculo (ex: CalculoHora, CalculoDiaria) é passado como argumento para o construtor da classe TarifaEstacionamento. Isso permite que o comportamento da classe seja determinado pela escolha do cálculo sem acoplamento direto entre as classes. 
Vantagens: 
    • Facilidade de Extensão: Caso seja necessário adicionar novos tipos de cálculo, basta criar uma nova implementação da interface Calculo e passar como parâmetro ao criar a instância de TarifaEstacionamento. 
 
2. Stack Utilizada 
A stack utilizada para desenvolver esse código é baseada principalmente em Java, com o uso de bibliotecas e frameworks específicos para garantir a funcionalidade e os testes corretos. Abaixo estão os componentes principais dessa stack: 
2.1. Java 
Motivo da Escolha: Java é uma linguagem amplamente utilizada em sistemas corporativos devido à sua robustez, segurança e portabilidade. Neste projeto, utilizamos Java pela sua versatilidade, boa integração com frameworks e seu ecossistema rico para o desenvolvimento de aplicações de backend, como a nossa. 
    • Características: 
    • Orientação a Objetos: A linguagem permite organizar o código de forma modular e reutilizável, facilitando a implementação de padrões como o Strategy e o Factory Method. 
    • Portabilidade: O código Java é compilado para bytecode, o que permite sua execução em qualquer plataforma que tenha a JVM (Java Virtual Machine). 
    • Facilidade de Testes: Java possui boas bibliotecas e frameworks de testes, como o JUnit, que usamos neste projeto. 
2.2. JUnit 
Motivo da Escolha: JUnit é uma biblioteca para escrever e rodar testes unitários em Java. Ela fornece uma maneira simples e estruturada de garantir que o código esteja funcionando corretamente. 
    • Características: 
    • Estrutura de Testes: Permite escrever testes de forma limpa e organizada. 
    • Verificação de Resultados: Usamos o assertEquals do JUnit para verificar se os resultados esperados são iguais aos valores retornados pelos métodos testados. 
    • Automação de Testes: O JUnit facilita a execução automatizada dos testes, permitindo que o processo de validação seja contínuo e confiável. 
Vantagens: 
    • Facilidade para criar testes automatizados: JUnit é amplamente utilizado na indústria e possui uma rica documentação e recursos para a criação de testes unitários eficazes. 
    • Integração com ferramentas de CI/CD: O JUnit pode ser integrado com ferramentas de integração contínua como Jenkins, facilitando a execução dos testes em cada ciclo de desenvolvimento. 
2.3. Maven (para gerenciamento de dependências) 
Motivo da Escolha: Maven é uma ferramenta popular de gerenciamento de dependências e construção de projetos Java. Ela foi utilizada para gerenciar as dependências do projeto, como o JUnit, além de facilitar o processo de compilação e empacotamento do código. 
    • Vantagens: 
    • Gerenciamento Automático de Dependências: Maven facilita o download e a gestão das bibliotecas necessárias para o projeto. 
    • Facilidade de Build: A ferramenta permite empacotar o projeto em um arquivo executável (JAR) com um único comando. 
    • Configuração de Build Centralizada: Todas as dependências e configurações de build são armazenadas em um único arquivo (pom.xml). 
2.4. IDE: Eclipse/IntelliJ IDEA 
Motivo da Escolha: Para o desenvolvimento do código, utilizamos Eclipse ou IntelliJ IDEA, duas das IDEs mais populares para desenvolvimento em Java. Essas ferramentas oferecem suporte avançado para depuração, completamento automático de código, integração com sistemas de controle de versão (Git), entre outras funcionalidades. 
    • Vantagens: 
    • Depuração Eficiente: A IDE facilita o processo de depuração, permitindo que o desenvolvedor analise o fluxo do código e encontre rapidamente possíveis problemas. 
    • Recursos Avançados de Refatoração: As IDEs ajudam a manter o código organizado e a realizar mudanças de maneira segura e controlada. 
 
Conclusão 
A escolha dos padrões de projeto e stack tecnológica foi feita visando garantir a flexibilidade, escalabilidade e a facilidade de manutenção do código. O padrão Strategy foi essencial para permitir que o cálculo das tarifas fosse facilmente modificado ou estendido no futuro, sem a necessidade de alterações nas classes que utilizam essas tarifas. Já o uso do JUnit garantiu que a lógica do sistema fosse testada de forma consistente e automatizada. Por fim, o uso do Maven e da IDE IntelliJ/Eclipse contribuiu para uma experiência de desenvolvimento mais eficiente e organizada. 
Essa stack e os padrões escolhidos são ideais para esse tipo de sistema, proporcionando não só a qualidade do código, mas também a facilidade de futuras melhorias ou adaptações. 
 
 
Trabalho de Testes Unitários - Tarifa Estacionamento 
Objetivo: O objetivo deste trabalho é implementar testes unitários para validar o funcionamento correto de um código previamente desenvolvido. A seguir, apresento o código testado e os testes unitários realizados. 
 
1. Código Testado 
O código implementa um sistema de cálculo de tarifas de estacionamento, onde diferentes tipos de tarifas são aplicados com base na quantidade de horas estacionadas. As classes que compõem o código são: 
    • Calculo: Interface com um método para calcular a tarifa. 
    • CalculoHora: Classe que calcula a tarifa com base em um valor fixo por hora. 
    • CalculoHoraValorInicial: Classe que aplica uma tarifa base e, caso as horas ultrapassem um limite, aplica uma tarifa adicional por hora. 
    • CalculoDiaria: Classe que calcula a tarifa com base em um valor diário, considerando as horas como frações de um dia. 
    • TarifaEstacionamento: Classe principal que recebe a quantidade de horas e o tipo de cálculo a ser aplicado. 
 
2. Lógica dos Testes 
Para garantir que o sistema esteja funcionando corretamente, foram implementados testes para diferentes cenários. Os testes abordam as funcionalidades de cada tipo de tarifa, além de alguns casos extremos (edge cases). 
Testes Realizados: 
    1. tarifaFixaPorHora: 
    1. Testa a tarifa baseada em um valor fixo por hora. 
    2. Cenário: Estacionamento por 3 horas, tarifa de 4 por hora. 
    3. Resultado Esperado: 12. 
    2. tarifaComValorInicialDepoisFixaPorHora: 
    1. Testa a tarifa com um valor inicial e, após um limite de horas, a tarifa fixa por hora. 
    2. Cenário: Estacionamento por 5 horas, valor inicial de 5, tarifa adicional de 2 por hora para horas extras (após 3 horas). 
    3. Resultado Esperado: 9. 
    3. tarifaComValorInicialDentroDoLimite: 
    1. Testa a tarifa com um valor inicial e verifica se o valor inicial é mantido dentro do limite de horas. 
    2. Cenário: Estacionamento por 2 horas, valor inicial de 5, limite de 3 horas para tarifa adicional. 
    3. Resultado Esperado: 5. 
    4. tarifaDiaria: 
    1. Testa a tarifa diária quando o número de horas excede 24 horas. 
    2. Cenário: Estacionamento por 50 horas, tarifa diária de 20. 
    3. Resultado Esperado: 60 (2 dias). 
    5. tarifaDiariaMenorQueUmDia: 
    1. Testa a tarifa diária para um número de horas menor que 24. 
    2. Cenário: Estacionamento por 10 horas, tarifa diária de 20. 
    3. Resultado Esperado: 20. 
    6. Edge Case: Estacionamento por 0 horas: 
    1. Testa a tarifa para estacionamento por 0 horas. 
    2. Cenário: Estacionamento por 0 horas, tarifa de 3 por hora. 
    3. Resultado Esperado: 0. 
    7. Edge Case: Estacionamento com horas negativas: 
    1. Testa o caso de horas negativas, que deve gerar uma exceção. 
    2. Cenário: Estacionamento por -5 horas, tarifa de 3 por hora. 
    3. Resultado Esperado: Exceção IllegalArgumentException. 
 
4. Resultados dos Testes 
Após a execução dos testes, todos os cenários foram validados com sucesso. O sistema de cálculo de tarifas se comportou conforme o esperado para todos os casos testados: 
    • Para o caso de tarifa fixa por hora, o valor foi calculado corretamente. 
    • Para a combinação de tarifa com valor inicial e tarifa adicional, o sistema também funcionou conforme esperado. 
    • O teste de tarifa diária, tanto para mais de um dia quanto para menos de um dia, produziu os resultados corretos. 
    • Os casos extremos foram adequadamente tratados, incluindo o caso de estacionamento por 0 horas e a verificação para horas negativas. 
 
Conclusão 
Este trabalho consistiu na implementação de testes unitários para validar a lógica de um sistema de cálculo de tarifas de estacionamento. Todos os testes foram executados com sucesso e os resultados confirmaram a precisão das tarifas calculadas para diferentes cenários.  
Referências Bibliogŕaficas:
GUERRA, Eduardo. Design Patterns com Java. 1. ed. São Paulo: Casa do Código, 2018.
Código limpo : habilidades práticas do Agile Software / Robert C. Martin

Repositório do código:
https://github.com/obarreto/StrategyEstacionamento/tree/master/ 
 
