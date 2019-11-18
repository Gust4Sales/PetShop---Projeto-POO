package negocio.entidades;

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

    public String getespecie(){
        return this.especie;
    }

    public String getsexo(){
        return this.sexo;
    }
//        -----------------------SETTERS----------------------
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

//        -----------------------------------------------------
@Override
public String toString(){
        return "    Nome: " + this.nome + ". " + "Especie: " + this.especie + ". " + "Sexo: " + this.sexo + ".";
        }
}