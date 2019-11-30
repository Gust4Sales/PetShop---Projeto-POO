package PetShop.dados;

import PetShop.dados.contratos.IRepositorioPetsPetshop;
import PetShop.negocio.entidades.PetPetshop;
import PetShop.negocio.excecoes.PetPetshopInexistenteException;

import java.util.ArrayList;
/**
 * Essa classe é reponsável por armazenar, e gerenciar a recuperação dos PetsPetshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
    public PetPetshop getPet(String id) throws PetPetshopInexistenteException {
        int index;

        for (PetPetshop p : this.petsDisponiveis) {
            if (p.getId().equals(id)) {
                index = this.petsDisponiveis.indexOf(p);
                return this.petsDisponiveis.get(index);
            }
        }
        throw new PetPetshopInexistenteException(id);

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