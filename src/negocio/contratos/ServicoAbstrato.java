package negocio.contratos;

import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;

public abstract class ServicoAbstrato {
    protected double preco;
    protected String horaAgendada;
    protected String data;  // Criar classe Banho? Tosa?
    protected Cliente cliente;
    protected PetCliente pet;
    protected boolean concluido;
    protected String descricao;

    public ServicoAbstrato(String horaAgendada, String data, Cliente cliente, PetCliente pet){
        this.horaAgendada = horaAgendada;
        this.data = data;
        this.cliente = cliente;
        this.pet = pet;
    }


    public double getPreco() {
        return this.preco;
    }

    public String getHoraAgendada() {
        return this.horaAgendada;
    }

    public String getData() {
        return this.data;
    }

    public boolean isConcluido() {
        return this.concluido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public PetCliente getPet() {
        return this.pet;
    }

    public String getDescricao() {
        return this.descricao;
    }

    ///////////////////////////////////////////////////////////////////////////

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setHoraAgendada(String horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
