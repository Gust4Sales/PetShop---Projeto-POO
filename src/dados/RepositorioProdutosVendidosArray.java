package dados;

import dados.contratos.IRepositorioVendidos;
import negocio.contratos.VendaAbstrata;

import java.util.ArrayList;

public class RepositorioProdutosVendidosArray implements IRepositorioVendidos {
    private ArrayList<VendaAbstrata> produtos;

    public RepositorioProdutosVendidosArray(){
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionarVenda(VendaAbstrata petVendido) {

    }

    @Override
    public VendaAbstrata getVenda(String id) {
        return null;
    }
}
