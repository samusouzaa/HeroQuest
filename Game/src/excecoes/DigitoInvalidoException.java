package excecoes;

public class DigitoInvalidoException extends GameException {

	public DigitoInvalidoException() {
		super("Dígito inválido, tente novamente!");
	}

	public DigitoInvalidoException(String message) {
		super(message);
	}
}
