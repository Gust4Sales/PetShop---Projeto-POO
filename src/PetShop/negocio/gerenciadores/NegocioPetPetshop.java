package PetShop.negocio.gerenciadores;


import PetShop.dados.RepositorioPetsVendidosArray;
import PetShop.dados.contratos.IRepositorioPetsPetshop;
import PetShop.negocio.entidades.PetPetshop;
import PetShop.negocio.entidades.VendaPet;
import PetShop.negocio.excecoes.PetPetshopInexistenteException;
import PetShop.negocio.excecoes.PetPetshopJaCadastradoException;

import java.util.ArrayList;

/**
 * Essa classe aplica as regras de negócio e o gerenciamento do PetPetshop no sistema
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class NegocioPetPetshop {
    private IRepositorioPetsPetshop repositorioPetsPetshop;
    private RepositorioPetsVendidosArray repositorioPetsVendidos;

    public NegocioPetPetshop(IRepositorioPetsPetshop repo, RepositorioPetsVendidosArray repoVendidos){
        this.repositorioPetsPetshop = repo;
        this.repositorioPetsVendidos = repoVendidos;
    }

    public void adicionarPetPetshop(PetPetshop pet) throws PetPetshopJaCadastradoException {
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if(existe){
            throw new PetPetshopJaCadastradoException(pet.getId());
        } else {
            this.repositorioPetsPetshop.adicionarPet(pet);
        }
    }

    public void venderPetPetshop(String id) throws PetPetshopInexistenteException{
        boolean existe = this.repositorioPetsPetshop.verificarPet(id);

        if(existe){
            PetPetshop pet = this.consultarPet(id);
            VendaPet petVendido = new VendaPet(pet);

            this.repositorioPetsPetshop.removerPet(pet);
            this.registrarVenda(petVendido);
        } else {
            throw new PetPetshopInexistenteException(id);
        }
    }

    public void removerPetPetshop(String id) throws PetPetshopInexistenteException{
        boolean existe = this.repositorioPetsPetshop.verificarPet(id);

        if(existe){
            PetPetshop pet = this.consultarPet(id);
            VendaPet petVendido = new VendaPet(pet);

            this.repositorioPetsPetshop.removerPet(pet);
        } else {
            throw new PetPetshopInexistenteException(id);
        }
    }

    private void registrarVenda(VendaPet petVendido){
        this.repositorioPetsVendidos.adicionarVenda(petVendido);
    }

    public void alterarPeso(PetPetshop pet, double peso) throws PetPetshopInexistenteException {
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if (existe){
            pet.setPeso(peso);
            this.repositorioPetsPetshop.atualizarPet(pet);
        } else {
            throw new PetPetshopInexistenteException(pet.getId());
        }
    }

    public void alterarTamanho(PetPetshop pet, double tamanho) throws PetPetshopInexistenteException {
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if (existe){
            pet.setTamanho(tamanho);
            this.repositorioPetsPetshop.atualizarPet(pet);
        } else{
           throw new PetPetshopInexistenteException(pet.getId());
        }
    }

    public void alterarPreco(PetPetshop pet, double preco) throws PetPetshopInexistenteException{
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if(existe){
            pet.setPreco(preco);
            this.repositorioPetsPetshop.atualizarPet(pet);
        }else{
            throw new PetPetshopInexistenteException(pet.getId());
        }
    }

    public PetPetshop consultarPet(String id) throws PetPetshopInexistenteException {
        return this.repositorioPetsPetshop.getPet(id);
    }

    public ArrayList<PetPetshop> consultarPetsEstoque(){
        return this.repositorioPetsPetshop.listarPets();
    }

    public ArrayList<VendaPet> consultarVendaPets() {
        return this.repositorioPetsVendidos.consultarVendas();
    }

    public ArrayList<VendaPet> consultarVendaPetsPorData(String data){
        return this.repositorioPetsVendidos.consultarVendasPorData(data);
    }

}