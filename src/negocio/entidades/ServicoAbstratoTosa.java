package negocio.entidades;

import negocio.contratos.ServicoAbstrato;

public class ServicoAbstratoTosa extends ServicoAbstrato {

    public ServicoAbstratoTosa(String horaAgendada, Cliente cliente, PetCliente pet) {
        super(horaAgendada, cliente, pet);
        this.preco = 25.50;
        this.concluido = false;
    }
}
