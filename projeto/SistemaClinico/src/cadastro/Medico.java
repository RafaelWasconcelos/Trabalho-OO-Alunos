package cadastro;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoas {
    private String crm;
    private String especialidade;
    private List<Consultas> historico;

    public Medico(String nome, String cpf, LocalDate nascimento, String crm, String especialidade) {
        super(nome, cpf, nascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.historico = new ArrayList<>();
    }
}
