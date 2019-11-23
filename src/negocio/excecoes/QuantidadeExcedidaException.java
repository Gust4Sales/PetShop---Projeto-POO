package negocio.excecoes;

public class QuantidadeExcedidaException extends Exception{

    private int quantidade;
    
    public QuantidadeExcedidaException(int quantidade){
        super("Quantidade " + quantidade + " indisponivel");
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}
