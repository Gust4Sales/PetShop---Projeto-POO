package dados.contratos;

import negocio.contratos.Servico;

import java.util.ArrayList;

public interface IRepositorioServicos {
    void adicionarServico(Servico servico);
    void removerServico(String id);
    Servico getServicosConcluidos(String cpf);
    Servico getServicosEmAndamentos(String cpf);
}
