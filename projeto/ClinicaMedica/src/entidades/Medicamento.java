package entidades;

public class Medicamento {
    private String nomeMedicamento;

    // Construtor padrão
    public Medicamento() {
        // Construtor sem parâmetros
    }

    // Construtor com parâmetro
    public Medicamento(String nomeMedicamento) {
        if (nomeMedicamento != null && !nomeMedicamento.trim().isEmpty()) {
            this.nomeMedicamento = nomeMedicamento;
        } else {
            System.out.println("Erro: O nome do medicamento não pode ser vazio.");
        }
    }

    // Atualizar medicamento
    public void atualizarMedicamento(String nomeMedicamento) {
        if (nomeMedicamento != null && !nomeMedicamento.trim().isEmpty()) {
            this.nomeMedicamento = nomeMedicamento;
        } else {
            System.out.println("Erro: O nome do medicamento não pode ser vazio.");
        }
    }

    // Deletar medicamento
    public void deletarMedicamento() {
        this.nomeMedicamento = null;
    }

    // Ler medicamento
    public void lerMedicamento() {
        if (nomeMedicamento != null) {
            System.out.println("Nome do Medicamento: " + nomeMedicamento);
        } else {
            System.out.println("O medicamento não foi cadastrado.");
        }
    }

    // Getters e Setters
    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        if (nomeMedicamento != null && !nomeMedicamento.trim().isEmpty()) {
            this.nomeMedicamento = nomeMedicamento;
        } else {
            System.out.println("Erro: O nome do medicamento não pode ser vazio.");
        }
    }
}
