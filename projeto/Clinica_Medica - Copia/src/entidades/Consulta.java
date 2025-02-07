//package entidades; 
//
//public class Consulta  {
//	
//	String data,horário,status;
//	int duração; 
//	Paciente paciente; 
//	Médico medicoResponsável; 
//	int valor;
//	Prescrição prescriçãoRelacionada; 
//	
//	public Consulta()
//	{
//		
//	}
//	
//	public Consulta(String data, String horário, int duração, Paciente paciente,
//			Médico medicoResponsável, int valor) {                                 // C - create and U - update
//		this.data = data;
//		this.horário = horário;
//		this.duração = duração;
//		this.paciente = paciente;
//		this.medicoResponsável = medicoResponsável;
//		this.valor = valor;
//		
//		
//		this.paciente.getHistorico().getConsulta().setData(data);  // na main do secretario cada consultas[] vai receber consulta
//		this.paciente.getHistorico().getConsulta().setHorário(horário);
//		this.paciente.getHistorico().getConsulta().setDuração(duração);
//		this.paciente.getHistorico().getConsulta().setPaciente(paciente);
//		this.paciente.getHistorico().getConsulta().setMedicoResponsável(medicoResponsável);
//		this.paciente.getHistorico().getConsulta().setValor(valor);
//		
//		this.medicoResponsável.getHistorico().getConsulta().setData(data);  // na main do secretario cada consultas[] vai receber consulta
//		this.medicoResponsável.getHistorico().getConsulta().setHorário(horário);
//		this.medicoResponsável.getHistorico().getConsulta().setDuração(duração);
//		this.medicoResponsável.getHistorico().getConsulta().setPaciente(paciente);
//		this.medicoResponsável.getHistorico().getConsulta().setMedicoResponsável(medicoResponsável);
//		this.medicoResponsável.getHistorico().getConsulta().setValor(valor);
//		
//		
//	}
//	public void deletarConsulta() { // D
//        if (this.data != null) {
//            this.data = null;
//        }
//        if (this.horário != null) {
//            this.horário = null;
//        }
//        this.duração = 0;
//        if (this.paciente != null) {
//            this.paciente = null;
//        }
//        if (this.medicoResponsável != null) {
//            this.medicoResponsável = null;
//        }
//        this.valor = 0;
//        if (this.prescriçãoRelacionada != null) {
//            this.prescriçãoRelacionada = null;
//        }
//    }
//	
//	public void lerConsulta() { // R - read
//        System.out.println("Data: " + data);
//        System.out.println("Horário: " + horário);
//        System.out.println("Duração: " + duração);
//        System.out.println("Paciente: " + paciente.getNome());
//        System.out.println("Médico Responsável: " + medicoResponsável.getNome());
//        System.out.println("Valor: " + valor);
//	}
//
//	public void atualizarConsulta(String data, String horário, int duração, Paciente paciente, Médico medicoResponsável, int valor) { // U
//	    this.data = data;
//	    this.horário = horário;
//	    this.duração = duração;
//	    this.paciente = paciente;
//	    this.medicoResponsável = medicoResponsável;
//	    this.valor = valor;
//	}
//		
//	
//	
//	public String getData() {
//		return data;
//	}
//	public void setData(String data) {
//		this.data = data;
//	}
//	public String getHorário() {
//		return horário;
//	}
//	public void setHorário(String horário) {
//		this.horário = horário;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public int getDuração() {
//		return duração;
//	}
//	public void setDuração(int duração) {
//		this.duração = duração;
//	}
//	public Paciente getPaciente() {
//		return paciente;
//	}
//	public void setPaciente(Paciente paciente) {
//		this.paciente = paciente;
//	}
//	public Médico getMedicoResponsável() {
//		return medicoResponsável;
//	}
//	public void setMedicoResponsável(Médico medicoResponsável) {
//		this.medicoResponsável = medicoResponsável;
//	}
//	public int getValor() {
//		return valor;
//	}
//	public void setValor(int valor) {
//		this.valor = valor;
//	}
//
//	public Prescrição getPrescriçãoRelacionada() {
//		return prescriçãoRelacionada;
//	}
//
//	public void setPrescriçãoRelacionada(Prescrição prescriçãoRelacionada) {
//		this.prescriçãoRelacionada = prescriçãoRelacionada;
//	}
//	
//	
//	
//	
//}

package entidades;

import java.util.List;

public class Consulta {
    Agendamento agendamento;
    String status;
    List<Exame> examesPrescritos;
    List<Medicamento> medicamentosPrescritos;
    int valor;
    Prescricao prescriçãoAssociada;

    public Consulta(Agendamento agendamento, String status, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos, int valor, Prescricao prescriçãoAssociada) {
        this.agendamento = agendamento;
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescriçãoAssociada = prescriçãoAssociada;
    }

    public void atualizarConsulta(String status, List<Exame> examesPrescritos, List<Medicamento> medicamentosPrescritos, int valor, Prescricao prescriçãoAssociada) {
        this.status = status;
        this.examesPrescritos = examesPrescritos;
        this.medicamentosPrescritos = medicamentosPrescritos;
        this.valor = valor;
        this.prescriçãoAssociada = prescriçãoAssociada;
    }

    public void deletarConsulta() {
        agendamento = null;
        status = null;
        examesPrescritos = null;
        medicamentosPrescritos = null;
        valor = 0;
        prescriçãoAssociada = null;
    }

    public void lerConsulta() {
        System.out.println("Data: " + agendamento.getData());
        System.out.println("Horário: " + agendamento.getHorário());
        System.out.println("Duração: " + agendamento.getDuração() + " min");
        System.out.println("Paciente: " + agendamento.getPaciente().getNome());
        System.out.println("Médico Responsável: " + agendamento.getMedicoResponsável().getNome());
        System.out.println("Valor: " + valor);
        System.out.println("Status: " + status);

        System.out.println("Exames Prescritos:");
        for (Exame exame : examesPrescritos) {
            System.out.println("  Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescrição() + ", Custo: " + exame.getCusto());
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

    public Prescricao getPrescriçãoAssociada() {
        return prescriçãoAssociada;
    }

    public void setPrescriçãoAssociada(Prescricao prescriçãoAssociada) {
        this.prescriçãoAssociada = prescriçãoAssociada;
    }
}



