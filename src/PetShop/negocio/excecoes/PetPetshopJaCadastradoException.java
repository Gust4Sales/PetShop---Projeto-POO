package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando o usuário tenta cadastrar um pet do petshop com id já existente
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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

