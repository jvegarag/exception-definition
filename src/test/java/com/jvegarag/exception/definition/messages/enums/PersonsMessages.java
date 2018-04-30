
package com.jvegarag.exception.definition.messages.enums;

import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * The Enum FeeMessages.
 */
public enum PersonsMessages implements MessageCodesBundle {

	//@formatter:off
	REQUESTOR_LIST_EMPTY,
	PERSON_NOT_FOUND_ERROR,
	SEVERAL_FOUND_ERROR,
	PERSON_WITH_INVALID_STATUS
	;
	//@formatter:on

	@Override
	public String getMessageCode() {
		return "persons." + this.name();
	}
}
