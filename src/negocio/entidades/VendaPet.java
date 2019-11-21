package negocio.entidades;

import negocio.contratos.VendaAbstrata;

public class VendaPet extends VendaAbstrata {
    private PetPetshop pet;

    public VendaPet(PetPetshop pet){
        super();
        this.pet = pet;
    }


}
