package net.frank.framework.dao;

public class DAOException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4353951746507726521L;

	public DAOException() {
        super();
    }

    /**
     * Constructor for DAOException.
     *
     * @param message
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructor for DAOException.
     *
     * @param message
     * @param cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for DAOException.
     *
     * @param cause
     */
    public DAOException(Throwable cause) {
        super(cause);
    }
}
