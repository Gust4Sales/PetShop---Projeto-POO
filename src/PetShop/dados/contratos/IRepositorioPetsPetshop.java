package PetShop.dados.contratos;

import PetShop.negocio.entidades.PetPetshop;
import PetShop.negocio.excecoes.PetPetshopInexistenteException;

import java.util.ArrayList;

public interface IRepositorioPetsPetshop {
    void adicionarPet(PetPetshop pet);
    void removerPet(PetPetshop pet);
    boolean verificarPet(String id);
    PetPetshop getPet(String id) throws PetPetshopInexistenteException;
    void atualizarPet(PetPetshop pet);
    ArrayList<PetPetshop> listarPets();
}
