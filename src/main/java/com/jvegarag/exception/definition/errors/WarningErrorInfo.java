package com.jvegarag.exception.definition.errors;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization for
 * dealing with warning messages that should be notified
 * 
 * @author jvegarag
 */
public class WarningErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5305130786438708665L;

	/**
	 * Instantiates a new warning error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public WarningErrorInfo(String errorText, MessageCodesBundle code, Object... parameters) {
		super(ErrorType.WARNING, Severity.WARN, errorText, code, parameters);
	}

}
