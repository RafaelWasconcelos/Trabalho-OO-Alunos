package entidades;

import java.util.List;
import java.util.ArrayList;

public class Paciente extends Usuario {
    private HistoricoMedico historicoMedico;
    private List<Pagamento> pagamentos;
    private List<Consulta> consultasAgendadas;
    

    public Paciente(String nome, String dataNascimento, String cpf, HistoricoMedico historicoMedico) {
        super(nome, dataNascimento, cpf, historicoMedico);
        this.historicoMedico = historicoMedico;
        this.consultasAgendadas = new ArrayList<>();
        this.pagamentos = new ArrayList<>(); 
    }

    @Override
    public void deletarCadastro() {
        setNome(null);
        setCpf(null);
        setDataNascimento(null);
        
        // Deletar consultas do histórico
        if (historicoMedico != null) {
            for (Consulta consulta : historicoMedico.getConsultas()) {
                if (consulta != null) {
                    consulta.deletarConsulta();
                }
            }
            
            // Deletar exames
            for (Exame exame : historicoMedico.getExames()) {
                if (exame != null) {
                    exame.deletarExame();
                }
            }
        }
    }

    public void adicionarConsulta(Consulta consulta) {
    if (consulta != null) {
        if (this.historicoMedico == null) {
            this.historicoMedico = new HistoricoMedico();
        }
        this.historicoMedico.adicionarConsulta(consulta); // Adiciona ao histórico médico
        this.consultasAgendadas.add(consulta); // Adiciona à lista local de consultas agendadas
    }
}



    public HistoricoMedico getHistoricoMedico() {
        return historicoMedico;
    }

    
    public void lerCadastro() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("CPF: " + getCpf());
        
        System.out.println("Consultas no Histórico:");
        if (historicoMedico != null) {
            for (Consulta consulta : historicoMedico.getConsultas()) {
                if (consulta != null) {
                    System.out.println("  Data: " + consulta.getAgendamento().getData() +
                            ", Horário: " + consulta.getAgendamento().getHorario() +
                            ", Duração: " + consulta.getAgendamento().getDuracao() + " min" +
                            ", Médico: " + consulta.getAgendamento().getMedicoResponsavel().getNome() +
                            ", Valor: " + consulta.getValor() + ", Status: " + consulta.getStatus());
                }
            }

            System.out.println("Exames no Histórico:");
            for (Exame exame : historicoMedico.getExames()) {
                if (exame != null) {
                    System.out.println("  Tipo: " + exame.getTipo() +
                            ", Data da Prescrição: " + exame.getDataPrescricao() +
                            ", Data de Realização: " + exame.getDataRealizacao() +
                            ", Resultado: " + exame.getResultado() +
                            ", Custo: " + exame.getCusto());
                }
            }
        }
    }

    public boolean temPagamentoPendente() {
        for (Pagamento pagamento : pagamentos) {
            if (!pagamento.isPago()) {
                return true;  // Existe pagamento pendente
            }
        }
        return false;  // Nenhum pagamento pendente
    }

    public void atualizarCadastro(String nome, String dataNascimento, String cpf) {
        setNome(nome);
        setDataNascimento(dataNascimento);
        setCpf(cpf);
    }

    public List<Consulta> getConsultas(){
        return consultasAgendadas;
    }
}
