package PetShop.negocio.entidades;

import PetShop.negocio.contratos.VendaAbstrata;
/**
 * Essa classe representa a venda do pet
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class VendaPet extends VendaAbstrata {
    private PetPetshop pet;

    public VendaPet(PetPetshop pet){
        super();
        this.pet = pet;
    }

    public PetPetshop getPet() {
        return this.pet;
    }
}
