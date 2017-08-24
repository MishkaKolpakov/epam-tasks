package controller.exceptions;

public class IllegalSearchArguments extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Own exception for processing illogical data input
	 */
	public IllegalSearchArguments(String message) {
		super(message);
	}
}
