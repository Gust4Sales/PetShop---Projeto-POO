package dados;

import dados.contratos.IRepositorioServicos;
import negocio.contratos.Servico;

import java.util.ArrayList;

public class RepositorioServicosArray implements IRepositorioServicos {
    private ArrayList<Servico> servicos;

    public RepositorioServicosArray(){
        this.servicos = new ArrayList<>();
    }

    @Override
    public void adicionarServico(Servico servico){
        this.servicos.add(servico);
    }

    @Override
    public void removerServico(String id) {
    }

    @Override
    public Servico getServicosConcluidos(String cpf) {
        return null;
    }

    @Override
    public Servico getServicosEmAndamentos(String cpf) {
        return null;
    }

}
