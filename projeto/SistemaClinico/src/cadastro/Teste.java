package cadastro;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        // Criando pacientes e médicos
        Pacientes paciente1 = new Pacientes("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 20));
        Medico medico1 = new Medico("Dra. Maria Souza", "987.654.321-00", LocalDate.of(1980, 10, 15), "CRM12345", "Cardiologia");

        // Criando uma consulta
        Consultas consulta1 = new Consultas(LocalDate.of(2025, 1, 26), "14:30", medico1, paciente1, 150.00, "AGENDADA");

        // Adicionando a consulta ao paciente
        paciente1.adicionarConsulta(consulta1);

        System.out.println("Consulta marcada para " + paciente1.getNome() + " com o Dr. " + medico1.getNome());
    }
}
