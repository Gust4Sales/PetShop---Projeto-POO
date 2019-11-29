package PetShop.dados.contratos;

import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

public interface IRepositorioClientes {
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    boolean verificarCliente(String cpf);
    void atualizarCliente(Cliente cliente);
    Cliente getCliente(String cpf) throws ClienteInexistenteException;
}
