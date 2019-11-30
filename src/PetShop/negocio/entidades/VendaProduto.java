package PetShop.negocio.entidades;

import PetShop.negocio.contratos.VendaAbstrata;
/**
 * Essa classe representa a venda do produto
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
