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
        for (Servico s: this.servicos){
            if (s.getId().equals(id)){
                this.servicos.remove(s);
                break;
            }
        }
    }

    @Override
    public Servico getServico(String id) {
        int index;

        for (Servico s : this.servicos) {
            if (s.getId().equals(id)) {
                index = this.servicos.indexOf(s);
                return this.servicos.get(index);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Servico> getListaServicosOfertados() {
        return this.servicos;
    }

}
