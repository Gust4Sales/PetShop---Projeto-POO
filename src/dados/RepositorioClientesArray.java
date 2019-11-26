package dados;

import dados.contratos.IRepositorioClientes;
import negocio.entidades.Cliente;
import negocio.excecoes.ClienteInexistenteException;

import java.util.ArrayList;

public class RepositorioClientesArray implements IRepositorioClientes {
    private ArrayList<Cliente> clientes;

    public RepositorioClientesArray(){
        clientes = new ArrayList<>();
    }
    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void removerCliente(String cpf) {

    }

    @Override
    public boolean verificarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (cpf.equals(c.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Cliente getCliente(String cpf) throws ClienteInexistenteException {
        for (Cliente c : this.clientes) {
            if (cpf.equals(c.getCpf())) {
                return c;
            }
        }
        throw new ClienteInexistenteException(cpf);
    }
}
