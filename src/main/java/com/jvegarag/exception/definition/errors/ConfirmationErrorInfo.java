package com.jvegarag.exception.definition.errors;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization
 * for dealing with operations that should be confirmed by the user
 * 
 * @author jvegarag
 */
public class ConfirmationErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3536282343442292781L;

	/**
	 * Instantiates a new confirmation error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ConfirmationErrorInfo(String errorText, MessageCodesBundle code, Object... parameters) {
		super(ErrorType.CONFIRMATION, Severity.INFO, errorText, code, parameters);
	}

	/**
	 * Instantiates a new confirmation error info with additional error data.
	 *
	 * @param data the data
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ConfirmationErrorInfo(Object data,String errorText, MessageCodesBundle code, Object... parameters) {
		super(data, ErrorType.CONFIRMATION, Severity.INFO, errorText, code, parameters);
	}
}
