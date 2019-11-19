package negocio.entidades;

import java.util.ArrayList;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private ArrayList<PetCliente> pets;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        pets = new ArrayList<PetCliente>();
    }

    //------------------------ GETTERS -------------------------
    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getTelefone() { return this.telefone; }

    //--------------------------SETTERS-----------------------------

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // --------

    @Override
    public String toString(){
        return "Cliente: " + this.nome + ", CPF: " + this.cpf;
    }


}
