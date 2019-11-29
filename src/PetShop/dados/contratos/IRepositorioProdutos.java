package PetShop.dados.contratos;

import PetShop.negocio.entidades.Produto;
import PetShop.negocio.excecoes.ProdutoInexistenteException;

import java.util.ArrayList;

public interface IRepositorioProdutos {
    void adicionarProduto(Produto produto);
    void removerProduto(String id) throws ProdutoInexistenteException;
    Produto getProduto(String id) throws ProdutoInexistenteException;
    void atualizarProduto(Produto produto);
    boolean verificarProduto(String id);
    ArrayList<Produto> listarProdutos();
}
