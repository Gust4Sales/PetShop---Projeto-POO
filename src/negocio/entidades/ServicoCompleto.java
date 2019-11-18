package negocio.entidades;

import negocio.contratos.Servico;

public class ServicoCompleto extends Servico {
    public ServicoCompleto(String horaAgendada, Cliente cliente, PetCliente pet) {
        super(horaAgendada, cliente, pet);
        this.preco = 50;
        this.concluido = false;
    }

}
