package main.java.map.Ordenacao;
import java.time.Month;
import java.util.*;
import java.time.LocalDate;

public class AgendaEventos {
    //atributo
    private Map<LocalDate, Evento> eventosMap;
    public AgendaEventos() {this.eventosMap = new HashMap<>();}

    public void adicionarEventos(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }
    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }
    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(var entry: eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey(); //data é a key
                proximoEvento = entry.getValue(); //evento é o value
                System.out.println("O próximo evento: " + entry.getValue()+"acontecerá na data "+entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEventos(LocalDate.of(2025, 5, 30), "Evento 1", "Atração 1");
        agendaEventos.adicionarEventos(LocalDate.of(2025, 7, 15), "Evento 2", "Atração 2");
        agendaEventos.adicionarEventos(LocalDate.of(2000, 1, 7), "Evento 3", "Atração 3");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }

}
