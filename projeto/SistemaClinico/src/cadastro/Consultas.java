package cadastro;


import java.time.LocalDate;

public class Consultas {
    private LocalDate data;
    private String horario;
    private Medico medico;
    private Pacientes paciente;
    private double valor;
    private String status;

    public Consultas(LocalDate data, String horario, Medico medico, Pacientes paciente, double valor, String status) {
        this.data = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.valor = valor;
        this.status = status;
    }
}
