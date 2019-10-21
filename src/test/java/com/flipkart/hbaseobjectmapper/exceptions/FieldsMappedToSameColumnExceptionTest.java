package com.flipkart.hbaseobjectmapper.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class FieldsMappedToSameColumnExceptionTest {

  @Test
  public void constructorInputNotNullOutputNotNull() {
    final String arg0 = "aaaaa";
    final FieldsMappedToSameColumnException actual = new FieldsMappedToSameColumnException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }
}
