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

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.MessageCodesBundle;

/**
 * A class encapsulating the necessary data for raising an application exception.
 * 
 * @author jvegarag
 */
public abstract class AbstractErrorInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3213269842873314013L;

	/** The error cause, if an alien or another application exception is caught and wrapped. */
	private Throwable cause;

	/** Contains the severity of the error. */
	private Severity severity;

	/**
	 * The errorType field tells whether the error was caused by erroneous input to the application,
	 * an external service that failed, or an internal error.
	 */
	private final ErrorType errorType;

	/** The time stamp when the exception was created. */
	private final Date timeStamp;

	/**
	 * The code.
	 */
	private final MessageCodesBundle code;

	/** Any additional parameters needed to construct a meaningful error description for the user. */
	private final Object[] parameters;

	/**
	 * Contains a description of the error with all the necessary details needed for the application
	 * operators, and possibly the application developers, to understand what error occurred.
	 */
	private final String errorText;

	/**
	 * The detail messages.
	 */
	private List<DetailMessage> detailMessages = new ArrayList<DetailMessage>();
	
	/**
	 * Contains additional error data 
	 */
	private Object data;


	/**
	 * Constructor for all the final fields
	 * 
	 * @param timeStamp
	 * @param errorType
	 * @param errorText
	 * @param errorCode
	 * @param parameters
	 */
	public AbstractErrorInfo(final Date timeStamp, final ErrorType errorType, final String errorText,
	        final MessageCodesBundle errorCode, final Object... parameters) {
		this.timeStamp = timeStamp;
		this.errorType = errorType;
		this.errorText = errorText;		
		this.code = errorCode;
		this.parameters = parameters;
	}
	
	/**
	 * Instantiates a new error info.
	 * 
	 * @param errorType the error type
	 * @param severity the severity
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public AbstractErrorInfo(final ErrorType errorType, final Severity severity, final String errorText, final MessageCodesBundle code,
	        final Object... parameters) {
		this(new Date(), errorType, errorText, code, parameters);	
		this.severity = severity;
	}
	
	/**
	 * Instantiates a new error info with additional data
	 *
	 * @param errorType the error type
	 * @param severity the severity
	 * @param errorText the error text
	 * @param code the code
	 * @param parameters the parameters
	 */
	public AbstractErrorInfo(final Object data, final ErrorType errorType, final Severity severity, final String errorText,
	        final MessageCodesBundle code, final Object... parameters) {
		this(errorType, severity, errorText, code, parameters);
		this.data = data;
	}	

	/**
	 * Gets the cause.
	 * 
	 * @return the cause
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * Sets the cause.
	 * 
	 * @param cause the new cause
	 */
	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	/**
	 * Gets the severity.
	 * 
	 * @return the severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * Sets the severity.
	 * 
	 * @param severity the new severity
	 */
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	/**
	 * Gets the error text.
	 * 
	 * @return the error text
	 */
	public String getErrorText() {
		return errorText;
	}

	/**
	 * Gets the error type.
	 * 
	 * @return the error type
	 */
	public ErrorType getErrorType() {
		return errorType;
	}

	/**
	 * Gets the time stamp.
	 * 
	 * @return the time stamp
	 */
	public Date getTimeStamp() {
		return timeStamp != null ? new Date(timeStamp.getTime()) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("ErrorText: ").append(this.getErrorText()).append('\n');
		sb.append("\tErrorType: ").append(this.getErrorType()).append('\n');
		sb.append("\tSeverity:  ").append(this.getSeverity()).append('\n');
		sb.append("\tRaisedOn:  ").append(this.getTimeStamp()).append('\n');
		sb.append("\tErrorCode: ").append(this.getCode()).append('\n');

		this.appendCause(sb);

		return sb.toString();
	}

	/**
	 * Append cause.
	 * 
	 * @param builder the builder
	 */
	private void appendCause(StringBuilder builder) {
		StringWriter sw = new StringWriter();
		if (cause != null) {
			cause.printStackTrace(new PrintWriter(sw));
		}
		builder.append("\tCause: ").append(sw.toString()).append('\n');
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the code
	 */
	public MessageCodesBundle getCode() {
		return code;
	}
	
	/**
	 * Returns the {@link MessageCodesBundle} used to generate the i18n error message
	 * @return
	 */
	public final MessageCodesBundle getCodeMessage() {
		return code;
	}

	/**
	 * Gets the parameters.
	 * 
	 * @return the parameters
	 */
	public Object[] getParameters() {
		Object[] toReturn = null;
		if (parameters != null) {
			toReturn = parameters.clone();
		}

		return toReturn;
	}

	/**
	 * Gets the detail messages.
	 * 
	 * @return the detail messages
	 */
	public List<DetailMessage> getDetailMessages() {
		return detailMessages;
	}

	/**
	 * Sets the detail messages.
	 * 
	 * @param detailMessages the new detail messages
	 */
	public void setDetailMessages(List<DetailMessage> detailMessages) {
		this.detailMessages = detailMessages;
	}

	/**
	 * Gets the additional error data
	 * 
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the additional error data
	 * 
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
