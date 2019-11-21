package negocio;

import dados.RepositorioPetsPetshopArray;
import dados.RepositorioPetsVendidosArray;
import dados.RepositorioProdutosArray;
import dados.RepositorioProdutosVendidosArray;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.entidades.Produto;
import negocio.entidades.VendaPet;
import negocio.exececoes.PetPetshopInexistenteException;
import negocio.exececoes.ProdutoInexistenteException;
import negocio.gerenciadores.NegocioPetPetshop;
import negocio.gerenciadores.NegocioProduto;

public class PetShopFachada {
    private NegocioPetPetshop negocioPetPetshop;
    private NegocioProduto negocioProduto;

    public PetShopFachada(){
        this.negocioProduto = new NegocioProduto(new RepositorioProdutosArray(),
                new RepositorioProdutosVendidosArray());

        this.negocioPetPetshop = new NegocioPetPetshop(new RepositorioPetsPetshopArray(),
                new RepositorioPetsVendidosArray());
    }
    // Inicio método PetPetshop
    public void cadastrarPetPetshop(String especie, String id, String sexo, String dataNascimento, double peso,
                                    double tamanho, double preco){
        PetPetshop pet = new PetPetshop(especie, id, sexo, dataNascimento, peso, tamanho, preco);

        this.negocioPetPetshop.adicionarPetPetshop(pet);
    }

    public void venderPetPetshop(PetPetshop pet) throws PetPetshopInexistenteException{
        VendaAbstrata petVendido = new VendaPet(pet);
        this.negocioPetPetshop.removerPetPetshop(pet);

       this.negocioPetPetshop.registrarVenda(petVendido);
    }

    public PetPetshop consultarPetPetshop(String id) throws PetPetshopInexistenteException {

        return this.negocioPetPetshop.consultarPet(id);
    }
    // FIm métodos PetPetshop

    // Inicio métodos Produto
    public void cadastrarProduto(String nome, String marca, double preco, String id, int quantidade) {
        Produto produto = new Produto(nome, marca, preco, id, quantidade);

        this.negocioProduto.adicionarProduto(produto);
    }
    public Produto consultarProduto(String id) throws ProdutoInexistenteException {

        return this.negocioProduto.consultarProduto(id);
    }

    // Fim métodos Produto
}
