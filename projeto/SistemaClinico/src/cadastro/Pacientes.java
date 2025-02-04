package cadastro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacientes extends Pessoas {
    private List<Consultas> historico;
    private boolean pagamentoPendente;

    public Pacientes(String nome, String cpf, LocalDate nascimento) {
        super(nome, cpf, nascimento);
        this.historico = new ArrayList<>();
        this.pagamentoPendente = false;
    }

    public void adicionarConsulta(Consultas consulta) {
        historico.add(consulta);
    }

    public boolean hasPagamentoPendente() {
        return pagamentoPendente;
    }
}