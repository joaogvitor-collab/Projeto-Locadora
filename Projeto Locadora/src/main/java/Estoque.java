import java.util.ArrayList;
import java.util.Comparator;

public class Estoque {

    private ArrayList<Console> consolesEstoque = new ArrayList<Console>();
    private ArrayList<Jogo> jogosEstoque = new ArrayList<Jogo>();
    private ArrayList<Acessorio> acessoriosEstoque = new ArrayList<Acessorio>();

    //Código pra adicionar/remover coisas do estoque
      public ArrayList<Console> getConsolesEstoque() {
        return consolesEstoque;
    }
    public ArrayList<Jogo> getJogosEstoque() {
        return jogosEstoque;
    }
    public ArrayList<Acessorio> getAcessoriosEstoque() {
        return acessoriosEstoque;
    }
    //Metodos como boolean para impedir cadastro de consoles com o mesmo nome
    public boolean adicionarConsoleEstoque(Console consoleEstoque){
        if (pesquisarConsolePorNome(consoleEstoque.getNomeConsole()) != null) {
            return false;
        }
        consolesEstoque.add(consoleEstoque);
        return true;
        }

    public boolean adicionarAcessorioEstoque(Acessorio acessorioEstoque){
        if (pesquisarAcessorioPorNome(acessorioEstoque.getNomeAcessorio()) != null) {
            return false;
        }
            acessoriosEstoque.add(acessorioEstoque);
            return true;
        }

    public boolean adicionarJogoEstoque(Jogo jogoEstoque){
        if (pesquisarJogoPorNome(jogoEstoque.getNomeJogo()) != null) {
            return false;
        }
            jogosEstoque.add(jogoEstoque);
            return true;
        }
  

    // Busca o console e remove do estoque
    public boolean removerConsolePorNome(String nomeConsole) {
        boolean removido = consolesEstoque.removeIf(console -> console.getNomeConsole().equalsIgnoreCase(nomeConsole));
            if (removido) {
                System.out.println("Console removido");
                return true;
            }
             else {
                System.out.println("Nenhum console com esse nome foi encontrado no estoque");
                return false;
            }
    }

    public boolean removerJogoPorNome(String nomeJogo) {
        boolean removido = jogosEstoque.removeIf(jogo -> jogo.getNomeJogo().equalsIgnoreCase(nomeJogo));
            if (removido) {
                System.out.println("Jogo removido");
                return true;
            }
             else {
                System.out.println("Nenhum jogo com esse nome foi encontrado no estoque");
                return false;
            }
    }

    public boolean removerAcessorioPorNome(String nomeAcessorio) {
        boolean removido = acessoriosEstoque.removeIf(acessorio -> acessorio.getNomeAcessorio().equalsIgnoreCase(nomeAcessorio));
            if (removido) {
                System.out.println("Acessório removido");
                return true;
            }
             else {
                System.out.println("Nenhum acessório com esse nome foi encontrado no estoque");
                return false;
            }
    }

    //verificar se o console está disponível no estoque
    public boolean verificarDisponibilidadeConsole(String nomeConsole) {
        for (Console console : consolesEstoque) {
            if (console.getQuantidadeConsole() > 0 && console.getNomeConsole().equalsIgnoreCase(nomeConsole)) {
                return true; // Em Estoque
            }
        }
        return false; // Console fora do estoque
    }
    //Mesma coisa do anterior
    public boolean verificarDisponibilidadeJogo(String nomeJogo) {
        for (Jogo jogo : jogosEstoque) {
            if (jogo.getQuantidadeJogo() > 0 && jogo.getNomeJogo().equalsIgnoreCase(nomeJogo)) {
                return true; // Em estoque
            }
        }
        return false; // Jogo fora do estoque
    }
    //Mesma coisa do anterior
    public boolean verificarDisponibilidadeAcessorio(String nomeAcessorio) {
        for (Acessorio acessorio : acessoriosEstoque) {
            if (acessorio.getQuantidadeAcessorio() > 0 && acessorio.getNomeAcessorio().equalsIgnoreCase(nomeAcessorio)) {
                return true; // Em Estoque
            }
        }
        return false; // Acessório fora do estoque
    }

    public Console pesquisarConsolePorNome(String nome) {
        for (Console c : consolesEstoque) {
            if (c.getNomeConsole().equalsIgnoreCase(nome)) {
                return c; // Achando o console
            }
        }
        return null; // Caso não ache
    }
    //Mesma coisa do anteior
    public Jogo pesquisarJogoPorNome(String nome) {
        for (Jogo j : jogosEstoque) {
            if (j.getNomeJogo().equalsIgnoreCase(nome)) {
                return j; 
        }
    }
        return null;
    }

