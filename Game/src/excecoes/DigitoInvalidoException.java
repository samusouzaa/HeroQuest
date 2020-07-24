package excecoes;

public class DigitoInvalidoException extends GameException {

	public DigitoInvalidoException() {
		super("DÍGITO INVÁLIDO, TENTE NOVAMENTE!");
	}

	public DigitoInvalidoException(String message) {
		super(message);
	}
}
