package excecoes;

public class ArmaInvalidaException extends GameException {

	public ArmaInvalidaException() {
		super("Nao ha arma disponivel, tente novamente");
	}

	public ArmaInvalidaException(String message) {
		super(message);
	}
}
