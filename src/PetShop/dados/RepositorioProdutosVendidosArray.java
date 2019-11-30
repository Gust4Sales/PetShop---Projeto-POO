package PetShop.dados;

import PetShop.negocio.contratos.VendaAbstrata;
import PetShop.negocio.entidades.VendaProduto;

import java.util.ArrayList;
/**
 * Essa classe é reponsável por armazenar e gerenciar a recuperação dos VendaProdutos
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class RepositorioProdutosVendidosArray {
    private ArrayList<VendaProduto> produtos;

    public RepositorioProdutosVendidosArray(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarVenda(VendaProduto produtoVendido) {
        this.produtos.add(produtoVendido);
    }

    public ArrayList<VendaProduto> consultarVendas() {
        return this.produtos;
    }

    public ArrayList<VendaProduto> consultarVendasPorData(String data) {
        ArrayList<VendaProduto> produtosV = new ArrayList<>();

        for (VendaProduto v: this.produtos){
            if (v.getData().equals(data)){
                produtosV.add(v);
            }
        }
        return produtosV;
    }
}
