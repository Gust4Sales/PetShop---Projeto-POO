package negocio.entidades;

import negocio.contratos.VendaAbstrata;

public class VendaProduto extends VendaAbstrata {
    private Produto produto;

    public VendaProduto(Produto produto, String hora, String data){
        super();
        this.produto = produto;
    }
}
