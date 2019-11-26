package dados;
import java.util.ArrayList;

import dados.contratos.IRepositorioProdutos;
import gui.ProjetoPoo;
import negocio.entidades.Produto;
import negocio.excecoes.ProdutoInexistenteException;

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
    public void removerProduto(String id) throws ProdutoInexistenteException{
        try{
            Produto produto = this.getProduto(id);

            this.produtos.remove(produto);
        } catch (ProdutoInexistenteException e){
            throw new ProdutoInexistenteException(id);
        }
    }

    @Override
    public Produto getProduto(String id) throws ProdutoInexistenteException {
        int index;

        for (Produto p : this.produtos) {
            if (p.getId().equals(id)) {
                index = this.produtos.indexOf(p);
                return this.produtos.get(index);
            }
        }
        throw new ProdutoInexistenteException(id);
    }

    @Override
    public void atualizarProduto(Produto produto){

    }

    @Override
    public ArrayList<Produto> getListaProdutos(){
        return this.produtos;
    }

    @Override
    public boolean verificarProduto(String id) {
        for (Produto p : this.produtos) {
            if (id.equals(p.getId())) {
                return true;
            }
        }
        return false;
    }
}
