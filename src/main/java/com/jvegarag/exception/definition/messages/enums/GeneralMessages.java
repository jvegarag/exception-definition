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

package com.jvegarag.exception.definition.messages.enums;

import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * The Enum shoud contain only generic messages that will shared along modules
 */
public enum GeneralMessages implements MessageCodesBundle {

	//@formatter:off
	CUSTOM,
	UNKNOWN_ERROR,

	NOT_ACCEPTABLE_TYPE,
	UNSUPPORTED_TYPE,
	UNSUPPORTED_OPERATION,
	NO_PROPERTY,
	PARAMETER_INCORRECT_FORMAT,
	PARAMETER_EMPTY,

	EMPTY_FILE,
	SAVE_TEMPORAL_FILE_ERROR,

	PERSISTENCE_LAYER_FAILED,

	ERROR_INVOKING_SERVICE,

	PARSE_ERROR,
	VALIDATION_ERROR_LIST,

	UNAUTHORIZED,
	SECURITY_ERROR,
	ACCESS_DENIED_ERROR,

	MAXIMUM_ELEMENTS_EXCEED,
	OPTIMISTIC_LOCK_ACCESS;
	//@formatter:on

	@Override
	public String getMessageCode() {
		return "general." + name();
	}

}
