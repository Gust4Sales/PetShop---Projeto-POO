package dados.contratos;

import negocio.entidades.PetPetshop;

public interface IRepositorioPetsPetshop {
    void adicionarPet(PetPetshop pet);
    void removerPet(PetPetshop pet);
    boolean verificarPet(String id);
    PetPetshop getPet(String id);
    void atualizarPet(PetPetshop pet);
}
