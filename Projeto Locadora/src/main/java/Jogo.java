public class Jogo {

    private String nomeJogo;
    private String jogoConsole;
    private double precoJogo;
    private int devolucaoJogo;
    private int quantidadeJogo;

    public Jogo(String nomeJogo, String jogoConsole, double jogoPreco, int jogoDevolucao, int quantidadeJogo) {
        this.nomeJogo = nomeJogo;
        this.jogoConsole = jogoConsole;
        this.precoJogo = jogoPreco;
        this.devolucaoJogo = jogoDevolucao;
        this.quantidadeJogo = quantidadeJogo;
    }

    ////////////////////////////////////////////

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getJogoConsole() {
        return jogoConsole;
    }

    public void setJogoConsole(String jogoConsole) {
        this.jogoConsole = jogoConsole;
    }

    public double getPrecoJogo() {
        return precoJogo;
    }

    public void setPrecoJogo(double precoJogo) {
        this.precoJogo = precoJogo;
    }

    public int getDevolucaoJogo() {
        return devolucaoJogo;
    }

    public void setDevolucaoJogo(int devolucaoJogo) {
        this.devolucaoJogo = devolucaoJogo;
    }

    public int getQuantidadeJogo() {
        return quantidadeJogo;
    }

    public void setQuantidadeJogo(int quantidadeJogo) {
        this.quantidadeJogo = quantidadeJogo;
    }


    public String StatusJogo() {
    if (quantidadeJogo > 0) {
        return "DISPONÍVEL";
    } else {
        return "INDISPONÍVEL";
    }
}

}
