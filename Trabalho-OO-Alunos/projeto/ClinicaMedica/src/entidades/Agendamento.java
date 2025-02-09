package entidades;

public class Agendamento {
    String data;
    String horario;
    int duracao;
    Paciente paciente;
    Medico medicoResponsavel;

    public Agendamento(String data, String horario, int duracao, Paciente paciente, Medico medicoResponsavel) {
        this.data = data;
        this.horario = horario;
        this.duracao = duracao;
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
    }

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
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
}
