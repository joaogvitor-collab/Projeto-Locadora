import java.util.ArrayList;

public class Console {

    private int quantidadeConsole;
    private String nomeConsole;
    private double precoConsole;
    private int devolucaoConsole;
    private ArrayList<Jogo> jogosConsole = new ArrayList<>();
    private ArrayList<Acessorio> acessoriosConsole = new ArrayList<>();

    public Console(String nomeConsole, double precoConsole, int devolucaoConsole, int quantidadeConsole) {
        this.nomeConsole = nomeConsole;
        this.precoConsole = precoConsole;
        this.devolucaoConsole = devolucaoConsole;
        this.quantidadeConsole = quantidadeConsole;
    }

    ///////////////////////////////////////

    public String getNomeConsole() {
        return nomeConsole;
    }

    public void setNomeConsole(String nomeConsole) {
        this.nomeConsole = nomeConsole;
    }

    public double getPrecoConsole() {
        return precoConsole;
    }

    public void setPrecoConsole(double precoConsole) {
        this.precoConsole = precoConsole;
    }

    public int getDevolucaoConsole() {
        return devolucaoConsole;
    }

    public void setDevolucaoConsole(int devolucaoConsole) {
        this.devolucaoConsole = devolucaoConsole;
    }

    public ArrayList<Jogo> getJogosConsole() {
        return jogosConsole;
    }

    public void setJogosConsole(ArrayList<Jogo> jogosConsole) {
        this.jogosConsole = jogosConsole;
    }

    public ArrayList<Acessorio> getAcessoriosConsole() {
        return acessoriosConsole;
    }

    public void setAcessoriosConsole(ArrayList<Acessorio> acessoriosConsole) {
        this.acessoriosConsole = acessoriosConsole;
    }


    public int getQuantidadeConsole() {
        return quantidadeConsole;
    }

    public void setQuantidadeConsole(int quantidadeConsole) {
        this.quantidadeConsole = quantidadeConsole;
    }

    public String StatusConsole() {
    if (quantidadeConsole > 0) {
        return "DISPONÍVEL";
    } else {
        return "INDISPONÍVEL";
    }
}

}
