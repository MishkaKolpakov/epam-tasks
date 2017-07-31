package exceptions;

public class UniqueNicknameException extends Exception {
	public UniqueNicknameException() {
		super("Nickname already exists!");
	}
}
