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

package com.jvegarag.exception.definition;

import com.jvegarag.exception.definition.errors.AbstractErrorInfo;

/**
 * The Class IPToolException.
 */
public class ApplicationException extends AbstractBaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -982077082198636703L;

	/**
	 * Instantiates a new IP tool exception.
	 * 
	 * @param errorInfo the error info
	 */
	public ApplicationException(AbstractErrorInfo errorInfo) {
		super(errorInfo);
	}

	/**
	 * Instantiates a new IP tool exception.
	 * 
	 * @param exception the exception
	 * @param errorInfo the error info
	 */
	public ApplicationException(Throwable exception, AbstractErrorInfo errorInfo) {
		super(exception, errorInfo);
	}

}
