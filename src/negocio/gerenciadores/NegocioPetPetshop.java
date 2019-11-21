package negocio.gerenciadores;

import dados.contratos.IRepositorioPetsPetshop;
import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.exececoes.PetPetshopInexistenteException;

public class NegocioPetPetshop {
    private IRepositorioPetsPetshop repositorioPetsPetshop;
    private IRepositorioVendidos repositorioPetsVendidos;

    public NegocioPetPetshop(IRepositorioPetsPetshop repo, IRepositorioVendidos repoVendidos){
        this.repositorioPetsPetshop = repo;
        this.repositorioPetsVendidos = repoVendidos;
    }

    public void adicionarPetPetshop(PetPetshop pet){
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if(existe){
            // trow pet existete
        } else {
            this.repositorioPetsPetshop.adicionarPet(pet);
        }
    }

    public void removerPetPetshop(PetPetshop pet) throws PetPetshopInexistenteException{
        boolean existe = this.repositorioPetsPetshop.verificarPet(pet.getId());

        if(existe){
            this.repositorioPetsPetshop.removerPet(pet);
        } else {
            throw new PetPetshopInexistenteException(pet.getId());
        }
    }

    public void registrarVenda(VendaAbstrata petVendido){
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
}
