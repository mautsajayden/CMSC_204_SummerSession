public class NoDigitException extends RuntimeException {

	public NoDigitException() {
		super("The password must contain at least one digit");
	}

	public NoDigitException(String message) {
		super(message);
	}
}
