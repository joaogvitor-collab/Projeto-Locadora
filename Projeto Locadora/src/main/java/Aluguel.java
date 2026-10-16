public class Aluguel {
    public static final double PERCENTUAL_MULTA = 0.5; // 50% da diária por dia de atraso

    private Cliente cliente;
    private String tipo;//Variavel pra saber se é console jogo ou acessório
    private String nomeItem;
    private double precoDiaria;
    private int diasPrevistos;
    private int diasUsados;
    private double multa;
    private boolean ativo = true;

    public Aluguel(Cliente cliente, String tipo, String nomeItem, double precoDiaria, int diasPrevistos) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.nomeItem = nomeItem;
        this.precoDiaria = precoDiaria;
        this.diasPrevistos = diasPrevistos;
    }

    public double getValorTotal() {
        return Custo() + multa;
    }

    public boolean teveAtraso() {
        return multa > 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public int getDiasPrevistos() {
        return diasPrevistos;
    }

    public int getDiasUsados() {
        return diasUsados;
    }

    public double getMulta() {
        return multa;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public void setDiasPrevistos(int diasPrevistos) {
        this.diasPrevistos = diasPrevistos;
    }

    public void setDiasUsados(int diasUsados) {
        this.diasUsados = diasUsados;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    //aqui vai calcular o custo
    public double Custo() {
        return precoDiaria * diasPrevistos;
    }

    //aplica multa quando devolve com atraso
    public void finalizar(int diasUsados) {
        this.diasUsados = diasUsados;
        int atraso = diasUsados - diasPrevistos;
        if (atraso > 0) {
            this.multa = atraso * precoDiaria * PERCENTUAL_MULTA;
        }
        this.ativo = false;
    }

    

    
}
