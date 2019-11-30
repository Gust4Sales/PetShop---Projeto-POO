package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando o usuário tenta cadastrar um produto com id já existente
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class ProdutoJaCadastradoException extends Exception {
    private String id;

    public ProdutoJaCadastradoException(String id){
        super("Produto já cadastrado com ID: " + id);
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}

