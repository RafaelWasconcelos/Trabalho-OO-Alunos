package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Notificacao {
    public static void enviarNotificacao(Paciente paciente, Consulta consulta) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataConsulta = consulta.getAgendamento().getData(); // Supondo que haja um método getData()

        long diasParaConsulta = ChronoUnit.DAYS.between(hoje, dataConsulta);

        if (diasParaConsulta > 0 && diasParaConsulta <= 3) {
            System.out.println("📢 Notificação: Olá " + paciente.getNome() +
                               ", sua consulta está marcada para " + dataConsulta + 
                               ". Não se esqueça!");
        }
    }

    public static void verificarConsultasProximas(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            for (Consulta consulta : paciente.getConsultas()) { // Supondo que o paciente tenha uma lista de consultas
                enviarNotificacao(paciente, consulta);
            }
        }
    }
}

