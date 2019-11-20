package negocio.gerenciadores;

import dados.contratos.IRepositorioPetsPetshop;
import dados.contratos.IRepositorioPetsVendidos;
import negocio.contratos.VendaAbstrata;
import negocio.entidades.PetPetshop;
import negocio.entidades.VendaAbstrataPet;

public class NegocioPetVenda {
    private IRepositorioPetsPetshop repositorioPets;
    private IRepositorioPetsVendidos repositorioPetsVendidos;

    public NegocioPetVenda(IRepositorioPetsPetshop repoPets, IRepositorioPetsVendidos repoVend){
        this.repositorioPets = repoPets;
        this.repositorioPetsVendidos = repoVend;
    }

    public void venderPet(String id){
        boolean existe = this.repositorioPets.buscarPetDisponivel(id);

        if (existe){
            PetPetshop pet = this.repositorioPets.getPetDisponivel(id);

            VendaAbstrata vendaAbstrata = new VendaAbstrataPet(pet);
            this.salvarHistoricoVenda(vendaAbstrata);
            this.repositorioPets.removerPet(id);
        } else {
            // throw exception id nao existe
        }
    }

    public void salvarHistoricoVenda(VendaAbstrata vendaAbstrata){
        // this.repositorioPetsVendidos.adicionar(venda);
    }

}
