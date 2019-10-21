package com.flipkart.hbaseobjectmapper;

import org.junit.Assert;
import org.junit.Test;

public class FamilyAndColumnTest {

  @Test
  public void constructorInputNotNullNotNullOutputNotNull() {
    final FamilyAndColumn actual = new FamilyAndColumn("foo", "foo");
    Assert.assertNotNull(actual);
    Assert.assertEquals("foo", ((FamilyAndColumn) actual).getSecond());
    Assert.assertEquals("foo", ((FamilyAndColumn) actual).getFirst());
  }
}
