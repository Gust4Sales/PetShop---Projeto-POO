package PetShop.negocio.excecoes;

public class PetPetshopInexistenteException extends Exception {
    private String id;

    public PetPetshopInexistenteException(String id){
        super("Nenhum Pet cadastrado no sistema com ID: " + id);
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
