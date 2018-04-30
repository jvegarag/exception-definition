
package com.jvegarag.exception.definition.errors;

import java.io.Serializable;
import java.util.Arrays;

import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * The Class ErrorMessage.
 */
public class DetailMessage implements Serializable  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -120082323232322772L;

	/**
	 * Key used to lookup an error message in a text bundle, so the user can get the error
	 * description in his or her own language.
	 */
	private final MessageCodesBundle errorCode;

	/** Any additional parameters needed to construct a meaningful error description for the user. */
	private Object[] parameters;

	/**
	 * Instantiates a new error message.
	 * 
	 * @param errorCode the error code
	 * @param parameters the parameters
	 */
	public DetailMessage(MessageCodesBundle errorCode, Object... parameters) {
		this.errorCode = errorCode;
		if (parameters != null) {
			this.parameters = parameters.clone();
		}
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public MessageCodesBundle getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the parameters.
	 * 
	 * @return the parameters
	 */
	public Object[] getParameters() {
		return parameters != null ? parameters.clone() : new Object[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ErrorMessage [errorCode=" + errorCode.getMessageCode() + ", parameters=" + Arrays.toString(parameters) + "]";
	}
}
