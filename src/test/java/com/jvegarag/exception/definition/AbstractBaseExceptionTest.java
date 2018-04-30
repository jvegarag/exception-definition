package com.jvegarag.exception.definition;

import com.jvegarag.exception.definition.errors.AbstractErrorInfo;
import com.jvegarag.exception.definition.errors.UnrecoverableErrorInfo;
import com.jvegarag.exception.definition.errors.ValidationErrorInfo;
import com.jvegarag.exception.definition.messages.enums.GeneralMessages;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractBaseExceptionTest {

	private AbstractErrorInfo errorInfoExample1;
	private AbstractErrorInfo errorInfoExample2;

	@Before
	public void setUp() throws Exception {
		// Arrange
		errorInfoExample1 = new UnrecoverableErrorInfo("An error text", GeneralMessages.ACCESS_DENIED_ERROR);
		errorInfoExample2 = new ValidationErrorInfo("A validation text", GeneralMessages.EMPTY_FILE);
	}

	@Test
	public void testBuildException() {
		// Arrange
		ApplicationException ex = new ApplicationException(errorInfoExample1);
		Assert.assertNull(ex.getCause());
		Assert.assertEquals(1, ex.getErrors().size());

		ApplicationException wrapper = new ApplicationException(ex, errorInfoExample1);

		// Act
		Throwable cause = wrapper.getCause();
		int sizeEx = ex.getErrors().size();
		int sizeWrapper = wrapper.getErrors().size();
		AbstractErrorInfo lastError = wrapper.getLastError();

		// Assert
		Assert.assertSame(ex, cause);
		Assert.assertEquals(1, sizeEx);
		Assert.assertEquals(2, sizeWrapper);

		Assert.assertEquals(errorInfoExample1, lastError);
	}

	@Test(expected = AbstractBaseException.class)
	public void testRaiseException1() {
		// Act
		throw new ApplicationException(new ApplicationException(errorInfoExample2), errorInfoExample1);
	}

	@Test(expected = AbstractBaseException.class)
	public void testRaiseException2() {
		// Act
		throw new NoRollbackException(new NoRollbackException(errorInfoExample2), errorInfoExample1);
	}

	/**
	 * Test constructor
	 */
	@Test
	public void testConstructorNull_1() {
		// Act
		AbstractBaseException result = new ApplicationException(null);

		// Assert
		Assert.assertNotNull(result);
	}

	/**
	 * Test constructor
	 */
	@Test
	public void testConstructorNull_2() {
		// Act
		AbstractBaseException result = new ApplicationException(new NullPointerException(), null);

		// Assert
		Assert.assertNotNull(result);
	}
}
