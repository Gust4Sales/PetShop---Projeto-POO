package dados.contratos;


import negocio.contratos.VendaAbstrata;
import negocio.entidades.VendaPet;

public interface IRepositorioVendidos {
    void adicionarVenda(VendaAbstrata petVendido);
    VendaAbstrata getVenda(String id);
}
