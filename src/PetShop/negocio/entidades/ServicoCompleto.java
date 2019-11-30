package PetShop.negocio.entidades;

import PetShop.negocio.contratos.ServicoAbstrato;
/**
 * Essa classe representa o Serviço completo que é oferecido pelo Petshop
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class ServicoCompleto extends ServicoAbstrato {
    public ServicoCompleto(String horaAgendada, String data, Cliente cliente, PetCliente pet) {
        super(horaAgendada, data, cliente, pet);
        this.preco = 45.00;
        this.status = "Não concluído";
        this.descricao = "completo";
    }

}
