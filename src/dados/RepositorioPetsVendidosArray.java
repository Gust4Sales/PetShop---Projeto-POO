package dados;

import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.VendaPet;

import java.util.ArrayList;

public class RepositorioPetsVendidosArray {
    private ArrayList<VendaPet> pets;

    public RepositorioPetsVendidosArray(){
        this.pets = new ArrayList<>();
    }


    public void adicionarVenda(VendaPet petVendido) {
        this.pets.add(petVendido);
    }


    public VendaAbstrata getVenda(String id) {
        return null;
    }


    public ArrayList<VendaPet> consultarVendas() {
        return this.pets;
    }

    public ArrayList<VendaPet> consultarVendasPorData(String data) {
        ArrayList<VendaPet> petsV = new ArrayList<>();

        for (VendaPet v: this.pets){
            if (v.getData().equals(data)){
                petsV.add(v);
            }
        }
        return petsV;
    }
}
