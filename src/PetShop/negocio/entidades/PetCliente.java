package PetShop.negocio.entidades;

public class PetCliente {
    private String nome;
    private String especie;
    private String sexo;

    public PetCliente(String nome, String especie, String sexo){
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
    }
//-----------------------GETTERS--------------------
    public String getNome(){
        return this.nome;
    }

    public String getEspecie(){
        return this.especie;
    }

    public String getSexo(){
        return this.sexo;
    }

//        -----------------------------------------------------
@Override
public String toString(){
        return "    Nome: " + this.nome + ". " + "Especie: " + this.especie + ". " + "Sexo: " + this.sexo + ".";
        }
}