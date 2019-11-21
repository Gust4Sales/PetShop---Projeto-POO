package negocio.gerenciadores;

import dados.contratos.IRepositorioClientes;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;

public class NegocioCliente {
    private IRepositorioClientes repositorioClientes;

    public NegocioCliente(IRepositorioClientes repo){
        this.repositorioClientes = repo;
    }

    public void cadastrarCliente(Cliente cliente){
        // CLiente ja cadastrado EXcpe (CPF)
        boolean existe = repositorioClientes.buscarCliente(cliente.getCpf());

        if (existe){
            // excecao
        } else {
            this.repositorioClientes.adicionarCliente(cliente);
        }
    }

    public void removerCliente(Cliente cliente){
        boolean existe = repositorioClientes.buscarCliente(cliente.getCpf());

        if (existe){
            this.repositorioClientes.removerCliente(cliente.getCpf());
        } else {
            //exceção
        }
    }

    public void alterarTelCliente(Cliente cliente, String telefone){
        boolean existe = repositorioClientes.buscarCliente(cliente.getCpf());

        if (existe){
            cliente.setTelefone(telefone);
        } else {
            //excecao
        }
    }

    public void adicionarPet(PetCliente pet){

    }

    public void removerPet(PetCliente pet){

    }

    public void alterarDivida(double divida){

    }
}
