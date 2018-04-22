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

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A {@link AbstractErrorInfo} specialization for
 * dealing with unrecoverable errors raised from any layer. An unrecoverable error should be raised
 * when the user can do nothing to fix the error detected (i.e. a Web Service call failed because
 * the service is down)
 */
public class UnrecoverableErrorInfo extends AbstractErrorInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8820180400510603642L;

	/**
	 * Instantiates a new unrecoverable error info.
	 * 
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public UnrecoverableErrorInfo(String errorText, MessageCodesBundle code, Object... parameters) {
		super(ErrorType.UNRECOVERABLE, Severity.ERROR, errorText, code, parameters);
	}

}
