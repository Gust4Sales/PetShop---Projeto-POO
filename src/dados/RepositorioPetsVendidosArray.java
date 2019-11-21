package dados;

import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;

import java.util.ArrayList;

public class RepositorioPetsVendidosArray implements IRepositorioVendidos {
    private ArrayList<VendaAbstrata> pets;

    public RepositorioPetsVendidosArray(){
        this.pets = new ArrayList<>();
    }

    @Override
    public void adicionarVenda(VendaAbstrata petVendido) {
        this.pets.add(petVendido);
    }


    @Override
    public VendaAbstrata getVenda(String id) {
        return null;
    }
}
