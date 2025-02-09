package entidades;

public class HistoricoMedico {
    Consulta consultas[]; 
    Exame exames[]; 

    public HistoricoMedico() {
        this.consultas = new Consulta[1000]; 
        this.exames = new Exame[1000]; 
    }

    // Adiciona uma consulta ao histórico
    public void addConsulta(Consulta consulta) {
        for (int i = 0; i < consultas.length; i++) {
            if (consultas[i] == null) {
                consultas[i] = consulta;
                break;
            }
        }
    }

    // Adiciona um exame ao histórico
    public void addExame(Exame exame) {
        for (int i = 0; i < exames.length; i++) {
            if (exames[i] == null) {
                exames[i] = exame;
                break;
            }
        }
    }

    
    public Consulta[] getConsultas() {
        return consultas;
    }

    public void setConsultas(Consulta[] consultas) {
        this.consultas = consultas;
    }

    public Exame[] getExames() {
        return exames;
    }

    public void setExames(Exame[] exames) {
        this.exames = exames;
    }
}
