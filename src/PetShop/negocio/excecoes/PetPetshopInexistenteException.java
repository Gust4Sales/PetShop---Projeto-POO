package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando não é encontrado pet do petshop com esse id
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
