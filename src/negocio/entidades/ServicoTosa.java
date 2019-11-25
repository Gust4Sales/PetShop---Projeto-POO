package negocio.entidades;

import negocio.contratos.ServicoAbstrato;

public class ServicoTosa extends ServicoAbstrato {

    public ServicoTosa(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 25.50;
        this.concluido = false;
        this.descricao = "tosa";
    }
}
