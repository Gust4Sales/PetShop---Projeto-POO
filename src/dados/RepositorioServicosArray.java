package dados;

import dados.contratos.IRepositorioServicos;
import negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;

public class RepositorioServicosArray implements IRepositorioServicos {
    private ArrayList<ServicoAbstrato> servicoAbstratoes;

    public RepositorioServicosArray(){
        this.servicoAbstratoes = new ArrayList<>();
    }

    @Override
    public void adicionarServico(ServicoAbstrato servicoAbstrato){
        this.servicoAbstratoes.add(servicoAbstrato);
    }

    @Override
    public void removerServico(String id) {
    }

    @Override
    public ServicoAbstrato getServicosConcluidos(String cpf) {
        return null;
    }

    @Override
    public ServicoAbstrato getServicosEmAndamentos(String cpf) {
        return null;
    }

}
