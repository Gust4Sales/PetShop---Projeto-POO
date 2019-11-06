package dados.contratos;

import negocio.entidades.Produto;

import java.util.ArrayList;

public interface IRepositorioProdutos {
    void adicionarProduto(Produto produto);
    void removerProduto(String id);
    Produto getProduto(String id);
    ArrayList<Produto> getListaProdutos();

}
