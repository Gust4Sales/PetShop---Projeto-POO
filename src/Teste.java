import negocio.entidades.PetCliente;
import negocio.entidades.Produto;
import dados.contratos.IRepositorioProdutos;
import dados.RepositorioProdutosArray;

public class Teste {
    // Classe apenas de teste. A classe para executar o UI(ProjetoPoo) esta na gui por enquanto.
    public static void main(String[] args){
        IRepositorioProdutos repositorioProdutos = new RepositorioProdutosArray();
        Produto p1 = new Produto("Whiskas Sache", "Whiskas", 12.5, "15", 10);
        Produto p2 = new Produto("Shampoo AntiPulgas", "Jhonsons", 2.5, "09", 12);
        Produto p;
        //Cliente c = new Cliente("Joao", "702.504", "81994907920");
        PetCliente pet = new PetCliente("Hulk", "cachorro", "macho");
       // Servico s = new ServicoCompleto("7:30", c, pet);

        repositorioProdutos.adicionarProduto(p1);
        repositorioProdutos.adicionarProduto(p2);

        p = repositorioProdutos.getProduto("09");
        System.out.println(p);
        repositorioProdutos.removerProduto("09");
        p = repositorioProdutos.getProduto("09");
        System.out.println(p);

      //  s.setPreco(5.4);
       // System.out.printf("%f %s",s.getPreco(), s.getCliente().getNome() );

    }
}
