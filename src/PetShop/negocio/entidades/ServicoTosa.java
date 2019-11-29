package PetShop.negocio.entidades;

import PetShop.negocio.contratos.ServicoAbstrato;

public class ServicoTosa extends ServicoAbstrato {

    public ServicoTosa(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 25.50;
        this.status = "Não concluído";
        this.descricao = "tosa";
    }
}
