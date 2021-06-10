package exceptions;

public class CannotBeEmptyException extends Exception {

	public CannotBeEmptyException() {}
	
	public CannotBeEmptyException(String e_msg) {
		super(e_msg);
	}
	
}