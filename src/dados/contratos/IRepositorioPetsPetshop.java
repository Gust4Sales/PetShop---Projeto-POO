package dados.contratos;

import negocio.entidades.PetPetshop;

import java.util.ArrayList;

public interface IRepositorioPetsPetshop {
    void adicionarPet(PetPetshop pet);
    void removerPet(PetPetshop pet);
    boolean verificarPet(String id);
    PetPetshop getPet(String id);
    void atualizarPet(PetPetshop pet);
    ArrayList<PetPetshop> listarPets();
}
