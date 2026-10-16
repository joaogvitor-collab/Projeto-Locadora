import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Locadora {

    private String nomeLocadora;
    private Estoque estoque;
    private static final int LIMITE_CONSOLES = 3;
    private static final int LIMITE_JOGOS = 5;
    private static final int LIMITE_ACESSORIOS = 5;
    private static final int limiteItens = LIMITE_CONSOLES + LIMITE_JOGOS + LIMITE_ACESSORIOS;
    private ArrayList<Aluguel> alugueis = new ArrayList<>();
    private ArrayList<Cliente>clientesLocadora = new ArrayList<>();

    public Locadora(String nomeLocadora) {
        this.nomeLocadora = nomeLocadora;
        this.estoque = new Estoque();
    
    }
    

    public String getNomeLocadora() {
        return nomeLocadora;
    }


    public void setNomeLocadora(String nomeLocadora) {
        this.nomeLocadora = nomeLocadora;
    }



    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    //Cadastrar os clientes
    public boolean cadastrarCliente(Cliente cli){
    if (buscarCliente(cli.getNomeCliente()) != null) {
        return false; 
    }
    clientesLocadora.add(cli);
    return true;
}
    public boolean cadastrarConsole(Console co)
    {
    return estoque.adicionarConsoleEstoque(co);
    }

    public boolean cadastrarJogo(Jogo j)
    {
    return estoque.adicionarJogoEstoque(j);
    }

    public boolean cadastrarAcessorio(Acessorio a)
    {
    return estoque.adicionarAcessorioEstoque(a);
    }


    //chama o metodo de editar console do estoque
    public boolean editarConsole(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) {
        if (renomeandoItemAlugado("Console", nomeBuscado, novoNome))
            {
                return false;
            }
        return estoque.editarConsole(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade);
    }

    //mesma coisa do de cima, mas para jogo
    public boolean editarJogo(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) 
    {
        if (renomeandoItemAlugado("Jogo", nomeBuscado, novoNome))
            {
                return false;
            } 
        return estoque.editarJogos(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade);
    }

    //mesma coisa do de cima, mas para acessorio
    public boolean editarAcessorio(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) 
    {
        if (renomeandoItemAlugado("Acessório", nomeBuscado, novoNome))
            {
                return false;
            }
        return estoque.editarAcessorios(nomeBuscado, novoNome, novoPreco, novaDevolucao, novaQuantidade);
    }   


    // Se o item está alugado, trocar o nome quebraria a devolução (o aluguel guarda o nome antigo)
    private boolean renomeandoItemAlugado(String tipo, String nomeAtual, String novoNome) {
        if (nomeAtual.equalsIgnoreCase(novoNome))
            {
                return false;
            }
        for (Aluguel a : alugueis) 
            {
            if (a.isAtivo() && a.getTipo().equals(tipo) && a.getNomeItem().equalsIgnoreCase(nomeAtual)) {
            System.out.println("Não é possível renomear: existe aluguel ativo desse item. Aguarde a devolução.");
            return true;
            }

            }

            return false;
        }

    public void listarProdutos() {
    System.out.println("==================");
    System.out.println("Consoles: ");
    for (Console con : estoque.getConsolesEstoque()) {
        System.out.println("Nome: "+con.getNomeConsole());
        System.out.println("Preço: R$"+ con.getPrecoConsole());
        System.out.println("Quantidade: " + con.getQuantidadeConsole());
        System.out.println("Status: " + con.StatusConsole());
        System.out.println("============");
    }

    System.out.println("==================");
    System.out.println("Jogos: ");
    for (Jogo jog : estoque.getJogosEstoque()) {
        System.out.println("Nome: "+jog.getNomeJogo());
        System.out.println("Preço: R$"+jog.getPrecoJogo());
        System.out.println("Quantidade: " + jog.getQuantidadeJogo());
        System.out.println("Status: " + jog.StatusJogo());
        System.out.println("============");
    }

    System.out.println("==================");
    System.out.println("Acessórios: ");
    for (Acessorio ace : estoque.getAcessoriosEstoque()) {
        System.out.println("Nome: " + ace.getNomeAcessorio());
        System.out.println("Preço: R$" + ace.getPrecoAcessorio());
        System.out.println("Quantidade: " + ace.getQuantidadeAcessorio());
        System.out.println("Status: " + ace.StatusAcessorio());
        System.out.println("============");
    }
}

    
private Cliente buscarCliente(String nome) {
    for (Cliente c : clientesLocadora) {
        if (c.getNomeCliente().equalsIgnoreCase(nome)) return c;
    }
    return null;
}

//Aqui é parecido com o metodo de limitar os produtos so que pra clientes, é pra saber se o cliente existe/ta cadastrado ou não e tambem pra definir um limite de itens que cada cliente pode levar
    private Cliente validarCliente(String nomeCliente, String tipo) {
        Cliente cli = buscarCliente(nomeCliente);
        if (cli == null) {
            System.out.println("Cliente não cadastrado.");
            return null;
        }
        if (cli.TotalItensEmprestados() >= limiteItens) {
            System.out.println("Limite de " + limiteItens + " itens por cliente atingido.");
            return null;
        }
        // Limite por tipo: ex. no máximo 3 consoles por cliente, mesmo que haja 100 no estoque
        if (quantidadeEmprestada(cli, tipo) >= limitePorTipo(tipo)) {
            System.out.println("Limite de " + limitePorTipo(tipo) + " " + tipo.toLowerCase() + "(s) por cliente atingido.");
            return null;
        }
        return cli;
    }

    // Devolve o limite configurado para o tipo ("Console", "Jogo" ou "Acessório")
    private int limitePorTipo(String tipo) {
        if (tipo.equals("Console")) return LIMITE_CONSOLES;
        if (tipo.equals("Jogo")) return LIMITE_JOGOS;
        return LIMITE_ACESSORIOS;
    }

    // Quantas unidades desse tipo o cliente está com agora
    private int quantidadeEmprestada(Cliente cli, String tipo) {
        if (tipo.equals("Console")) return cli.getConsolesEmprestados().size();
        if (tipo.equals("Jogo")) return cli.getJogosEmprestados().size();
        return cli.getAcessoriosEmprestados().size();
    }

private void registrarAluguel(Cliente cli, String tipo, String nome, double preco, int prazo) {
    Aluguel a = new Aluguel(cli, tipo, nome, preco, prazo);
    alugueis.add(a);
    System.out.println("Aluguel realizado! Prazo: " + prazo + " dias | Custo: R$ " + String.format("%.2f", a.Custo()));
}

public boolean alugarConsole(String nomeCliente, String nomeConsole) {
    Cliente cli = validarCliente(nomeCliente, "Console");
    if (cli == null) return false;

    // impede o aluguel de item indisponível
    if (!estoque.verificarDisponibilidadeConsole(nomeConsole)) {
        System.out.println("Console indisponível ou não encontrado.");
        return false;
    }
    Console c = estoque.pesquisarConsolePorNome(nomeConsole);
    c.setQuantidadeConsole(c.getQuantidadeConsole() - 1); // REGRA: baixa automática (muda o status)
    cli.getConsolesEmprestados().add(c);
    registrarAluguel(cli, "Console", c.getNomeConsole(), c.getPrecoConsole(), c.getDevolucaoConsole());
    return true;
}

public boolean alugarJogo(String nomeCliente, String nomeJogo) {
    Cliente cli = validarCliente(nomeCliente, "Jogo");
    if (cli == null) return false;

    if (!estoque.verificarDisponibilidadeJogo(nomeJogo)) {
        System.out.println("Jogo indisponível ou não encontrado.");
        return false;
    }
    Jogo j = estoque.pesquisarJogoPorNome(nomeJogo);
    j.setQuantidadeJogo(j.getQuantidadeJogo() - 1);
    cli.getJogosEmprestados().add(j);
    registrarAluguel(cli, "Jogo", j.getNomeJogo(), j.getPrecoJogo(), j.getDevolucaoJogo());
    return true;
}

public boolean alugarAcessorio(String nomeCliente, String nomeAcessorio) {
    Cliente cli = validarCliente(nomeCliente, "Acessório");
    if (cli == null) return false;

    if (!estoque.verificarDisponibilidadeAcessorio(nomeAcessorio)) {
        System.out.println("Acessório indisponível ou não encontrado.");
        return false;
    }
    Acessorio a = estoque.pesquisarAcessorioPorNome(nomeAcessorio);
    a.setQuantidadeAcessorio(a.getQuantidadeAcessorio() - 1);
    cli.getAcessoriosEmprestados().add(a);
    registrarAluguel(cli, "Acessório", a.getNomeAcessorio(), a.getPrecoAcessorio(), a.getDevolucaoAcessorio());
    return true;
}

// Aqui aplica multa, repõe o estoque e tira o item do cliente
public boolean devolverItem(String nomeCliente, String tipo, String nomeItem, int diasUsados) {
    for (Aluguel a : alugueis) {
        if (a.isAtivo()
        && a.getTipo().equals(tipo)
        && a.getCliente().getNomeCliente().equalsIgnoreCase(nomeCliente)
        && a.getNomeItem().equalsIgnoreCase(nomeItem)) {
            a.finalizar(diasUsados); // REGRA: aplicar multa
            Cliente cli = a.getCliente();

            if (a.getTipo().equals("Console")) {
                Console c = estoque.pesquisarConsolePorNome(nomeItem);
                if (c != null) {
                    c.setQuantidadeConsole(c.getQuantidadeConsole() + 1);
                    cli.getConsolesEmprestados().remove(c);
                }
            } else if (a.getTipo().equals("Jogo")) {
                Jogo j = estoque.pesquisarJogoPorNome(nomeItem);
                if (j != null) {
                    j.setQuantidadeJogo(j.getQuantidadeJogo() + 1);
                    cli.getJogosEmprestados().remove(j);
                }
            } else {
                Acessorio ac = estoque.pesquisarAcessorioPorNome(nomeItem);
                if (ac != null) {
                    ac.setQuantidadeAcessorio(ac.getQuantidadeAcessorio() + 1);
                    cli.getAcessoriosEmprestados().remove(ac);
                }
            }

            System.out.println("Devolução registrada.");
            if (a.teveAtraso()) {
                System.out.println("Atraso! Multa: R$ " + String.format("%.2f", a.getMulta()));
            }
            System.out.println("Valor total: R$ " + String.format("%.2f", a.getValorTotal()));
            return true;
        }
    }
    System.out.println("Nenhum aluguel ativo encontrado para esse cliente e item.");
    return false;
}
    
//calcula o total/faturamento 
public double calcularTotalArrecadado() {
    double total = 0;
    for (Aluguel a : alugueis) total += a.getValorTotal();
    return total;
}

//Calcula a media 
public double calcularMediaPorAluguel() {
    if (alugueis.isEmpty()) return 0;
    return calcularTotalArrecadado() / alugueis.size();
}

// Valor de aluguel maior e menor
public void mostrarMaiorMenorAluguel() {
    if (alugueis.isEmpty()) {
        System.out.println("Nenhum aluguel registrado.");
        return;
    }
    Aluguel maior = alugueis.get(0);
    Aluguel menor = alugueis.get(0);
    for (Aluguel a : alugueis) {
        if (a.getValorTotal() > maior.getValorTotal()) maior = a;
        if (a.getValorTotal() < menor.getValorTotal()) menor = a;
    }
    System.out.println("Maior aluguel: " + maior.getNomeItem() + " (" + maior.getCliente().getNomeCliente()
            + ") - R$ " + String.format("%.2f", maior.getValorTotal()));
    System.out.println("Menor aluguel: " + menor.getNomeItem() + " (" + menor.getCliente().getNomeCliente()
            + ") - R$ " + String.format("%.2f", menor.getValorTotal()));
}

//aqui é o ranking de itens mais alugados
public void mostrarRankingItens() {
    HashMap<String, Integer> contagem = new HashMap<>();
    for (Aluguel a : alugueis) {
        contagem.merge(a.getTipo() + " - " + a.getNomeItem(), 1, Integer::sum);
    }
    ArrayList<Map.Entry<String, Integer>> ranking = new ArrayList<>(contagem.entrySet());
    ranking.sort((x, y) -> y.getValue() - x.getValue());

    System.out.println("Ranking de itens mais alugados:");
    int pos = 1;
    for (Map.Entry<String, Integer> e : ranking) {
        System.out.println(pos + "º - " + e.getKey() + " (" + e.getValue() + " alugueis)");
        pos++;
    }
}

// taxa de atraso (% de alugueis devolvidos com multa)
public double calcularTaxaAtraso() {
    int devolvidos = 0;
    int atrasados = 0;
    for (Aluguel a : alugueis) {
        if (!a.isAtivo()) {
            devolvidos++;
            if (a.teveAtraso()) atrasados++;
        }
    }
    if (devolvidos == 0) return 0;
    return atrasados * 100.0 / devolvidos;
}

// Junta tudo num relatório só
public void gerarRelatorioCompleto() {
    System.out.println("\n===== Relatorio da " + nomeLocadora + " =====");
    System.out.println("Total de alugueis: " + alugueis.size());
    System.out.println("Total arrecadado: R$ " + String.format("%.2f", calcularTotalArrecadado()));
    System.out.println("Média por aluguel: R$ " + String.format("%.2f", calcularMediaPorAluguel()));
    mostrarMaiorMenorAluguel();
    mostrarRankingItens();
    System.out.println("Taxa de atraso: " + String.format("%.1f", calcularTaxaAtraso()) + "%");
    System.out.println("Disponibilidade do estoque: " + String.format("%.1f", estoque.calcularDisponibilidade()) + "%");
    System.out.println("==============================================");

    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataHoraFormatada = agora.format(formatador);

    String resumoRelatorio = "Relatório gerado em " + dataHoraFormatada + 
    ": Total arrecadado R$ " + String.format("%.2f", calcularTotalArrecadado());
    
    BancoDados.salvarTexto(resumoRelatorio);

    try {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("relatorio.json");
        gson.toJson(alugueis, writer); // Certifica-te que o nome da lista é alugueis
        writer.close();
        System.out.println("\nExportado com sucesso");
    } 
    catch (Exception e) {
        // Se der algum erro o programa não vai quebrar e dara uma mensagem de erro
        System.out.println("Erro ao exportar relatório: " + e.getMessage());
    }

}


}