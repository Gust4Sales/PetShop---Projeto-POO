package dados.contratos;


import negocio.contratos.VendaAbstrata;
import negocio.entidades.VendaPet;

import java.util.ArrayList;

public interface IRepositorioVendidos {
    void adicionarVenda(VendaAbstrata itemVendido);
    VendaAbstrata getVenda(String id);
    ArrayList<VendaAbstrata> consultarVendas();
}
