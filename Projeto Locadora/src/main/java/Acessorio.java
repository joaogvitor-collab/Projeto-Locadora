public class Acessorio {

    private String nomeAcessorio;
    private String acessorioConsole;
    private double precoAcessorio;
    private int devolucaoAcessorio;
    private int quantidadeAcessorio;

    public Acessorio(String nomeAcessorio, String acessorioConsole, double acessorioPreco, int acessorioDevolucao, int quantidadeAcessorio) {
        this.nomeAcessorio = nomeAcessorio;
        this.acessorioConsole = acessorioConsole;
        this.precoAcessorio = acessorioPreco;
        this.devolucaoAcessorio = acessorioDevolucao;
        this.quantidadeAcessorio = quantidadeAcessorio;
    }

    //////////////////////

    public String getNomeAcessorio() {
        return nomeAcessorio;
    }

    public void setNomeAcessorio(String nomeAcessorio) {
        this.nomeAcessorio = nomeAcessorio;
    }

    public String getAcessorioConsole() {
        return acessorioConsole;
    }

    public void setAcessorioConsole(String acessorioConsole) {
        this.acessorioConsole = acessorioConsole;
    }

    public double getPrecoAcessorio() {
        return precoAcessorio;
    }

    public void setPrecoAcessorio(double precoAcessorio) {
        this.precoAcessorio = precoAcessorio;
    }

    public int getDevolucaoAcessorio() {
        return devolucaoAcessorio;
    }

    public void setDevolucaoAcessorio(int devolucaoAcessorio) {
        this.devolucaoAcessorio = devolucaoAcessorio;
    }

    public int getQuantidadeAcessorio() {
        return quantidadeAcessorio;
    }

    public void setQuantidadeAcessorio(int quantidadeAcessorio) {
        this.quantidadeAcessorio = quantidadeAcessorio;
    }

    public String StatusAcessorio() {
    if (quantidadeAcessorio > 0) {
        return "DISPONÍVEL";
    } else {
        return "INDISPONÍVEL";
    }
}




}
