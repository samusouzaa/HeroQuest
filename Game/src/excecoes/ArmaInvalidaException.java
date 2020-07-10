package excecoes;

public class ArmaInvalidaException extends GameException {

	public ArmaInvalidaException() {
		super("Não há arma disponível, tente novamente");
	}

	public ArmaInvalidaException(String message) {
		super(message);
	}
}
