package dados.contratos;

import negocio.contratos.Servico;

import java.util.ArrayList;

public interface IRepositorioServicos {
    void adicionarServico(Servico servico);
    void removerServico(String id);
    Servico getServico(String id);
    ArrayList<Servico> getListaServicosOfertados();
}
