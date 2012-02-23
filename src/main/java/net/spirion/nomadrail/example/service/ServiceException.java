package net.spirion.nomadrail.example.service;

/**
 * <p>
 * Exception class used to wrap service level exceptions.  Used as a convenience simply to show here that something
 * should be done regards exception handling.  This class is not in use in the example web application.
 * </p>
 * 
 * @author Michael Conway
 * @Version 1.0
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 7488886183194134903L;

	public ServiceException() {
		super();
	}

	public ServiceException(String s) {
		super(s);
	}

	public ServiceException(Throwable t) {
		super(t);
	}

	public ServiceException(String s, Throwable t) {
		super(s, t);
	}

}
