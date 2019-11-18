package negocio.entidades;

import java.util.ArrayList;

public class Cliente {
    private String cpf;
    private String nome;
    private ArrayList<PetCliente> pets;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        pets = new ArrayList<PetCliente>();
    }

    //------------------------ GETTERS -------------------------
    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    //--------------------------SETTERS-----------------------------
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String Cpf){
        this.cpf = cpf;
    }

    // --------

    @Override
    public String toString(){
        return "Cliente: " + this.nome + ", CPF: " + this.cpf;
    }


}
