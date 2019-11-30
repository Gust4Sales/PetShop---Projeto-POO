package PetShop.negocio.entidades;
/**
 * Essa classe representa os pets do Petshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class PetPetshop{
    private String dataNascimento;
    private String id;
    private double peso;
    private double tamanho;
    private double preco;
    private String especie;
    private String sexo;

    public PetPetshop(String especie, String id, String sexo, String dataNascimento, double peso, double tamanho,
                      double preco){
        this.especie = especie;
        this.id = id;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    //--------------------------GETTERS--------------------------


    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getTamanho(){
        return this.tamanho;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getEspecie(){
        return this.especie;
    }

    public String getSexo(){
        return this.sexo;
    }

    public String getId() {
        return this.id;
    }

    //---------------------------SETTERS--------------------------

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public void setId(String id) {
        this.id = id;
    }

    //-----------------------------------------------------------

}
