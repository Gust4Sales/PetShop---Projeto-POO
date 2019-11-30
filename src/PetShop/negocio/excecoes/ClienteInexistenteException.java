package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando não é encontrado cliente com esse cpf
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
