package PetShop.dados.contratos;

import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

/**
 * Classe de interface para repositórios de cliente.
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public interface IRepositorioClientes {
    void adicionarCliente(Cliente cliente);
    boolean verificarCliente(String cpf);
    void atualizarCliente(Cliente cliente);
    Cliente getCliente(String cpf) throws ClienteInexistenteException;
}
