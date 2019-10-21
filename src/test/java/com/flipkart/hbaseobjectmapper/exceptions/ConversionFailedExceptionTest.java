package com.flipkart.hbaseobjectmapper.exceptions;

import org.junit.Assert;
import org.junit.Test;
public class ConversionFailedExceptionTest {

  @Test
  public void constructorInputNotNullNotNullOutputNotNull() {

    final String arg0 = "aaaaa";
    final Throwable arg1 = new Throwable();

    final ConversionFailedException actual = new ConversionFailedException(arg0, arg1);

    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());

  }

  @Test
  public void constructorInputNotNullOutputNotNull() {

    final String arg0 = "aaaaa";

    final ConversionFailedException actual = new ConversionFailedException(arg0);

    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());

  }
}
