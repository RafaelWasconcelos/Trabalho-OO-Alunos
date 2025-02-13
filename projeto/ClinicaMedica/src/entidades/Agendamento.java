package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    private LocalDate data;
    private LocalTime horario;
    private int duracao; // Em minutos
    private Paciente paciente;
    private Medico medicoResponsavel;

    // Construtor
    public Agendamento(LocalDate data, LocalTime horario, int duracao, Paciente paciente, Medico medicoResponsavel) {
        this.data = data;
        this.horario = horario;
        this.duracao = duracao;
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    // Método para exibir as informações do agendamento
    public void exibirAgendamento() {
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico Responsável: " + medicoResponsavel.getNome());
    }
}
