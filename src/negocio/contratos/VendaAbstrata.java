package negocio.contratos;

public abstract class VendaAbstrata {
    protected String hora;
    protected String data;

    public VendaAbstrata(){
        this.hora = "8:00";
        this.data = "11/11";
    }
}
