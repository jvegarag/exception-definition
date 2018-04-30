package com.jvegarag.exception.definition.errors;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization for
 * dealing with generic validation errors raised from any layer (i.e. it is not possible to change
 * the milestone of the dossier because is appealed)
 * 
 * @author jvegarag
 */
public class ValidationErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2513096925738872319L;

	/**
	 * Instantiates a new validation error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ValidationErrorInfo(String errorText, MessageCodesBundle code, Object... parameters) {
		super(ErrorType.VALIDATION, Severity.INFO, errorText, code, parameters);
	}
	
	/**
	 * Instantiates a new validation error info.
	 * 
	 * @param errorType the error Type
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ValidationErrorInfo(ErrorType errorType, String errorText, MessageCodesBundle code, Object... parameters) {
		super(errorType, Severity.INFO, errorText, code, parameters);
	}

	/**
	 * Instantiates a new validation error info, with additional error data
	 * 
	 * @param errorType the error Type
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ValidationErrorInfo(Object data, String errorText, MessageCodesBundle code, Object... parameters) {
		super(data, ErrorType.VALIDATION, Severity.INFO, errorText, code, parameters);
	}
}
