package com.jvegarag.exception.definition.errors.enums;

/**
 * The Enum ErrorType.
 */
public enum ErrorType {

	/** The user can do anything in order to fix the problem (i.e. a service call fails) **/
	UNRECOVERABLE,

	/** A business validation **/
	VALIDATION,

	/** A validation performed on the presentation layer **/
	VALIDATION_FORM,
	
	/** A requested resource doesn't exist **/
	VALIDATION_NOT_FOUND,

	/** A requested representation of resource doesn't exist**/
	VALIDATION_NOT_ACCEPTABLE_TYPE,

	/** A provided representation of resource is not supported **/
	VALIDATION_NOT_SUPPORTED_TYPE,

    /** The user is not granted to access the resource **/
    VALIDATION_FORBIDEN,

	/** Warning message for the user **/
	WARNING,

	/** Confirmation message for the user **/
	CONFIRMATION,

	/** The server understands the content type of the request entity (syntactically correct) but was unable to process the
	 * contained instructions **/
	VALIDATION_UNPROCESSABLE_ENTITY;
	
}
