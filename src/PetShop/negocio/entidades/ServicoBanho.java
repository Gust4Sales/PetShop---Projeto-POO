package PetShop.negocio.entidades;

import PetShop.negocio.contratos.ServicoAbstrato;
/**
 * Essa classe representa o Serviço banho que é oferecido pelo Petshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class ServicoBanho extends ServicoAbstrato {

    public ServicoBanho(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 25.00;
        this.status = "Não concluído";
        this.descricao = "banho";
    }


}