    //Mesma coisa do anterior 
    public Acessorio pesquisarAcessorioPorNome(String nome) {
        for (Acessorio a : acessoriosEstoque) {
            if (a.getNomeAcessorio().equalsIgnoreCase(nome)) {
                return a; 
            }
        }
        return null;
    }

    //Organizar por nome os consoles
    public void organizarConsolesPNome() {
        consolesEstoque.sort(Comparator.comparing(Console::getNomeConsole));
    }
    
    public void organizarJogosPNome() {
        jogosEstoque.sort(Comparator.comparing(Jogo::getNomeJogo));
    }

    public void organizarAcessoriosPNome() {
        acessoriosEstoque.sort(Comparator.comparing(Acessorio::getNomeAcessorio));
    }

     
    //Edção do estoque de consoles
    public boolean editarConsole(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) {
        if (!novoNome.equalsIgnoreCase(nomeBuscado) && pesquisarConsolePorNome(novoNome) != null)
            {
                System.out.println("Já existe um console com o nome \"" + novoNome + "\".");

            return false;
            }
        for (Console console : consolesEstoque) {
            // Busca o connsole pelo nome
            if (console.getNomeConsole().equalsIgnoreCase(nomeBuscado)) {
                // Atualiza os valores das variavveis do console
                console.setNomeConsole(novoNome);
                console.setPrecoConsole(novoPreco);
                console.setDevolucaoConsole(novaDevolucao);
                console.setQuantidadeConsole(novaQuantidade);
                
                System.out.println("Console editado com sucesso!");
                return true;
            }
        }
        System.out.println("Console não encontrado para edição.");
        return false;
    }

    public boolean editarJogos(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) {
        if (!novoNome.equalsIgnoreCase(nomeBuscado) && pesquisarJogoPorNome(novoNome) != null) 
        {
            System.out.println("Já existe um jogo com o nome \"" + novoNome + "\".");

        return false;
        }
        for (Jogo jogo : jogosEstoque) {
            
            if (jogo.getNomeJogo().equalsIgnoreCase(nomeBuscado)) {
                
                jogo.setNomeJogo(novoNome);
                jogo.setPrecoJogo(novoPreco);
                jogo.setDevolucaoJogo(novaDevolucao);
                jogo.setQuantidadeJogo(novaQuantidade);
            
                System.out.println("Jogo editado com sucesso!");
                return true;
            }
        }
        System.out.println("Jogo não encontrado para edição.");
        return false;
    }

    public boolean editarAcessorios(String nomeBuscado, String novoNome, double novoPreco, int novaDevolucao, int novaQuantidade) {
        if (!novoNome.equalsIgnoreCase(nomeBuscado) && pesquisarAcessorioPorNome(novoNome) != null)
            {
            System.out.println("Já existe um acessório com o nome \"" + novoNome + "\".");
            
        return false;
            }
        for (Acessorio acessorio : acessoriosEstoque) {
          
            if (acessorio.getNomeAcessorio().equalsIgnoreCase(nomeBuscado)) {
                // Atualiza os valores das variavveis do acessório
                acessorio.setNomeAcessorio(novoNome);
                acessorio.setPrecoAcessorio(novoPreco);
                acessorio.setDevolucaoAcessorio(novaDevolucao);
                acessorio.setQuantidadeAcessorio(novaQuantidade);
            
                System.out.println("Acessório editado com sucesso!");
                return true;
            }
        }
        System.out.println("Acessório não encontrado para edição.");
        return false;
    }

    // Aqui calcula a disponibilidade dos produtos e tb mostra o percentual de produtos cadastrados que ainda tem unidades em estoque
    public double calcularDisponibilidade() {
    int total = consolesEstoque.size() + jogosEstoque.size() + acessoriosEstoque.size();
    
    if (total == 0) {
        return 0;
    }

    int disponiveis = 0;

  
    for (Console c : consolesEstoque) {
        if (c.getQuantidadeConsole() > 0) {
            disponiveis++;
        }
    }

    for (Jogo j : jogosEstoque) {
        if (j.getQuantidadeJogo() > 0) {
            disponiveis++;
        }
    }

    for (Acessorio a : acessoriosEstoque) {
        if (a.getQuantidadeAcessorio() > 0) {
            disponiveis++;
        }
    }

    return (disponiveis * 100.0) / total;
}


}
