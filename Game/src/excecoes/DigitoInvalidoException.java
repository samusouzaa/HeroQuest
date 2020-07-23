package excecoes;

public class DigitoInvalidoException extends GameException {

	public DigitoInvalidoException() {
		super("Direção invalida, tente novamente");
	}

	public DigitoInvalidoException(String message) {
		super(message);
	}
}
