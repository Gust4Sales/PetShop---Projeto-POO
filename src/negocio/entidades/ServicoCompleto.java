package negocio.entidades;

import negocio.contratos.ServicoAbstrato;

public class ServicoCompleto extends ServicoAbstrato {
    public ServicoCompleto(String horaAgendada, Cliente cliente, PetCliente pet) {
        super(horaAgendada, cliente, pet);
        this.preco = 50;
        this.concluido = false;
    }

}
