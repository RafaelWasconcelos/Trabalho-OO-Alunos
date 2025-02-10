package excecoes;

public class EspecialidadeInvalidaException extends Exception {

    public EspecialidadeInvalidaException() {
        super("O médico não possui a especialidade necessária para atender o paciente.");
    }

    public EspecialidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
