package negocio.gerenciadores;

import dados.RepositorioProdutosVendidosArray;
import dados.contratos.IRepositorioProdutos;
import dados.contratos.IRepositorioVendidos;
import negocio.entidades.Produto;
import negocio.exececoes.ProdutoInexistenteException;

public class NegocioProduto {
    private IRepositorioProdutos repositorioProdutos;
    private IRepositorioVendidos repositorioProdVendidos;

    public NegocioProduto(IRepositorioProdutos repo, RepositorioProdutosVendidosArray repositorioProdVendidos){
        this.repositorioProdutos = repo;
        this.repositorioProdVendidos = repositorioProdVendidos;
    }

    public void adicionarProduto(Produto produto){
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if(existe){
            //trow erro
        } else {
            this.repositorioProdutos.adicionarProduto(produto);
        }
    }

    public void removerProduto(Produto produto){
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if(existe){
            this.repositorioProdutos.removerProduto(produto);

        } else {
            //troonom erro
        }
    }

    public Produto consultarProduto(String id) throws ProdutoInexistenteException {
        boolean existe = this.repositorioProdutos.verificarProduto(id);

        if (existe) {
            Produto produto = this.repositorioProdutos.getProduto(id);
            return produto;
        } else {
            throw new ProdutoInexistenteException(id);
        }

    }

    public void alterarPreco(Produto produto, double preco){
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if (existe){
            produto.setPreco(preco);
            this.repositorioProdutos.atualizarProduto(produto);
        } else {
            // erro trhow
        }
    }
}
