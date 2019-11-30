package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando não é encontrado produto com esse id
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class ProdutoInexistenteException extends Exception {
    private String id;

    public ProdutoInexistenteException(String id){
        super("Nenhum produto cadastrado no sistema com ID: " + id);
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
