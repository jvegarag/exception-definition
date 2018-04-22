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
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import com.jvegarag.exception.definition.errors.enums.ErrorType;
import com.jvegarag.exception.definition.errors.enums.Severity;
import com.jvegarag.exception.definition.messages.enums.FeeMessages;
import com.jvegarag.exception.definition.messages.enums.GeneralMessages;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractErrorInfoTest {

	private AbstractErrorInfo testUnitExample;

	@Before
	public void setUp() throws Exception {
		// Arrange
		this.testUnitExample = new UnrecoverableErrorInfo("An error text", GeneralMessages.CUSTOM);
	}

	@Test
	public void validationFormTest() {
		// Arrange
		final String key = "dummyField", value = "dummyValue";

		// Act
		final ValidationFormErrorInfo validationErrorInfo = new ValidationFormErrorInfo("A validation form text", FeeMessages.FEE_NOT_PAID);
		validationErrorInfo.addField(key, value);
		final List<Entry<String, Object>> fields = validationErrorInfo.getFields();

		// Arrange
		final Entry<String, Object> entry = new AbstractMap.SimpleEntry<String, Object>(key, value);
		Assert.assertTrue(fields.contains(entry));
	}
	
	/**
	 * Tests the constructor of a ConfirmationErrorInfo providing additional error data
	 */
	@Test
	public void confirmationErrorInfoTest() {
		// Arrange
		Object data = Integer.valueOf(1);

		// Act
		AbstractErrorInfo errorInfo = new ConfirmationErrorInfo(data, "Confirmation text", GeneralMessages.PARAMETER_EMPTY);

		// Assert
		Assert.assertEquals(ErrorType.CONFIRMATION, errorInfo.getErrorType());
		Assert.assertEquals(Severity.INFO, errorInfo.getSeverity());
		Assert.assertEquals("Confirmation text", errorInfo.getErrorText());
		Assert.assertEquals(GeneralMessages.PARAMETER_EMPTY, errorInfo.getCode());
		Assert.assertEquals(1, errorInfo.getData());
	}	
	
	/**
	 * Tests the constructor of a ValidationErrorInfo providing additional error data
	 */	
	@Test
	public void validationErrorInfoTest() {
		// Arrange
		Object data = Integer.valueOf(1);

		// Act
		ValidationErrorInfo errorInfo = new ValidationErrorInfo(data, "Validation text", GeneralMessages.PARAMETER_INCORRECT_FORMAT);

		// Assert
		Assert.assertEquals(ErrorType.VALIDATION, errorInfo.getErrorType());
		Assert.assertEquals(Severity.INFO, errorInfo.getSeverity());
		Assert.assertEquals("Validation text", errorInfo.getErrorText());
		Assert.assertEquals(GeneralMessages.PARAMETER_INCORRECT_FORMAT, errorInfo.getCode());
		Assert.assertEquals(1, errorInfo.getData());
	}		

	@Test
	public void toStringTest() {
		// Act
		final String string = this.testUnitExample.toString();

		// Assert
		Assert.assertNotNull(string);

	}

	@Test
	public void toStringTestCause() {
		// Arrange
		this.testUnitExample.setCause(new Exception("Dummy"));

		// Act
		final boolean cause = this.testUnitExample.toString().contains("Cause:");

		// Assert
		Assert.assertTrue(cause);
	}

	@Test
	public void calculationsTest() {
		// Act
		final Date timeStamp = this.testUnitExample.getTimeStamp();

		// Assert
		Assert.assertNotNull(timeStamp);
	}

}
