package PetShop.dados;

import PetShop.dados.contratos.IRepositorioClientes;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

import java.util.ArrayList;
/**
 * Essa classe é reponsável por armazenar, e gerenciar a recuperação dos Clientes
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
    public boolean verificarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (cpf.equals(c.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void atualizarCliente(Cliente cliente){
        int index = this.clientes.indexOf(cliente);
        this.clientes.set(index, cliente);
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
