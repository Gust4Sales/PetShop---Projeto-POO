package PetShop.dados;

import PetShop.negocio.contratos.VendaAbstrata;
import PetShop.negocio.entidades.VendaPet;

import java.util.ArrayList;
/**
 * Essa classe é reponsável por armazenar e gerenciar a recuperação dos VendaPet
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class RepositorioPetsVendidosArray {
    private ArrayList<VendaPet> pets;

    public RepositorioPetsVendidosArray(){
        this.pets = new ArrayList<>();
    }

    public void adicionarVenda(VendaPet petVendido) {
        this.pets.add(petVendido);
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
