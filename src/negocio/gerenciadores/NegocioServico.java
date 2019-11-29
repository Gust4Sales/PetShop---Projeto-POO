package negocio.gerenciadores;

import dados.contratos.IRepositorioServicos;
import negocio.contratos.ServicoAbstrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NegocioServico {
    private IRepositorioServicos agenda;

    public NegocioServico(IRepositorioServicos agenda){
        this.agenda = agenda;
    }

    public void adicionarServico(ServicoAbstrato servico){
        this.agenda.adicionarServico(servico);
    }

    public void removerServico(ServicoAbstrato servico){
        this.agenda.removerServico(servico);
    }

    public void marcarServicoConcluido(ServicoAbstrato s){
        s.concluirStatus();
        this.agenda.atualizarServico(s);
    }

    public ArrayList<ServicoAbstrato> consultarServicosCliente(String cpf){
        return this.agenda.consultarServicosCliente(cpf);
    }

    public ArrayList<ServicoAbstrato> consultarServicosClienteConcluidos(String cpf){
        ArrayList<ServicoAbstrato> servicosCliente = this.agenda.consultarServicosCliente(cpf);
        ArrayList<ServicoAbstrato> servicosClienteConcluidos = new ArrayList<>();

        for (ServicoAbstrato s: servicosCliente){
            if (s.getStatus().equals("Concluído")){
                servicosClienteConcluidos.add(s);
            }
        }
        return servicosClienteConcluidos;
    }

    public ArrayList<ServicoAbstrato> consultarServicosClienteNaoConcluidos(String cpf){
        ArrayList<ServicoAbstrato> servicosCliente = this.agenda.consultarServicosCliente(cpf);
        ArrayList<ServicoAbstrato> servicos = new ArrayList<>();

        for (ServicoAbstrato s: servicosCliente){
            if (s.getStatus().equals("Não concluído")){
                servicos.add(s);
            }
        }
        return servicos;
    }

    public ArrayList<String> consultarHorariosDisponiveisPorData(String data){
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfDataComp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        GregorianCalendar gc = new GregorianCalendar();

        gc.setTime(new Date());
        gc.add(Calendar.HOUR,-1);
        String dataAtual = sdfData.format(gc.getTime());

        ArrayList<ServicoAbstrato> lista = this.agenda.consultarServicosNaoConcluidos(data);

        ArrayList<String> listaHoras = new ArrayList<String>(Arrays.asList("08:00", "08:30", "09:00", "09:30",
                "10:00","10:30","11:00","11:30","14:00","14:30","15:00","15:30","16:00","16:30"));

        GregorianCalendar horaDoServico = new GregorianCalendar();
        GregorianCalendar horaTemp = new GregorianCalendar();
        ArrayList<String> horasRemovidasTemp = new ArrayList<>();

        if (data.equals(dataAtual)) {
            for (String hora : listaHoras) {
                try {
                    horaTemp.setTime(sdfDataComp.parse(dataAtual + " " + hora));
                    if (horaTemp.getTime().before(gc.getTime())) {
                        horasRemovidasTemp.add(hora);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            for (String hora : horasRemovidasTemp){
                listaHoras.remove(hora);
            }
        }

        if (!lista.isEmpty() && !listaHoras.isEmpty()) {
            for (ServicoAbstrato servico : lista) {
                try {
                    horaDoServico.setTime(sdfDataComp.parse(servico.getData() + " " + servico.getHoraAgendada()));
                    if (servico.getDescricao().equals("completo")) {
                        if (listaHoras.contains(servico.getHoraAgendada())){
                            int index = listaHoras.indexOf(servico.getHoraAgendada());
                            listaHoras.remove(index);
                            listaHoras.remove(index);
                        } else {
                            int index = listaHoras.indexOf(servico.getHoraAgendada()) + 1;
                            listaHoras.remove(index);
                        }
                    } else if (!servico.getDescricao().equals("completo") && listaHoras.contains(servico.getHoraAgendada())) {
                        listaHoras.remove(servico.getHoraAgendada());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        return listaHoras;
    }

    public ArrayList<ServicoAbstrato> consultarServicos(){
        return this.agenda.consultarServicos();
    }

    public ArrayList<ServicoAbstrato> consultarServicosPorData(String data){
        return this.agenda.consultarServicosPorData(data);
    }

    public ArrayList<ServicoAbstrato> consultarServicosClientePorData(String cpf, String data){
        ArrayList<ServicoAbstrato> servicosPorData =  this.agenda.consultarServicosPorData(data);
        ArrayList<ServicoAbstrato> servicosClientePorData = new ArrayList<>();

        for (ServicoAbstrato s: servicosPorData){
            if (s.getCliente().getCpf().equals(cpf)){
                servicosClientePorData.add(s);
            }
        }

        return servicosClientePorData;
    }

}
