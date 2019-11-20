package negocio.contratos;

import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;

public abstract class ServicoAbstrato {
    protected double preco;
    protected String horaAgendada, data;  // Criar classe Banho? Tosa?
    // Tempo associado ao serviço
    protected Cliente cliente;
    protected PetCliente pet;
    protected boolean concluido;

    public ServicoAbstrato(String horaAgendada, Cliente cliente, PetCliente pet){
        this.horaAgendada = horaAgendada;
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

}
