package PetShop.negocio.gerenciadores;

import PetShop.dados.contratos.IRepositorioClientes;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.entidades.PetCliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;
import PetShop.negocio.excecoes.ClienteJaCadastradoException;

import java.util.ArrayList;

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

    public void removerCliente(Cliente cliente){
        boolean existe = repositorioClientes.verificarCliente(cliente.getCpf());

        if (existe){
            this.repositorioClientes.removerCliente(cliente.getCpf());
        } else {
            //exceção
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

    public void removerPet(PetCliente pet){

    }

    public void alterarDivida(double divida){

    }
}
