package com.jvegarag.exception.definition;

import com.jvegarag.exception.definition.errors.AbstractErrorInfo;

/**
 * An exception that do not produce rollback of a transaction
 * The transaction manager will be configured in order not to perform a rollback operation
 * when this exception is raised.
 * 
 * @author jvegarag
 */
public class NoRollbackException extends AbstractBaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2043770756989939347L;

	/**
	 * Instantiates a new no rollback exception.
	 * 
	 * @param errorInfo the error info
	 */
	public NoRollbackException(AbstractErrorInfo errorInfo) {
		super(errorInfo);
	}

	/**
	 * Instantiates a new no rollback exception.
	 * 
	 * @param exception the exception
	 * @param errorInfo the error info
	 */
	public NoRollbackException(Throwable exception, AbstractErrorInfo errorInfo) {
		super(exception, errorInfo);
	}

}
