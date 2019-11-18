package negocio.entidades;

import negocio.contratos.Servico;

public class ServicoTosa extends Servico {

    public ServicoTosa(String horaAgendada, Cliente cliente, PetCliente pet) {
        super(horaAgendada, cliente, pet);
        this.preco = 25.50;
        this.concluido = false;
    }
}
