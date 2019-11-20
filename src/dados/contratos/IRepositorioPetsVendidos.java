package dados.contratos;


import negocio.contratos.VendaAbstrata;

public interface IRepositorioPetsVendidos {
    void adicionar(VendaAbstrata petVendido);
    void remover(String id);
    VendaAbstrata getPet(String id);
}
