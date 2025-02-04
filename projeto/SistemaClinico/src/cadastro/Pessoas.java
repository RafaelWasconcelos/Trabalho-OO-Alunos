package cadastro;

import java.time.LocalDate;

public class Pessoas {
	protected String nome;
    protected String cpf;
    protected LocalDate nascimento;

    public Pessoas (String nome, String cpf, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
		
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return nascimento; }
}


