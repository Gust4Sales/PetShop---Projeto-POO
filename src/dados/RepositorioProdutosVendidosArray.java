package dados;

import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.VendaProduto;

import java.util.ArrayList;

public class RepositorioProdutosVendidosArray {
    private ArrayList<VendaProduto> produtos;

    public RepositorioProdutosVendidosArray(){
        this.produtos = new ArrayList<>();
    }


    public void adicionarVenda(VendaProduto produtoVendido) {
        this.produtos.add(produtoVendido);
    }

    public VendaAbstrata getVenda(String id) {
        return null;
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
