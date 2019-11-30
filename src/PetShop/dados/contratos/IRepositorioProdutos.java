package PetShop.dados.contratos;

import PetShop.negocio.entidades.Produto;
import PetShop.negocio.excecoes.ProdutoInexistenteException;

import java.util.ArrayList;
/**
 * Classe de interface para repositórios de produtos.
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public interface IRepositorioProdutos {
    void adicionarProduto(Produto produto);
    void removerProduto(String id) throws ProdutoInexistenteException;
    Produto getProduto(String id) throws ProdutoInexistenteException;
    void atualizarProduto(Produto produto);
    boolean verificarProduto(String id);
    ArrayList<Produto> listarProdutos();
}
