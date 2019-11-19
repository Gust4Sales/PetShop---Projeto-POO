package negocio.gerenciadores;

import dados.contratos.IRepositorioClientes;
import negocio.entidades.Cliente;

public class NegocioCliente {
    private IRepositorioClientes repositorioClientes;

    public NegocioCliente(IRepositorioClientes repo){
        this.repositorioClientes = repo;
    }

    public void adicionarCliente(Cliente cliente){
        // CLiente ja cadastrado EXcpe (CPF)
        boolean existe = repositorioClientes.isClienteCadastrado(cliente.getCpf());

        if (existe){
            // excecao
        } else {
            this.repositorioClientes.adicionarCliente(cliente);
        }
    }

    public void removerCliente(Cliente cliente){
        boolean existe = repositorioClientes.isClienteCadastrado(cliente.getCpf());

        if (existe){
            this.repositorioClientes.removerCliente(cliente.getCpf());
        } else {
            //exceção
        }
    }

    public void alterarTelCliente(Cliente cliente, String telefone){
        boolean existe = repositorioClientes.isClienteCadastrado(cliente.getCpf());

        if (existe){
            cliente.setTelefone(telefone);
        } else {
            //excecao
        }
    }
}
