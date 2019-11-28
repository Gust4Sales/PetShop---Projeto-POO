package dados.contratos;

import negocio.entidades.PetPetshop;
import negocio.entidades.Produto;
import negocio.excecoes.ProdutoInexistenteException;

import java.util.ArrayList;

public interface IRepositorioProdutos {
    void adicionarProduto(Produto produto);
    void removerProduto(String id) throws ProdutoInexistenteException;
    Produto getProduto(String id) throws ProdutoInexistenteException;
    void atualizarProduto(Produto produto);
    ArrayList<Produto> getListaProdutos();
    boolean verificarProduto(String id);
    ArrayList<Produto> listarProdutos();
}
