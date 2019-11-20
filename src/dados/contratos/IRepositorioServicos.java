package dados.contratos;

import negocio.contratos.ServicoAbstrato;

public interface IRepositorioServicos {
    void adicionarServico(ServicoAbstrato servicoAbstrato);
    void removerServico(String id);
    ServicoAbstrato getServicosConcluidos(String cpf);
    ServicoAbstrato getServicosEmAndamentos(String cpf);
}
