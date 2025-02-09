package main;  // 

import entidades.*;

public class Main {
    public static void main(String[] args) {
        
        Medico medico = new Medico("Dr. Silva", "1975-05-20", "051344374", "051344374", "Cardiologista", new HistoricoMedico());

        // Criando um paciente com histórico médico
        Paciente paciente = new Paciente("João da Silva", "1990-06-15", "12345678900", new HistoricoMedico());

        // Criando um pagamento pendente para o paciente (caso a lógica esteja implementada na classe Paciente)
        Pagamento pagamento = new Pagamento(100.0, "Cartão");
        paciente.adicionarPagamento(pagamento);

        // Criando o agendamento
        Agendamento agendamento = new Agendamento("2025-02-15", "10:00", 30, paciente, medico);

      
        // Para o exemplo atual, vamos apenas imprimir os detalhes
        System.out.println("Agendamento Criado:");
        System.out.println("Data: " + agendamento.getData());
        System.out.println("Horário: " + agendamento.getHorario());
        System.out.println("Duração: " + agendamento.getDuracao() + " min");
        System.out.println("Paciente: " + agendamento.getPaciente().getNome());
        System.out.println("Médico: " + agendamento.getMedicoResponsavel().getNome());
    }
}
