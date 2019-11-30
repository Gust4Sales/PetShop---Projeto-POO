package PetShop.negocio.gerenciadores;

import PetShop.dados.contratos.IRepositorioClientes;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.entidades.PetCliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;
import PetShop.negocio.excecoes.ClienteJaCadastradoException;

import java.util.ArrayList;
/**
 * Essa classe aplica as regras de negócio e o gerenciamento do Cliente no sistema
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class NegocioCliente {
    private IRepositorioClientes repositorioClientes;

    public NegocioCliente(IRepositorioClientes repo){
        this.repositorioClientes = repo;
    }

    public void adicionarCliente(Cliente cliente) throws ClienteJaCadastradoException{
        boolean existe = repositorioClientes.verificarCliente(cliente.getCpf());

        if (existe){
            throw new ClienteJaCadastradoException(cliente.getCpf());
        } else {
            this.repositorioClientes.adicionarCliente(cliente);
        }
    }

    public void alterarTelCliente(Cliente cliente, String telefone){
        cliente.setTelefone(telefone);
        this.repositorioClientes.atualizarCliente(cliente);
    }

    public Cliente consultarCliente(String cpf) throws ClienteInexistenteException{
            return this.repositorioClientes.getCliente(cpf);
    }

    public void alterarListaPets(Cliente cliente, ArrayList<PetCliente> pets){
        cliente.setPets(pets);
        this.repositorioClientes.atualizarCliente(cliente);
    }

}
