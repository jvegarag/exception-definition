package com.jvegarag.exception.definition.errors;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization
 * for dealing with user permissions to access to a resource
 * 
 * @author jvegarag
 */
public class ValidationForbiddenErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1200857201442322772L;

	/** The field errors. */
	private final List<Map.Entry<String, Object>> fieldErrors;

	/**
	 * Instantiates a new validation forbidden error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ValidationForbiddenErrorInfo(final String errorText, final MessageCodesBundle code, final Object... parameters) {
		super(ErrorType.VALIDATION_FORBIDEN, Severity.INFO, errorText, code, parameters);
		this.fieldErrors = new ArrayList<Map.Entry<String, Object>>();
	}

	/**
	 * Adds the field.
	 * 
	 * @param field the field
	 * @param value the value
	 */
	public void addField(final String field, final Object value) {
		this.fieldErrors.add(new AbstractMap.SimpleEntry<String, Object>(field, value));
	}

	/**
	 * Gets the fields.
	 * 
	 * @return the fields
	 */
	public List<Map.Entry<String, Object>> getFields() {
		return this.fieldErrors;
	}

}
