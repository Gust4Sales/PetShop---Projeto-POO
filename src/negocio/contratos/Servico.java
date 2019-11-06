package negocio.contratos;

public abstract class Servico {
    protected String descricao, id;
    protected double preco;
    protected String horaAgendada, data;  // Criar classe Banho? Tosa?
    // Tempo associado ao serviço
    // Pet associado, Cliente

    public Servico(String descricao, String id, double preco, String horaAgendada){
        this.descricao = descricao;
        this.id = id;
        this.preco = preco;
        this.horaAgendada = horaAgendada;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getId() {
        return this.id;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getHoraAgendada() {
        return this.horaAgendada;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setHoraAgendada(String horaAgendada) {
        this.horaAgendada = horaAgendada;
    }
}
