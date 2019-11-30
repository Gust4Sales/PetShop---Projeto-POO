package PetShop.negocio.entidades;

import java.util.ArrayList;
/**
 * Essa classe representa os clientes do Petshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private ArrayList<PetCliente> pets;

    public Cliente(String nome, String cpf, String telefone, ArrayList<PetCliente> pets) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pets = pets;
    }

    //------------------------ GETTERS -------------------------
    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getTelefone() { return this.telefone; }

    public ArrayList<PetCliente> getPets() {

        return this.pets;
    }

    //--------------------------SETTERS-----------------------------

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPets(ArrayList<PetCliente> pets) {
        this.pets = pets;
    }

    // --------

    @Override
    public String toString(){
        return "Cliente: " + this.nome + ", CPF: " + this.cpf;
    }


}
