package dados;

import dados.contratos.IRepositorioPetsPetshop;
import negocio.entidades.PetPetshop;

import java.util.ArrayList;

public class RepositorioPetsPetshopArray implements IRepositorioPetsPetshop {
    private ArrayList<PetPetshop> petsDisponiveis;
    private ArrayList<PetPetshop> petsIndisponiveis;

    public RepositorioPetsPetshopArray(){
        this.petsDisponiveis = new ArrayList();
        this.petsIndisponiveis = new ArrayList();
    }

    @Override
    public void adicionarPetDisponivel(PetPetshop pet) {
        this.petsDisponiveis.add(pet);
    }

    @Override
    public void adicionarPetVendido(PetPetshop pet) {
        this.petsIndisponiveis.add(pet);
    }

    @Override
    public void removerPet(String id) {
        PetPetshop pet = this.getPetDisponivel(id);

        this.petsDisponiveis.remove(pet);
    }

    @Override
    public PetPetshop getPetDisponivel(String id) {
        int index;

        for (PetPetshop p : this.petsDisponiveis) {
            if (p.getId().equals(id)) {
                index = this.petsDisponiveis.indexOf(p);
                return this.petsDisponiveis.get(index);
            }
        }
        return null;
    }

    @Override
    public boolean buscarPetDisponivel(String id) {
        return false;
    }
}
