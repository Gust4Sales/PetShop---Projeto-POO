package PetShop.negocio.entidades;

import java.util.ArrayList;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private ArrayList<PetCliente> pets;
    private double divida;

    public Cliente(String nome, String cpf, String telefone, ArrayList<PetCliente> pets) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pets = pets;
        this.divida = 0.0;
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

    public double getDivida() {
        return this.divida;
    }

    //--------------------------SETTERS-----------------------------

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPets(ArrayList<PetCliente> pets) {
        this.pets = pets;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    // --------

    @Override
    public String toString(){
        return "Cliente: " + this.nome + ", CPF: " + this.cpf;
    }


}
