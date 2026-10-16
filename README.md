# Projeto-Locadora

Integrantes:
João Gabriel Vitor Araujo (Função) - Ajudar na estrutura base do código, seja nas classes específicas e no menu, e responsável pelo GitHub, seja o repositório ou a escrita do README.

Gabriel dos Anjos Figueiredo (Função) - Colaborou no código em geral fazendo principalmente a classe aluguel, corrigindo alguns bugs na reta final do código, como por exemplo o usuário poder alugar produtos sem limite.

Maria Emanuele Ribeiro Cardoso (Função) - Colaborou no código de forma a fazer a classe estoque, ajudou nos métodos primários da maioria das classes, foi responsável por acrescentar outros métodos mais aprofundados, foi de grande ajuda na parte do menu na classe app  e foi grande responsável por acrescentar as tecnologias externas.

André Barbosa da Silva (Função) - Um dos colaboradores da base do trabalho como um todo, criando maior parte das classes e parte das funções principais, sendo o pioneiro do código e dando assistência e suporte para solidificar o código.

Descrição do Problema:
Criação de sistema para uma locadora de jogos, que vende jogos, consoles e acessórios, também mostrando o aluguel pago, o estoque dos produtos e as relações com clientes.

Funcionalidades:
- Cadastro
Função feita para cadastrar consoles, jogos e acessórios (nome, preço da diária, dias de devolução e quantidade em estoque)e também para 
Cadastrar clientes.

- Estoque
No estoque podemos editar o nome, preço, dias de devolução e quantidade de qualquer produto.
Listar todo o estoque com preço, quantidade e status (se tá disponível ou indisponível).
Retirada automática do estoque ao alugar um produto e reposição automática ao devolver.

- Aluguel e devolução
Alugar console, jogo ou acessório para um cliente cadastrado.
Devolver o item informando quantos dias o cliente ficou com ele, com cálculo automático de custo e multa.

- Relatórios e indicadores
Exibe o total arrecadado, média por aluguel, maior e menor aluguel,
ranking dos itens mais alugados, taxa de atraso e disponibilidade do estoque.

Principais Classes:
Há um total de 8 Classes contando com o App, sendo elas as classes Locadora, Jogo, Estoque, Console, Cliente, Aluguel e Acessório.

Regras de Negócio:
As regras do negócio consistem em:
1	Cliente cadastrado:	Só é possível alugar para um cliente que já foi cadastrado.

2	Produto indisponível: Não é possível alugar um produto sem unidades em estoque ou que não exista.

3	Limite por aluguel:	Cada cliente pode ficar com no máximo 3 consoles, 5 jogos e 5 acessórios ao mesmo tempo(podendo ser alterado dentro do código), mesmo que haja muitas unidades no estoque.

4	Limite total:	O limite geral de produtos por cliente é a soma dos três limites acima (13 itens).

5	Custo do aluguel:	custo = preço da diária × dias de devolução (prazo).

6	Multa por atraso:	multa = dias de atraso × preço da diária × 50%, a multa só é aplicada se o cliente ficar mais dias do que o prazo.

7	Status automático:	O status do produto muda sozinho conforme a quantidade dele no estoque, disponível é para quando houver unidades e indisponível se zerar o estoque.

8	Estoque automático:	Alugar diminui 1 unidade do estoque, Devolver devolve 1 unidade.

9	Sem nomes duplicados:	Não é possível cadastrar nem renomear um produto com nome já existente no mesmo tipo, nem dois clientes com o mesmo nome, a comparação ignora letras maiúsculas e minúsculas.

10 Produto alugado não pode ser renomeado:	Enquanto houver aluguel ativo de um produto, o nome dele não pode ser alterado.

11	Validação de entradas:	Preço e quantidade não aceitam valores negativos, dias de devolução precisam ser de pelo menos 1, textos não podem ficar vazios e o programa não quebra se for digitada uma letra no lugar de um número, Preços aceitam ponto ou vírgula (19.90 ou 19,90).


Tecnologias Utilizadas:
As tecnologias utilizadas foram Gson e SQLite.


Instruções para Execução:
Primeiro é necessário o cadastro do console, do jogo e do acessório, depois é necessário o cadastro do cliente, após isso podendo alugar um item no final, gerando um relatório para saber qual o cliente mais pagou em seu devido aluguel é possível também editar o estoque, devolver o item alugado e apresentar o estoque.

Exemplo de Utilização:
Ao iniciar, o programa vai mostrar o menu principal:

1-Cadastrar (Console, Jogo, Acessorio, Cliente)
2-Editar Estoque (Console, Jogo, Acessorio)
3-Alugar item
4-Devolver item
5-Apresentar Estoque
6-Relatórios e indicadores
0-Sair
Passo a passo

1. Cadastrar um console (1 → 1)
Nome do console: PS5
Preço do console: 20
Dias de devolução: 3
Quantidade em estoque: 2
Console cadastrado com sucesso!

2. Cadastrar um cliente (1 → 4)
Nome do cliente: Ana
Cliente cadastrado com sucesso!

3. Alugar o console (3)
Nome do cliente: Ana
Tipo: 1-Console | 2-Jogo | 3-Acessório
Tipo: 1
Nome do item: PS5
Aluguel realizado! Prazo: 3 dias | Custo: R$ 60,00

4. Devolver com atraso (4): o cliente ficou 5 dias em vez de 3 Logo:
Nome do cliente: Ana
Tipo: 1-Console | 2-Jogo | 3-Acessório
Tipo: 1
Nome do item: PS5
Quantos dias o cliente ficou com o item? 5
Devolução registrada.
Atraso! Multa: R$ 20,00
Valor total: R$ 80,00

(Cálculo da multa: custo de 3 dias × R$ 20 = R$ 60, mais multa de 2 dias de atraso × R$ 20 × 50% = R$ 20, totalizando R$ 80.0

5. Ver o relatório (6)
===== Relatório da Mingau do careca games =====

Total de alugueis: 1

Total arrecadado: R$ 80,00

Média por aluguel: R$ 80,00

Maior aluguel: PS5 (Ana) - R$ 80,00

Menor aluguel: PS5 (Ana) - R$ 80,00

Ranking de itens mais alugados:

1º - Console - PS5 (1 alugueis)

Taxa de atraso: 100,0%

Disponibilidade do estoque: 100,0%


Se Ana tentar alugar um quarto console, com o limite configurado em 3 aparece:

Limite de 3 console(s) por cliente atingido.


Utilização de IA:
A IA utilizada no código foi o Claude para ajudar na implementação principalmente da classe aluguel e dos métodos que limitam o cliente a comprar uma quantidade especifica de itens, o Claude também auxiliou no entendimento de como fazer esses métodos específicos como o de limite de itens.
