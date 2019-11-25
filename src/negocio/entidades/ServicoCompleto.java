package negocio.entidades;

import negocio.contratos.ServicoAbstrato;

public class ServicoCompleto extends ServicoAbstrato {
    public ServicoCompleto(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 50;
        this.concluido = false;
        this.descricao = "completo";
    }

}
