package negocio.gerenciadores;


import dados.RepositorioPetsVendidosArray;
import dados.contratos.IRepositorioPetsPetshop;
import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.entidades.VendaPet;
import negocio.excecoes.PetPetshopInexistenteException;
import negocio.excecoes.PetPetshopJaCadastradoException;

import java.util.ArrayList;

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

    public void removerPetPetshop(String id) throws PetPetshopInexistenteException{
        boolean existe = this.repositorioPetsPetshop.verificarPet(id);

        if(existe){
            PetPetshop pet = this.consultarPet(id);
            VendaPet petVendido = new VendaPet(pet);

            this.repositorioPetsPetshop.removerPet(pet);
            this.registrarVenda(petVendido);
        } else {
            PetPetshop pet = this.consultarPet(id);
            throw new PetPetshopInexistenteException(pet.getId());
        }
    }

    private void registrarVenda(VendaPet petVendido){
        this.repositorioPetsVendidos.adicionarVenda(petVendido);
    }

    public void alterarPeso(PetPetshop pet, double peso){
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if (existe){
            pet.setPeso(peso);
            this.repositorioPetsPetshop.atualizarPet(pet);
        } else {
            // erro trhow
        }
    }

    public void alterarTamanho(PetPetshop pet, double tamanho){
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if (existe){
            pet.setTamanho(tamanho);
            this.repositorioPetsPetshop.atualizarPet(pet);
        } else{
            // trhow erro
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
        boolean existe = this.repositorioPetsPetshop.verificarPet(id);

        if (existe) {
            PetPetshop pet = this.repositorioPetsPetshop.getPet(id);
            return pet;
        } else {
            throw new PetPetshopInexistenteException(id);
        }
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