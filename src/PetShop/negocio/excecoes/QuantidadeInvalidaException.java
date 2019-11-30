package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando o usuário tenta realizar alguma ação com um produto utilizando uma quantidade
 * inválida
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class QuantidadeInvalidaException extends Exception{

    private int quantidade;
    
    public QuantidadeInvalidaException(int quantidade){
        super("Quantidade " + quantidade + " inválida");
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}
