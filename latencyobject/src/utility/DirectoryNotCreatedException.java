package utility;

public class DirectoryNotCreatedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DirectoryNotCreatedException() {
		super();
	}

	public DirectoryNotCreatedException(String message) {
		super(message);
	}

	public DirectoryNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DirectoryNotCreatedException(Throwable cause) {
		super(cause);
	}
}
