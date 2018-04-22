/*
 *  $Id$
 *       . * .
 *     * RRRR  *    Copyright (c) 2015 OHIM: Office for Harmonization
 *   .   RR  R   .  in the Internal Market (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on

package com.jvegarag.exception.definition.errors;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization for
 * dealing with validation errors generated from the presentation layer (i.e. validation of a form)
 * 
 * @author jvegarag
 */
public class ValidationFormErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1200857201442322772L;

	/** The field errors. */
	private final List<Map.Entry<String, Object>> fieldErrors;

	/**
	 * Instantiates a new validation form error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public ValidationFormErrorInfo(String errorText, MessageCodesBundle code, Object... parameters) {
		super(ErrorType.VALIDATION_FORM, Severity.INFO, errorText, code, parameters);
		fieldErrors = new ArrayList<Map.Entry<String, Object>>();
	}

	/**
	 * Adds the field.
	 * 
	 * @param field the field
	 * @param value the value
	 */
	public void addField(String field, Object value) {
		fieldErrors.add(new AbstractMap.SimpleEntry<String, Object>(field, value));
	}

	/**
	 * Gets the fields.
	 * 
	 * @return the fields
	 */
	public List<Map.Entry<String, Object>> getFields() {
		return fieldErrors;
	}

}
