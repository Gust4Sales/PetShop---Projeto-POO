package PetShop.negocio.excecoes;

public class PetPetshopJaCadastradoException extends Exception {
    private String id;

    public PetPetshopJaCadastradoException(String id){
        super("Pet já está cadastrado com ID: " + id);
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}

