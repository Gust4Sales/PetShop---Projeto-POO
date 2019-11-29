package PetShop.negocio.excecoes;

public class ClienteInexistenteException extends Exception {
    private String cpf;

    public ClienteInexistenteException(String cpf){
        super("Nenhum Cliente cadastrado no sistema com CPF: " + cpf);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

}
