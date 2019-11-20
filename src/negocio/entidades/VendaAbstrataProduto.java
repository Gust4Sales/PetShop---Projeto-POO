package negocio.entidades;

import negocio.contratos.VendaAbstrata;

public class VendaAbstrataProduto extends VendaAbstrata {
    private Produto produto;

    public VendaAbstrataProduto(Produto produto, String hora, String data){
        super();
        this.produto = produto;
    }
}
