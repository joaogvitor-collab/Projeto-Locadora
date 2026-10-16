import java.util.Scanner;
//Comentario criado dia 15/10/26 as 14:33s para confirmar se é a versão mais recente do projeto
public class App {
    
     // Lê SEMPRE uma linha inteira (nextLine) e converte. Assim não sobra "Enter" no buffer
    // e não precisa mais limpar com sc.nextLine() solto.
    // Lê um texto que não pode ser vazio
    private static String lerTexto(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String t = sc.nextLine().trim();
            if (!t.isEmpty()) return t;
            System.out.println("O texto não pode ficar vazio.");
        }
    }

    // Lê um inteiro >= minimo (não quebra se digitar letra)
    private static int lerInt(Scanner sc, String msg, int minimo) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= minimo) return v;
                System.out.println("Digite um valor maior ou igual a " + minimo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    // Lê um decimal >= minimo; aceita "19.90" e "19,90"
    private static double lerDouble(Scanner sc, String msg, double minimo) {
        while (true) {
            System.out.print(msg);
            try {
                double v = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                if (v >= minimo) return v;
                System.out.println("Digite um valor maior ou igual a " + minimo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número (ex.: 19.90 ou 19,90).");
            }
        }
    }

    // Converte 1/2/3 no texto do tipo usado nos alugueis
    private static String tipoPorNumero(int tipo) {
        if (tipo == 1) return "Console";
        if (tipo == 2) return "Jogo";
        return "Acessório";
    }
    public static void main(String[] args) {

        BancoDados.inicializarBanco();

        Scanner sc = new Scanner(System.in);

        Locadora l1 = new Locadora("Mingau do careca games");

        int opcao;

        do {


            System.out.println("1-Cadastrar (Console, Jogo, Acessorio, Cliente)");
            System.out.println("2-Editar Estoque (Console, Jogo, Acessorio)");
            System.out.println("3-Alugar item");
            System.out.println("4-Devolver item");
            System.out.println("5-Apresentar Estoque");
            System.out.println("6-Relatórios e indicadores");
            System.out.println("0-Sair");

            opcao = lerInt(sc, "Opção: ", 0);
            
            //sub menu de cadastro começa
            if (opcao == 1) {
                int opcaoCadastrar = -1;
                    do {
                    
                    System.out.println("\n--- MENU DE CADASTRO ---");
                    System.out.println("1- Cadastrar Console");
                    System.out.println("2- Cadastrar Jogo");
                    System.out.println("3- Cadastrar Acessório");
                    System.out.println("4- Cadastrar Cliente");
                    System.out.println("0- Voltar ao Menu Principal");
                    
                    opcaoCadastrar = lerInt(sc, "Opção: ", 0);

                    //Aqui cadastra console
                    if (opcaoCadastrar == 1) 
                        {
                        String nome = lerTexto(sc, "Nome do console: ");
                        double preco = lerDouble(sc, "Preço do console: ", 0);
                        int devolucoes = lerInt(sc, "Dias de devolução: ", 1);
                        int quantidade = lerInt(sc, "Quantidade em estoque: ", 0);

                        Console c1 = new Console(nome, preco, devolucoes, quantidade);
                        if (l1.cadastrarConsole(c1)) {
                            System.out.println("Console cadastrado com sucesso!");
                        } else {
                            System.out.println("Já existe um console com esse nome. Cadastro cancelado.");
                        }
                        }

                        //Aqui cadastra jogo
                    else if (opcaoCadastrar == 2) 
                        {
                        String nome = lerTexto(sc, "Nome do jogo: ");
                        String nomeConsole = lerTexto(sc, "Nome do console do jogo: ");
                        double preco = lerDouble(sc, "Preço do jogo: ", 0);
                        int devolucoes = lerInt(sc, "Dias de devolução: ", 1);
                        int quantidade = lerInt(sc, "Quantidade em estoque: ", 0);

                        Jogo j1 = new Jogo(nome, nomeConsole, preco, devolucoes, quantidade);
                        if (l1.cadastrarJogo(j1)) {
                            System.out.println("Jogo cadastrado com sucesso!");
                        } else {
                            System.out.println("Já existe um jogo com esse nome. Cadastro cancelado.");
                        }
                        }

                        //Aqui cadastra acessorio
                     else if (opcaoCadastrar == 3) 
                        {
                        String nome = lerTexto(sc, "Nome do acessório: ");
                        String nomeConsole = lerTexto(sc, "Nome do console do acessório: ");
                        double preco = lerDouble(sc, "Preço do acessório: ", 0);
                        int devolucoes = lerInt(sc, "Dias de devolução: ", 1);
                        int quantidade = lerInt(sc, "Quantidade em estoque: ", 0);

                        Acessorio a1 = new Acessorio(nome, nomeConsole, preco, devolucoes, quantidade);
                        if (l1.cadastrarAcessorio(a1)) {
                            System.out.println("Acessório cadastrado com sucesso!");
                        } else {
                            System.out.println("Já existe um acessório com esse nome. Cadastro cancelado.");
                        }
                    }
                    else if (opcaoCadastrar == 4) 
                    {
                        String nome = lerTexto(sc, "Nome do cliente: ");
                        Cliente cle1 = new Cliente(nome);
                        if (l1.cadastrarCliente(cle1)) {
                            System.out.println("Cliente cadastrado com sucesso!");
                        } else {
                            System.out.println("Já existe um cliente com esse nome. Cadastro cancelado.");
                        }
                    }
            
                } while (opcaoCadastrar != 0); // sub menu de cadastro encerra quando a opção e 0
            }

            else if (opcao == 2) {
                int opcaoEditar = -1;
                do {//sub menu de edição começa
                    System.out.println("\n--- MENU DE EDIÇÃO DE ESTOQUE ---");
                    System.out.println("1- Editar Console");
                    System.out.println("2- Editar Jogo");
                    System.out.println("3- Editar Acessório");
                    System.out.println("0- Voltar ao Menu Principal");

                    opcaoEditar = lerInt(sc, "Opção: ", 0);

                    if (opcaoEditar == 1) 
                    {
                        String nomeBuscado = lerTexto(sc, "Digite o nome do console que deseja editar: ");
                        String novoNome = lerTexto(sc, "Novo nome: ");
                        double novoPreco = lerDouble(sc, "Novo preço: ", 0);
                        int novaDevolucao = lerInt(sc, "Novos dias de devolução: ", 1);
                        int novaQuantidade = lerInt(sc, "Nova quantidade: ", 0);

                        if (l1.editarConsole(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade)) {
                            System.out.println("Console atualizado");
                        } else {
                            System.out.println("Console não foi atualizado");
                        }
                    }
                    else if (opcaoEditar == 2) {
                        System.out.print("Digite o nome do jogo que deseja editar: ");
                        sc.nextLine();
                        String nomeBuscado = sc.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();

                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();

                        System.out.print("Novos dias de devolução: ");
                        int novaDevolucao = sc.nextInt();

                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = sc.nextInt();
                        sc.nextLine();

                       //mesma coisa do de cima, mas para jogo
                        boolean sucesso = l1.editarJogo(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade);
                        
                        if (sucesso) {
                        System.out.println("Jogo atualizado");
                        } 
                        else {
                        System.out.println("Jogo não encontrado para editar");
                        }
                    } 
                    else if (opcaoEditar == 3) {
                        System.out.print("Digite o nome do acessório que deseja editar: ");
                        sc.nextLine();
                        String nomeBuscado = sc.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();

                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();

                        System.out.print("Novos dias de devolução: ");
                        int novaDevolucao = sc.nextInt();

                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = sc.nextInt();
                        sc.nextLine(); 

                       //mesma coisa do de cima, mas para acessorio
                        boolean sucesso = l1.editarAcessorio(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade);
                        
                        if (sucesso) {
                        System.out.println("Acessório atualizado");
                        } 
                        else {
                        System.out.println("Acessório não encontrado para editar");
                        }
                    }

                } while (opcaoEditar != 0); //Sub menu de edição encerra
                
            }else if (opcao == 3) {
                String nomeCliente = lerTexto(sc, "Nome do cliente: ");

                System.out.println("Tipo: 1-Console | 2-Jogo | 3-Acessório");
                int tipo = lerInt(sc, "Tipo: ", 1);

                String nomeItem = lerTexto(sc, "Nome do item: ");

                if (tipo == 1) {
                l1.alugarConsole(nomeCliente, nomeItem);
                } else if (tipo == 2) {
                     l1.alugarJogo(nomeCliente, nomeItem);
                } else if (tipo == 3) {
                    l1.alugarAcessorio(nomeCliente, nomeItem);
                } else {
                System.out.println("Tipo inválido.");
                }
            
            } else if (opcao == 4) {
               String nomeCliente = lerTexto(sc, "Nome do cliente: ");

                System.out.println("Tipo: 1-Console | 2-Jogo | 3-Acessório");
                int tipo = lerInt(sc, "Tipo: ", 1);

                if (tipo > 3) {
                    System.out.println("Tipo inválido.");
                } else {
                    String nomeItem = lerTexto(sc, "Nome do item: ");
                    int diasUsados = lerInt(sc, "Quantos dias o cliente ficou com o item? ", 1);

                    l1.devolverItem(nomeCliente, tipoPorNumero(tipo), nomeItem, diasUsados);
                }
            
                }else if (opcao == 5) {
                    l1.listarProdutos();
                
                }else if (opcao == 6) {
                    l1.gerarRelatorioCompleto();
                
                }
                else if (opcao != 0) 
                {
                    System.out.println("Opção inválida.");
                }
            

        }while(opcao != 0);

      

        sc.close();
    }
}
