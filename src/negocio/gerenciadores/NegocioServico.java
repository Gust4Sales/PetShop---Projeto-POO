package negocio.gerenciadores;

import dados.contratos.IRepositorioServicos;
import negocio.contratos.ServicoAbstrato;

import java.util.ArrayList;

public class NegocioServico {
    private IRepositorioServicos agenda;

    public NegocioServico(IRepositorioServicos agenda){
        this.agenda = agenda;
    }

    public void adicionarServico(ServicoAbstrato servico){
        this.agenda.adicionarServico(servico);
    }

    public void removerServico(ServicoAbstrato servico){
        this.agenda.removerServico(servico);
    }

    public ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf){
        return this.agenda.consultarServicosCliente(cpf);
    }

}
