package dados.contratos;

import negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;

public interface IRepositorioServicos {
    void adicionarServico(ServicoAbstrato servico);
    void removerServico(ServicoAbstrato servico);
    void atualizarServico(ServicoAbstrato servico);
    ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf);

}
