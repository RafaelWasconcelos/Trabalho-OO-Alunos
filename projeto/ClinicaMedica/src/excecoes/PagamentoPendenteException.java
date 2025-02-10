package excecoes;

public class PagamentoPendenteException extends Exception {

    public PagamentoPendenteException() {
        super("O paciente possui um pagamento pendente. Não é possível agendar novas consultas.");
    }

    public PagamentoPendenteException(String mensagem) {
        super(mensagem);
    }
}
