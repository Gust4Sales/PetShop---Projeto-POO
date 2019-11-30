package PetShop.negocio.contratos;

import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.entidades.PetCliente;
/**
 * Classe abstrata que representa os Serviços de forma geral no sistema
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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

    public void concluirStatus(){
        this.status = "Concluído";
    }
}
