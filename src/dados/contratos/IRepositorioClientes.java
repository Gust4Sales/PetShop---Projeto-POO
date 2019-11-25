package dados.contratos;

import negocio.entidades.Cliente;

import java.util.ArrayList;

public interface IRepositorioClientes {
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    boolean verificarCliente(String cpf);
    Cliente getCliente(String cpf);
}
