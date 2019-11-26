package negocio;

import dados.*;
import negocio.contratos.ServicoAbstrato;
import negocio.entidades.*;
import negocio.excecoes.*;
import negocio.gerenciadores.NegocioCliente;
import negocio.gerenciadores.NegocioPetPetshop;
import negocio.gerenciadores.NegocioProduto;
import negocio.gerenciadores.NegocioServico;

import java.util.ArrayList;

public class PetShopFachada {
    private NegocioPetPetshop negocioPetPetshop;
    private NegocioProduto negocioProduto;
    private NegocioServico negocioServico;
    private NegocioCliente negocioCliente;

    public PetShopFachada(){
        this.negocioProduto = new NegocioProduto(new RepositorioProdutosArray(),
                new RepositorioProdutosVendidosArray());

        this.negocioPetPetshop = new NegocioPetPetshop(new RepositorioPetsPetshopArray(),
                new RepositorioPetsVendidosArray());

        this.negocioServico = new NegocioServico(new Agenda());

        this.negocioCliente = new NegocioCliente(new RepositorioClientesArray());
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

    public void atualizarPetPetshop(String id, double tamanho, double peso, double preco) throws
            PetPetshopInexistenteException {
        PetPetshop pet = negocioPetPetshop.consultarPet(id);
        negocioPetPetshop.alterarPeso(pet, peso);
        negocioPetPetshop.alterarPreco(pet, preco);
        negocioPetPetshop.alterarTamanho(pet, tamanho);
    }
    // FIm métodos PetPetshop

    // Inicio métodos Produto
    public void cadastrarProduto(String nome, String marca, double preco, String id, int quantidade)
            throws ProdutoJaCadastradoException {
        Produto produto = new Produto(nome, marca, preco, id, quantidade);

        this.negocioProduto.adicionarProduto(produto);
    }

    public void venderProduto(String id, int qntd) throws QuantidadeInvalidaException, ProdutoInexistenteException {
        this.negocioProduto.decrementarQntd(id, qntd);
    }

    public Produto consultarProduto(String id) throws ProdutoInexistenteException {

        return this.negocioProduto.consultarProduto(id);
    }
    public void removerProduto(String id) throws ProdutoInexistenteException{
        this.negocioProduto.removerProduto(id);
    }
    public void atualizarProduto(String id, int qntd, double preco) throws ProdutoInexistenteException, QuantidadeInvalidaException {
        Produto produto = negocioProduto.consultarProduto(id);
        negocioProduto.alterarPreco(produto, preco);
        negocioProduto.alterarQuantidade(produto, qntd);

    }
    // Fim métodos Produto

    // Inicio métodos Servico
    public void cadastrarServico(ServicoAbstrato s){
        this.negocioServico.adicionarServico(s);
    }

    public void desmarcarServico(ServicoAbstrato s){
        this.negocioServico.removerServico(s);
    }

    public ArrayList<ServicoAbstrato> consultarHorariosAgendados(String data){
        return this.negocioServico.consultarServicosAgendados(data);
    }

    // Fim métodos Servico

    // Inicio metodos Cliente
    public void cadastrarCliente(String nome, String cpf, String tel, ArrayList<PetCliente> pets) throws ClienteJaCadastradoException {
        Cliente cliente = new Cliente(nome, cpf, tel, pets);
        negocioCliente.adicionarCliente(cliente);
    }

    public Cliente consultarCliente(String cpf) throws ClienteInexistenteException{
        return this.negocioCliente.consultarCliente(cpf);
    }

    // FIm metodos CLiente
}
