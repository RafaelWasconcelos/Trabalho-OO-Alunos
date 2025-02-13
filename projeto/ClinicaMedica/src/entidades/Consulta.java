package entidades;

import java.util.List;

public class Consulta {
    private Agendamento agendamento;
    private Pagamento pagamento;
    private Prescricao prescricao;
    private Paciente paciente;
    private String status;
    private List<Exame> examesPrescritos;
    private List<Medicamento> medicamentosPrescritos;
    private double valor;
    private Prescricao prescricaoAssociada;

    // Construtor
    public Consulta(Agendamento agendamento, String status, List<Exame> examesPrescritos,
                    List<Medicamento> medicamentosPrescritos, double valor, Prescricao prescricaoAssociada) {
        this.agendamento = agendamento;
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescricaoAssociada = prescricaoAssociada;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Consulta() {
        this.prescricao = new Prescricao(); 
    }
    
    

    // Atualizar os dados da consulta
    public void atualizarConsulta(String status, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos,
                                  double valor, Prescricao prescricaoAssociada) {
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescricaoAssociada = prescricaoAssociada;
    }

    // Método para deletar a consulta
    public void deletarConsulta() {
        agendamento = null;
        status = null;
        if (examesPrescritos != null) {
            examesPrescritos.clear();
        }
        if (medicamentosPrescritos != null) {
            medicamentosPrescritos.clear();
        }
        valor = 0;
        prescricaoAssociada = null;
    }

    // Ler informações da consulta
    public void lerConsulta() {
        if (agendamento == null) {
            System.out.println("Nenhum agendamento disponível.");
            return;
        }

        System.out.println("Data: " + (agendamento.getData() != null ? agendamento.getData() : "Não disponível"));
        System.out.println("Horário: " + (agendamento.getHorario() != null ? agendamento.getHorario() : "Não disponível"));
        System.out.println("Duração: " + agendamento.getDuracao() + " min");

        if (agendamento.getPaciente() != null) {
            System.out.println("Paciente: " + agendamento.getPaciente().getNome());
        }

        if (agendamento.getMedicoResponsavel() != null) {
            System.out.println("Médico Responsável: " + agendamento.getMedicoResponsavel().getNome());
        }

        System.out.println("Valor: " + valor);
        System.out.println("Status: " + (status != null ? status : "Não informado"));

        if (examesPrescritos != null && !examesPrescritos.isEmpty()) {
            System.out.println("Exames Prescritos:");
            for (Exame exame : examesPrescritos) {
                System.out.println("  Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescricao() + ", Custo: " + exame.getCusto());
            }
        } else {
            System.out.println("Nenhum exame prescrito.");
        }

        if (medicamentosPrescritos != null && !medicamentosPrescritos.isEmpty()) {
            System.out.println("Medicamentos Prescritos:");
            for (Medicamento medicamento : medicamentosPrescritos) {
                System.out.println("  Nome: " + medicamento.getNomeMedicamento());
            }
        } else {
            System.out.println("Nenhum medicamento prescrito.");
        }
    }

    // Atualizar apenas o status da consulta
    public void atualizarStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Exame> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(List<Exame> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public List<Medicamento> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(List<Medicamento> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Prescricao getPrescricaoAssociada() {
        return prescricaoAssociada;
    }

    public void setPrescricaoAssociada(Prescricao prescricaoAssociada) {
        this.prescricaoAssociada = prescricaoAssociada;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }


    public Pagamento getPagamento() { // Criamos este método
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) { // Criamos este método
        this.pagamento = pagamento;
    }

    public Consulta(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
}
