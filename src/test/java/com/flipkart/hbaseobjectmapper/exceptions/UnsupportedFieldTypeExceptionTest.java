package com.flipkart.hbaseobjectmapper.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class UnsupportedFieldTypeExceptionTest {

  @Test
  public void constructorInputNotNullOutputNotNull() {
    final String arg0 = "aaaaa";
    final UnsupportedFieldTypeException actual = new UnsupportedFieldTypeException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }
}
