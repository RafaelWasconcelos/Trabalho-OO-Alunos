//package entidades;
//
//public class Médico extends Usuário {
//	String CRM;
//	String Especialidade; 
//	
//	public Médico(String nome,String dataNascimento,String cpf,String CRM, String Especialidade, HistoricoMedico historico) //C- create and U-update
//	{
//		this.nome = nome;
//		this.dataNascimento = dataNascimento; 
//		this.cpf=cpf;
//		this.CRM=CRM;
//		this.Especialidade=Especialidade; 
//		this.historico=historico; 
//	}
//
//	public void deletarCadastro() // D - delete
//	{
//		Médico.super.setCpf(null);
//		Médico.super.setNome(null);
//		Médico.super.setDataNascimento(null);
//		CRM = null;
//		Especialidade= null;
//		for(int i=0;i<historico.getConsultas().length;i++)
//		{
//			historico.getConsultas()[i]=null; 
//		}
//	}
//	public String getCRM() {
//		return CRM;
//	}
//	public void setCRM(String cRM) {
//		CRM = cRM;
//	}
//	public String getEspecialidade() {
//		return Especialidade;
//	}
//	public void setEspecialidade(String especialidade) {
//		Especialidade = especialidade;
//	}
//
//	@Override
//    public void lerCadastro() { // R - read
//        System.out.println("Nome: " + nome);
//        System.out.println("Data de Nascimento: " + dataNascimento);
//        System.out.println("CPF: " + cpf);
//        System.out.println("CRM: " + CRM);
//        System.out.println("Especialidade: " + Especialidade);
//	}
//
//	@Override
//	public void atualizarCadastro() {
//		this.nome = nome;
//		this.dataNascimento = dataNascimento; 
//		this.cpf=cpf;
//		this.CRM=CRM;
//		this.Especialidade=Especialidade; 
//		this.historico=historico; 
//	}
//	
//}

package entidades;

import java.time.LocalDateTime;
import java.util.List;

public class Medico extends Usuario {
    String CRM;
    String Especialidade;
    private List<Agendamento> consultasAgendadas;

    public Medico(String nome, String dataNascimento, String cpf, String CRM, String Especialidade, HistoricoMedico historico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.CRM = CRM;
        this.Especialidade = Especialidade;
        this.historico = historico;
    }

    @Override
    public void deletarCadastro() {
        Medico.super.setCpf(null);
        Medico.super.setNome(null);
        Medico.super.setDataNascimento(null);
        CRM = null;
        Especialidade = null;
        for (int i = 0; i < historico.getConsultas().length; i++) {
            if (historico.getConsultas()[i] != null) {
                historico.getConsultas()[i] = null;
            }
        }
    }

    public boolean temEspecialidade(String especialidade) {
        return this.Especialidade.equalsIgnoreCase(especialidade);
    }

    public boolean consultaDisponivelNoHorario(LocalDateTime dataConsulta, String horaInicio) {
        for (Agendamento agendamento : consultasAgendadas) {
            if (agendamento.getData().equals(dataConsulta) && agendamento.getHorário().equals(horaInicio)) {
                return false;  // Horário já ocupado
            }
        }
        return true;  // Horário disponível

    }

    @Override
    public void lerCadastro() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("CPF: " + cpf);
        System.out.println("CRM: " + CRM);
        System.out.println("Especialidade: " + Especialidade);
        System.out.println("Consultas no Histórico:");
        for (Consulta consulta : historico.getConsultas()) {
            if (consulta != null) {
                System.out.println("  Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorário() + ", Duração: " + consulta.getAgendamento().getDuração() + " min, Paciente: " + consulta.getAgendamento().getPaciente().getNome() + ", Valor: " + consulta.getValor() + ", Status: " + consulta.getStatus());
            }
        }
    }

    public void atualizarCadastro(String nome, String dataNascimento, String cpf, String CRM, String especialidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.CRM = CRM;
        this.Especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String especialidade) {
        Especialidade = especialidade;
    }
}


