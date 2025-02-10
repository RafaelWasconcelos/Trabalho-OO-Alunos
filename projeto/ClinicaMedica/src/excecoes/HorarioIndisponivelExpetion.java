package excecoes;


public class HorarioIndisponivelExpetion extends Exception {

    public HorarioIndisponivelExpetion() {
        super("O horário solicitado para a consulta já está ocupado.");
    }

    public HorarioIndisponivelExpetion(String mensagem) {
        super(mensagem);
    }
}
