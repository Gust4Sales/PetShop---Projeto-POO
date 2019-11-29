package negocio.gerenciadores;

import dados.RepositorioProdutosVendidosArray;
import dados.contratos.IRepositorioProdutos;
import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.entidades.Produto;
import negocio.entidades.VendaProduto;
import negocio.excecoes.ProdutoInexistenteException;
import negocio.excecoes.ProdutoJaCadastradoException;
import negocio.excecoes.QuantidadeInvalidaException;

import java.util.ArrayList;

public class NegocioProduto {
    private IRepositorioProdutos repositorioProdutos;
    private RepositorioProdutosVendidosArray repositorioProdVendidos;

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

    public void removerProduto(String id) throws ProdutoInexistenteException {
            this.repositorioProdutos.removerProduto(id);
    }

    public void decrementarQntd(String id, int qntd) throws QuantidadeInvalidaException, ProdutoInexistenteException {
        Produto produto = this.consultarProduto(id);
        if (produto.getQuantidade() < qntd){
            throw new QuantidadeInvalidaException(qntd);
        } else {
            produto.setQuantidade(produto.getQuantidade()-qntd);

            VendaProduto vendaProduto = new VendaProduto(new Produto(produto.getNome(), produto.getMarca(),
                    produto.getPreco()*qntd, produto.getId(), qntd));
            this.registrarVenda(vendaProduto);
        }
    }

    private void registrarVenda(VendaProduto vendaProduto){
        this.repositorioProdVendidos.adicionarVenda(vendaProduto);
    }

    public Produto consultarProduto(String id) throws ProdutoInexistenteException {
        return this.repositorioProdutos.getProduto(id);

    }

    public void alterarPreco(Produto produto, double preco) throws ProdutoInexistenteException{
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if (existe){
            produto.setPreco(preco);
            this.repositorioProdutos.atualizarProduto(produto);
        } else {
            throw new ProdutoInexistenteException(produto.getId());
        }
    }

    public void alterarQuantidade (Produto produto, int qntd) throws ProdutoInexistenteException, QuantidadeInvalidaException {
        boolean existe = this.repositorioProdutos.verificarProduto(produto.getId());

        if(existe){
            if (qntd>0){
                produto.setQuantidade(qntd);
                this.repositorioProdutos.atualizarProduto(produto);
            } else {
                throw new QuantidadeInvalidaException(qntd);
            }
        } else {
            throw new ProdutoInexistenteException(produto.getId());
        }

    }

    public ArrayList<Produto> consultarProdutosEstoque(){
        return this.repositorioProdutos.listarProdutos();
    }

    public ArrayList<VendaProduto> consultarVendaProdutosPorData(String data){
        return this.repositorioProdVendidos.consultarVendasPorData(data);
    }

    public ArrayList<VendaProduto> consultarVendaProdutos() {
        return this.repositorioProdVendidos.consultarVendas();
    }
}
