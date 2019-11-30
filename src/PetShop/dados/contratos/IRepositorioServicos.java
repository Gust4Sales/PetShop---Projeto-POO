package PetShop.dados.contratos;

import PetShop.negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;
/**
 * Classe de interface para repositórios de Serviços.
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public interface IRepositorioServicos {
    void adicionarServico(ServicoAbstrato servico);
    void removerServico(ServicoAbstrato servico);
    void atualizarServico(ServicoAbstrato servico);
    ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf);
    ArrayList<ServicoAbstrato> consultarServicosNaoConcluidos(String data);
    ArrayList<ServicoAbstrato> consultarServicosPorData(String data);
    ArrayList<ServicoAbstrato> consultarServicos();
}
