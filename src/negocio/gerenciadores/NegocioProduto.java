package negocio.gerenciadores;

import dados.RepositorioProdutosVendidosArray;
import dados.contratos.IRepositorioProdutos;
import dados.contratos.IRepositorioVendidos;
import negocio.entidades.Produto;
import negocio.excecoes.PetPetshopJaCadastradoException;
import negocio.excecoes.ProdutoInexistenteException;
import negocio.excecoes.ProdutoJaCadastradoException;
import negocio.excecoes.QuantidadeExcedidaException;

public class NegocioProduto {
    private IRepositorioProdutos repositorioProdutos;
    private IRepositorioVendidos repositorioProdVendidos;

    public NegocioProduto(IRepositorioProdutos repo, RepositorioProdutosVendidosArray repositorioProdVendidos){
        this.repositorioProdutos = repo;
        this.repositorioProdVendidos = repositorioProdVendidos;
    }

    public void adicionarProduto(Produto produto) throws ProdutoJaCadastradoException{
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if(existe){
            throw new ProdutoJaCadastradoException(produto.getId());
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

    public void decrementarQntd(String id, int qntd) throws QuantidadeExcedidaException, ProdutoInexistenteException {
        Produto produto = this.consultarProduto(id);
        // Gera historico
        if (produto.getQuantidade() < qntd){
            throw new QuantidadeExcedidaException(qntd);
        } else {
            produto.setQuantidade(produto.getQuantidade()-qntd);
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
