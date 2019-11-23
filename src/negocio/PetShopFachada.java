package negocio;

import dados.*;
import negocio.contratos.ServicoAbstrato;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.entidades.Produto;
import negocio.entidades.VendaPet;
import negocio.excecoes.*;
import negocio.gerenciadores.NegocioPetPetshop;
import negocio.gerenciadores.NegocioProduto;
import negocio.gerenciadores.NegocioServico;

import java.util.ArrayList;

public class PetShopFachada {
    private NegocioPetPetshop negocioPetPetshop;
    private NegocioProduto negocioProduto;
    private NegocioServico negocioServico;

    public PetShopFachada(){
        this.negocioProduto = new NegocioProduto(new RepositorioProdutosArray(),
                new RepositorioProdutosVendidosArray());

        this.negocioPetPetshop = new NegocioPetPetshop(new RepositorioPetsPetshopArray(),
                new RepositorioPetsVendidosArray());

        this.negocioServico = new NegocioServico(new Agenda());

    }
    // Inicio método PetPetshop
    public void cadastrarPetPetshop(String especie, String id, String sexo, String dataNascimento, double peso,
                                    double tamanho, double preco) throws PetPetshopJaCadastradoException {
        PetPetshop pet = new PetPetshop(especie, id, sexo, dataNascimento, peso, tamanho, preco);

        this.negocioPetPetshop.adicionarPetPetshop(pet);
    }

    public void venderPetPetshop(String id) throws PetPetshopInexistenteException{

        this.negocioPetPetshop.removerPetPetshop(id);

    }

    public PetPetshop consultarPetPetshop(String id) throws PetPetshopInexistenteException {

        return this.negocioPetPetshop.consultarPet(id);
    }
    // FIm métodos PetPetshop

    // Inicio métodos Produto
    public void cadastrarProduto(String nome, String marca, double preco, String id, int quantidade)
        throws ProdutoJaCadastradoException {
        Produto produto = new Produto(nome, marca, preco, id, quantidade);

        this.negocioProduto.adicionarProduto(produto);
    }

    public void venderProduto(String id, int qntd) throws QuantidadeExcedidaException, ProdutoInexistenteException {
        this.negocioProduto.decrementarQntd(id, qntd);
    }

    public Produto consultarProduto(String id) throws ProdutoInexistenteException {

        return this.negocioProduto.consultarProduto(id);
    }

    // Fim métodos Produto

    // Fim métodos Produto

    // Inicio métodos Servico
    public ArrayList<ServicoAbstrato> consultarHorariosAgendados(String data){
        return this.negocioServico.consultarServicosAgendados(data);
    }

    // Fim métodos Servico
}
