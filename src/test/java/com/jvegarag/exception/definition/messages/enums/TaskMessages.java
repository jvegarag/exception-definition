package com.jvegarag.exception.definition.messages.enums;

import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * The Enum TaskMessages.
 */
public enum TaskMessages implements MessageCodesBundle {

	//@formatter:off
	
	CONFIRM_VALIDATION_DOSSIER_IRREGULARITIES,
	ACTION_NOT_FOUND_FOR_PREVALIDATION, 
	CONFIRM_TASK_VALIDATION, 
	TASK_ERROR_FOUND, REALLOCATION_PERMISSION,
	EXAMINER_NOT_EXISTS;
	
	//@formatter:on

	/*
	 * (non-Javadoc)
	 * 
	 * @see MessageCodesBundle#getMessageCode()
	 */
	@Override
	public String getMessageCode() {
		return "tasks." + this.name();
	}
}
