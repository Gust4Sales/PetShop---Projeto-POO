package negocio.contratos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class VendaAbstrata {
    protected String hora;
    protected String data;

    public VendaAbstrata(){
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat dFormatada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hFormatada = new SimpleDateFormat("hh:mm");
        // Hora e Data atual do sistema.

        this.hora = hFormatada.format(data);
        this.data = dFormatada.format(data);
    }
}
