package functions;

public class BadTimeException extends Exception {
	/*
	 * 1/2 inheritance 
	 */

	public BadTimeException ( String message )
	{
		/*
		 * calls class Exception to handle the exception
		 * used when a "invalid date" is entered for a due date
		 * 	Triggers a prompt for a new date to be entered
		 */
		super(message);
	}
}
