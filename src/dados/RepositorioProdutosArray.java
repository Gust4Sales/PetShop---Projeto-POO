package dados;
import java.util.ArrayList;

import dados.contratos.IRepositorioProdutos;
import negocio.entidades.Produto;

public class RepositorioProdutosArray implements IRepositorioProdutos {
    private ArrayList<Produto> produtos;

    public RepositorioProdutosArray(){
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }

    @Override
    public void removerProduto(String id){
        for (Produto p: this.produtos){
            if (p.getId().equals(id)){
                this.produtos.remove(p);
                break;
            }
        }
    }

    @Override
    public Produto getProduto(String id) {
        int index;

        for (Produto p : this.produtos) {
            if (p.getId().equals(id)) {
                index = this.produtos.indexOf(p);
                return this.produtos.get(index);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Produto> getListaProdutos(){
        return this.produtos;
    }
}
