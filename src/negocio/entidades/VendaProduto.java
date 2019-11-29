package negocio.entidades;

import negocio.contratos.VendaAbstrata;

public class VendaProduto extends VendaAbstrata {
    private Produto produto;

    public VendaProduto(Produto produto){
        super();
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }
}
