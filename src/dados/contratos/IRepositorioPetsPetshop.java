package dados.contratos;

import negocio.entidades.PetPetshop;

public interface IRepositorioPetsPetshop {
    void adicionarPetDisponivel(PetPetshop pet);
    void adicionarPetVendido(PetPetshop pet);
    void removerPet(String id);
    PetPetshop getPetDisponivel(String id);
    boolean buscarPetDisponivel(String id);
}
