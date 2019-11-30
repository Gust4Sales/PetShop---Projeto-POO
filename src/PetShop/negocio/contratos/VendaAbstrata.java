package PetShop.negocio.contratos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Classe abstrata que representa as Vendas do sistema de forma geral
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public abstract class VendaAbstrata {
    protected String hora;
    protected String data;

    public VendaAbstrata(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR,-1);
        Date data = c.getTime();
        SimpleDateFormat dFormatada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hFormatada = new SimpleDateFormat("HH:mm");
        // Hora e Data atual do sistema.

        this.hora = hFormatada.format(data);
        this.data = dFormatada.format(data);
    }

    public String getData() {
        return this.data;
    }

    public String getHora() {
        return this.hora;
    }

}
