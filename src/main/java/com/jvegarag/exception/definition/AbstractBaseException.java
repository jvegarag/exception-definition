package com.jvegarag.exception.definition;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import com.jvegarag.exception.definition.errors.AbstractErrorInfo;

/**
 * The application base exception.
 * 
 * @author jvegarag
 */
abstract class AbstractBaseException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6546267686581033542L;

	/** The errors. */
	private Deque<AbstractErrorInfo> errors = new ArrayDeque<AbstractErrorInfo>();

	/**
	 * Instantiates a new base exception.
	 * 
	 * @param errorInfo the error info
	 */
	AbstractBaseException(final AbstractErrorInfo errorInfo) {
		super(errorInfo != null ? errorInfo.getErrorText() : "");
		if (errorInfo != null) {
			errorInfo.setCause(this);
			this.errors.add(errorInfo);
		}
	}

	/**
	 * Instantiates a new base exception.
	 * 
	 * @param exception the exception
	 * @param errorInfo the error info
	 */
	AbstractBaseException(final Throwable exception, final AbstractErrorInfo errorInfo) {
		super(errorInfo != null ? errorInfo.getErrorText() : "", exception);
		if (exception instanceof AbstractBaseException) {
			this.errors.addAll(((AbstractBaseException) exception).errors);
		}
		if (errorInfo != null) {
			errorInfo.setCause(this);
			this.errors.add(errorInfo);
		}
	}

	/**
	 * Gets the last error.
	 * 
	 * @return the last error
	 */
	public AbstractErrorInfo getLastError() {
		return this.errors.getLast();
	}

	/**
	 * Gets the errors.
	 * 
	 * @return the errors
	 */
	public Collection<AbstractErrorInfo> getErrors() {
		return errors;
	}
}
