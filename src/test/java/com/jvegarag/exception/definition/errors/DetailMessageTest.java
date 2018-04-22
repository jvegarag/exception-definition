//@formatter:off
/**
*  $Id$
*       . * .
*     * RRRR  *    Copyright (c) 2016 EUIPO: European Union Intellectual
*   .   RR  R   .  Property Office (trade marks and designs)
*   *   RRR     *
*    .  RR RR  .   ALL RIGHTS RESERVED
*     * . _ . *
*/
//@formatter:on
package com.jvegarag.exception.definition.errors;

import com.jvegarag.exception.definition.messages.enums.GeneralMessages;
import org.junit.Assert;
import org.junit.Test;

/**
 * The DetailMessage test class
 * 
 * @author jvegarag
 */
public class DetailMessageTest {

	/**
	 * Tests the constructor providing a null array in the dynamic parameter
	 */
	@Test
	public void testConstructorParametersNull() {

		// Act
		DetailMessage message = new DetailMessage(GeneralMessages.CUSTOM, (Object[]) null);

		// Assert
		Assert.assertEquals(GeneralMessages.CUSTOM, message.getErrorCode());
		Assert.assertNotNull(message.getParameters());
		Assert.assertEquals(0, message.getParameters().length);
	}

	/**
	 * Tests the constructor not providing any parameter in the dynamic parameter
	 */
	@Test
	public void testConstructorParametersNotProvided() {

		// Act
		DetailMessage message = new DetailMessage(GeneralMessages.CUSTOM);

		// Assert
		Assert.assertEquals(GeneralMessages.CUSTOM, message.getErrorCode());
		Assert.assertNotNull(message.getParameters());
		Assert.assertEquals(0, message.getParameters().length);
	}

	/**
	 * Tests the constructor providing a value in the dynamic parameter
	 */
	@Test
	public void testConstructorWithParameters() {

		// Act
		DetailMessage message = new DetailMessage(GeneralMessages.CUSTOM, Integer.valueOf(2));

		// Assert
		Assert.assertEquals(GeneralMessages.CUSTOM, message.getErrorCode());
		Assert.assertNotNull(message.getParameters());
		Assert.assertEquals(1, message.getParameters().length);
		Assert.assertEquals(2, message.getParameters()[0]);
	}

}
