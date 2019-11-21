package negocio.exececoes;

import negocio.entidades.Produto;

public class ProdutoInexistenteException extends Exception {
    private String id;

    public ProdutoInexistenteException(String id){
        super("Nenhum produto cadastrado no sistema com ID: " + id);
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
