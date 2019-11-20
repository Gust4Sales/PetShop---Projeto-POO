package dados;

import dados.contratos.IRepositorioClientes;
import negocio.entidades.Cliente;

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
    public boolean buscarCliente(String cpf) {
        return false;
    }

    @Override
    public Cliente getCliente(String cpf) {
        return null;
    }
}
