package excecoes;

public class DigitoInvalidoException extends GameException {

	public DigitoInvalidoException() {
		super("Digito invalido, tente novamente!");
	}

	public DigitoInvalidoException(String message) {
		super(message);
	}
}
