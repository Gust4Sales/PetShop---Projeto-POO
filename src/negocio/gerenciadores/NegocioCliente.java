package negocio.gerenciadores;

import dados.contratos.IRepositorioClientes;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.excecoes.ClienteInexistenteException;
import negocio.excecoes.ClienteJaCadastradoException;

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
        boolean existe = repositorioClientes.verificarCliente(cliente.getCpf());

        if (existe){
            cliente.setTelefone(telefone);
        } else {
            //excecao
        }
    }

    public Cliente consultarCliente(String cpf) throws ClienteInexistenteException{
            return this.repositorioClientes.getCliente(cpf);
    }

    public void adicionarPet(PetCliente pet){

    }

    public void removerPet(PetCliente pet){

    }

    public void alterarDivida(double divida){

    }
}
