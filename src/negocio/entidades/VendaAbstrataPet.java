package negocio.entidades;

import negocio.contratos.VendaAbstrata;

public class VendaAbstrataPet extends VendaAbstrata {
    private PetPetshop pet;

    public VendaAbstrataPet(PetPetshop pet){
        super();
        this.pet = pet;
    }


}
