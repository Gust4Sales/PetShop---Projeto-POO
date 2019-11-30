package PetShop.negocio.excecoes;
/**
 * Classe de exceção que é lançada quando o usuário tenta cadastrar um cliente com cpf já cadastrado
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
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
