package entidades;

public class Agendamento {
    String data;
    String horário;
    int duração;
    Paciente paciente;
    Medico medicoResponsável;

    public Agendamento(String data, String horário, int duração, Paciente paciente, Medico medicoResponsável) {
        this.data = data;
        this.horário = horário;
        this.duração = duração;
        this.paciente = paciente;
        this.medicoResponsável = medicoResponsável;
    }

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorário() {
        return horário;
    }

    public void setHorário(String horário) {
        this.horário = horário;
    }

    public int getDuração() {
        return duração;
    }

    public void setDuração(int duração) {
        this.duração = duração;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedicoResponsável() {
        return medicoResponsável;
    }

    public void setMedicoResponsável(Medico medicoResponsável) {
        this.medicoResponsável = medicoResponsável;
    }
}
