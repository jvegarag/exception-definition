package com.jvegarag.exception.definition.messages.enums;

import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * The Enum FeeMessages.
 */
public enum FeeMessages implements MessageCodesBundle {

	//@formatter:off
	FEE_NOT_PAID,
	FEE_PAID_PARTIALLY,
	FEE_UNABLE_TO_PERFORM_FEE_DEBIT;
	//@formatter:on

	@Override
	public String getMessageCode() {
		return "fees." + this.name();
	}
}
