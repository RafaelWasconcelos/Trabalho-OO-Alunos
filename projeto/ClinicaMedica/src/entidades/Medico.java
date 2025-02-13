package entidades;

import java.time.LocalDateTime;
import java.util.List;

public class Medico extends Usuario {
    private String CRM;
    private String especialidade;
    private List<Agendamento> consultasAgendadas;

    // Construtor corrigido
    public Medico(String nome, String dataNascimento, String cpf, String CRM, String especialidade, HistoricoMedico historico) {
        super(nome, dataNascimento, cpf, historico);
        this.CRM = CRM;
        this.especialidade = especialidade;
    }

    // Método de deletar cadastro corrigido
    @Override
    public void deletarCadastro() {
        super.setNome(null);
        super.setCpf(null);
        super.setDataNascimento(null);
        this.CRM = null;
        this.especialidade = null;
        
        if (historico != null && historico.getConsultas() != null) {
            historico.getConsultas().clear(); // Remove todas as consultas do histórico
        }
    }

    // Verificar se o médico tem a especialidade desejada
    public boolean temEspecialidade(String especialidade) {
        return this.especialidade != null && this.especialidade.equalsIgnoreCase(especialidade);
    }

    // Verificar disponibilidade de consulta no horário corrigido
    public boolean consultaDisponivelNoHorario(LocalDateTime dataConsulta, String horaInicio) {
        if (dataConsulta == null || horaInicio == null) {
            return false;  // Dados inválidos
        }
        
        for (Agendamento agendamento : consultasAgendadas) {
            if (agendamento.getData().equals(dataConsulta) && agendamento.getHorario().equals(horaInicio)) {
                return false;  // Horário já ocupado
            }
        }
        return true;  // Horário disponível
    }

    // Método de leitura do cadastro do médico
    @Override
    public void lerCadastro() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("CPF: " + getCpf());
        System.out.println("CRM: " + CRM);
        System.out.println("Especialidade: " + especialidade);
    }

    // Getters e Setters
    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Agendamento> getConsultasAgendadas() {
        return consultasAgendadas;
    }

    public void setConsultasAgendadas(List<Agendamento> consultasAgendadas) {
        this.consultasAgendadas = consultasAgendadas;
    }
}
