import negocio.entidades.Produto;
import dados.contratos.IRepositorioProdutos;
import dados.RepositorioProdutosArray;

public class Teste {
    public static void main(String[] args){
        IRepositorioProdutos repositorioProdutos = new RepositorioProdutosArray();
        Produto p1 = new Produto("Whiskas Sache", "Whiskas", 12.5, "15", 10);
        Produto p2 = new Produto("Shampoo AntiPulgas", "Jhonsons", 2.5, "09", 12);
        Produto p;

        repositorioProdutos.adicionarProduto(p1);
        repositorioProdutos.adicionarProduto(p2);

        p = repositorioProdutos.getProduto("09");
        System.out.println(p);
        repositorioProdutos.removerProduto("09");
        p = repositorioProdutos.getProduto("09");
        System.out.println(p);

    }
}
