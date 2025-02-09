package entidades;

import java.util.ArrayList;


public class Paciente extends Usuario {
	
	private ArrayList<Pagamento> pagamentos; 
	
    public Paciente(String nome, String dataNascimento, String cpf, HistoricoMedico historico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.historico = historico;
        
        this.pagamentos = new ArrayList<>();
    }

    
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // Método para verificar se há pagamento pendente
    public boolean temPagamentoPendente() {
        for (Pagamento pagamento : pagamentos) {
            if (!pagamento.isPago()) {
                return true;  // Existe um pagamento pendente
            }
        }
        return false;  // Todos os pagamentos estão pagos
    }
    
    
    @Override
    public void deletarCadastro() {
        setNome(null);
        setCpf(null);
        setDataNascimento(null);
        for (int i = 0; i < historico.getConsultas().length; i++) {
            if (historico.getConsultas()[i] != null) {
                historico.getConsultas()[i].deletarConsulta();
            }
        }
        for (int i = 0; i < historico.getExames().length; i++) {
            if (historico.getExames()[i] != null) {
                historico.getExames()[i].deletarExame();
            }
        }
    }

    @Override
    public void lerCadastro() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("CPF: " + cpf);
        System.out.println("Consultas no Histórico:");
        for (Consulta consulta : historico.getConsultas()) {
            if (consulta != null) {
                System.out.println("  Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorario() + ", Duração: " + consulta.getAgendamento().getDuracao() + " min, Médico: " + consulta.getAgendamento().getMedicoResponsavel().getNome() + ", Valor: " + consulta.getValor() + ", Status: " + consulta.getStatus());
            }
        }
        System.out.println("Exames no Histórico:");
        for (Exame exame : historico.getExames()) {
            if (exame != null) {
                System.out.println("  Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescricao() + ", Data de Realização: " + exame.getDataRealizacao() + ", Resultado: " + exame.getResultado() + ", Custo: " + exame.getCusto());
            }
        }
    }

    
    public void atualizarCadastro(String nome, String dataNascimento, String cpf, HistoricoMedico historico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.historico = historico;  // Atualiza também o histórico
    }
}
