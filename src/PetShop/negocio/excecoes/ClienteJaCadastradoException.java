package PetShop.negocio.excecoes;

public class ClienteJaCadastradoException extends Exception {
    private String cpf;

    public ClienteJaCadastradoException(String cpf){
        super("Cliente já está cadastrado com CPF: " + cpf);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }
}
