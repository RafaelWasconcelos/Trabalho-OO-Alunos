package entidades;

import java.util.List;

public class Consulta {
    private Agendamento agendamento;
    private String status;
    private List<Exame> examesPrescritos;
    private List<Medicamento> medicamentosPrescritos;
    private int valor;
    private Prescricao prescricaoAssociada;

    public Consulta(Agendamento agendamento, String status, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos, int valor, Prescricao prescricaoAssociada) {
        this.agendamento = agendamento;
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescricaoAssociada = prescricaoAssociada;

        // Associando consulta ao paciente e médico
        agendamento.getPaciente().getHistorico().addConsulta(this);
        agendamento.getMedicoResponsavel().getHistorico().addConsulta(this);
    }

    // Método para verificar se o paciente tem pagamento pendente
    public boolean verificarPagamentoPendente() {
        Paciente paciente = agendamento.getPaciente(); // Obtém o paciente associado ao agendamento
        if (paciente.temPagamentoPendente()) {
            System.out.println("Não é possível agendar. O paciente tem pagamentos pendentes.");
            return false;
        }
        System.out.println("Pagamento verificado. Agendamento permitido.");
        return true;
    }

    // Método de agendamento
    public boolean agendarConsulta() {
        if (verificarPagamentoPendente()) {
            this.status = "Agendada";
            System.out.println("Consulta agendada com sucesso.");
            return true;
        }
        return false;  // Pagamento pendente da erro
    }

    public void atualizarConsulta(String status, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos, int valor, Prescricao prescricaoAssociada) {
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescricaoAssociada = prescricaoAssociada;
    }

    public void deletarConsulta() {
        agendamento = null;
        status = null;
        examesPrescritos = null;
        medicamentosPrescritos = null;
        valor = 0;
        prescricaoAssociada = null;
    }

    public void lerConsulta() {
        System.out.println("Data: " + agendamento.getData());
        System.out.println("Horário: " + agendamento.getHorario());
        System.out.println("Duração: " + agendamento.getDuracao() + " min");
        System.out.println("Paciente: " + agendamento.getPaciente().getNome());
        System.out.println("Médico Responsável: " + agendamento.getMedicoResponsavel().getNome());
        System.out.println("Valor: " + valor);
        System.out.println("Status: " + status);

        System.out.println("Exames Prescritos:");
        for (Exame exame : examesPrescritos) {
            System.out.println("  Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescricao() + ", Custo: " + exame.getCusto());
        }

        System.out.println("Medicamentos Prescritos:");
        for (Medicamento medicamento : medicamentosPrescritos) {
            System.out.println("  Nome: " + medicamento.getNomeMedicamento());
        }
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Prescricao getPrescricaoAssociada() {
        return prescricaoAssociada;
    }

    public void setPrescricaoAssociada(Prescricao prescricaoAssociada) {
        this.prescricaoAssociada = prescricaoAssociada;
    }
}
