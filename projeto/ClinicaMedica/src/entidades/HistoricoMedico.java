package entidades;

import java.util.ArrayList;
import java.util.List;

public class HistoricoMedico {
    private List<Consulta> consultas;
    private List<Exame> exames;

    // Construtor padrão
    public HistoricoMedico() {
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    // Métodos para adicionar consultas e exames
    public void adicionarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        } else {
            System.out.println("Erro: Consulta não pode ser nula.");
        }
    }

    public void adicionarExame(Exame exame) {
        if (exame != null) {
            exames.add(exame);
        } else {
            System.out.println("Erro: Exame não pode ser nulo.");
        }
    }

    // Métodos para remover consultas e exames
    public void removerConsulta(Consulta consulta) {
        if (consulta != null && consultas.contains(consulta)) {
            consultas.remove(consulta);
        } else {
            System.out.println("Erro: Consulta não encontrada.");
        }
    }

    public void removerExame(Exame exame) {
        if (exame != null && exames.contains(exame)) {
            exames.remove(exame);
        } else {
            System.out.println("Erro: Exame não encontrado.");
        }
    }

    // Getters e Setters
    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    // Método para ler histórico de consultas e exames
    public void lerHistorico() {
        System.out.println("Consultas no Histórico:");
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
        } else {
            for (Consulta consulta : consultas) {
                if (consulta != null) {
                    System.out.println("  " + consulta.toString());  // Supondo que o método toString() seja bem implementado na classe Consulta
                }
            }
        }

        System.out.println("Exames no Histórico:");
        if (exames.isEmpty()) {
            System.out.println("Nenhum exame registrado.");
        } else {
            for (Exame exame : exames) {
                if (exame != null) {
                    System.out.println("  " + exame.toString());  // Supondo que o método toString() seja bem implementado na classe Exame
                }
            }
        }
    }
}
