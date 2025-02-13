package excecoes;


public class HorarioIndisponivelException extends Exception {

    public HorarioIndisponivelException() {
        super("O horário solicitado para a consulta já está ocupado.");
    }

    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
