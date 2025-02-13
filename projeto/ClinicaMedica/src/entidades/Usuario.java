package entidades;

public abstract class Usuario {
    private String nome;
    private String dataNascimento;
    private String cpf;
    public HistoricoMedico historico;

    // Construtor para inicializar os atributos
    public Usuario(String nome, String dataNascimento, String cpf, HistoricoMedico historico) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.historico = historico;
    }

    public abstract void deletarCadastro();  // D
    public abstract void lerCadastro();  // R

    public void atualizarCadastro(String nome, String dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    // Métodos de acesso (getters e setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public HistoricoMedico getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoMedico historico) {
        this.historico = historico;
    }
}
