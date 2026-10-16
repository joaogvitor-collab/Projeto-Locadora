import java.util.ArrayList;

public class Cliente {

    private String nomeCliente;
    private ArrayList<Jogo>jogosEmprestados = new ArrayList<>();
    private ArrayList<Console>consolesEmprestados = new ArrayList<>();
    private ArrayList<Acessorio>acessoriosEmprestados = new ArrayList<>();

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /////////////////////////////////////////////////

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public ArrayList<Jogo> getJogosEmprestados() {
        return jogosEmprestados;
    }

    public void setJogosEmprestados(ArrayList<Jogo> jogosEmprestados) {
        this.jogosEmprestados = jogosEmprestados;
    }

    public ArrayList<Console> getConsolesEmprestados() {
        return consolesEmprestados;
    }

    public void setConsolesEmprestados(ArrayList<Console> consolesEmprestados) {
        this.consolesEmprestados = consolesEmprestados;
    }

    public ArrayList<Acessorio> getAcessoriosEmprestados() {
        return acessoriosEmprestados;
    }

    public void setAcessoriosEmprestados(ArrayList<Acessorio> acessoriosEmprestados) {
        this.acessoriosEmprestados = acessoriosEmprestados;
    }

    //metodo pra criar o limite de itens emprestados
    public int TotalItensEmprestados() {
    return jogosEmprestados.size() + consolesEmprestados.size() + acessoriosEmprestados.size();
}
}
