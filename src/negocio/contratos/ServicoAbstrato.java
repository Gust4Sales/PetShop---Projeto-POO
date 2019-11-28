package negocio.contratos;

import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;

public abstract class ServicoAbstrato {
    protected double preco;
    protected String horaAgendada;
    protected String data;  // Criar classe Banho? Tosa?
    protected Cliente cliente;
    protected PetCliente pet;
    protected String status;
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

    public String getStatus() {
        return this.status;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void concluirStatus(){
        this.status = "Concluído";
    }
}
