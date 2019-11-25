package negocio.entidades;

import negocio.contratos.ServicoAbstrato;

public class ServicoBanho extends ServicoAbstrato {

    public ServicoBanho(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 25.50;
        this.concluido = false;
        this.descricao = "banho";
    }


}
