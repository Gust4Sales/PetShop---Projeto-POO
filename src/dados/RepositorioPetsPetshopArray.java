package dados;

import dados.contratos.IRepositorioPetsPetshop;
import negocio.entidades.PetPetshop;

import java.util.ArrayList;

public class RepositorioPetsPetshopArray implements IRepositorioPetsPetshop {
    private ArrayList<PetPetshop> petsDisponiveis;

    public RepositorioPetsPetshopArray(){
        this.petsDisponiveis = new ArrayList<>();
    }

    @Override
    public void adicionarPet(PetPetshop pet) {
        this.petsDisponiveis.add(pet);
    }

    @Override
    public void removerPet(PetPetshop pet) {
        this.petsDisponiveis.remove(pet);
    }

    @Override
    public void atualizarPet(PetPetshop pet){
        int index = this.petsDisponiveis.indexOf(pet);
        this.petsDisponiveis.set(index, pet);

    }

    @Override
    public ArrayList<PetPetshop> listarPets() {
        return this.petsDisponiveis;
    }

    @Override
    public PetPetshop getPet(String id) {
        int index;

        for (PetPetshop p : this.petsDisponiveis) {
            if (p.getId().equals(id)) {
                index = this.petsDisponiveis.indexOf(p);
                return this.petsDisponiveis.get(index);
            }
        }
        return null;
        // Retorna throw PetInexistente
    }

    @Override
    public boolean verificarPet(String id) {
        for (PetPetshop p : this.petsDisponiveis) {
            if (id.equals(p.getId())) {
                return true;
            }
        }
        return false;
    }

}