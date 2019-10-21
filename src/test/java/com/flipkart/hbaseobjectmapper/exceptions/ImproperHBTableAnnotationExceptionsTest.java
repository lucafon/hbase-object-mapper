package com.flipkart.hbaseobjectmapper.exceptions;

import com.flipkart.hbaseobjectmapper.exceptions.ImproperHBTableAnnotationExceptions.DuplicateColumnFamilyNamesOnHBTableAnnotationException;
import com.flipkart.hbaseobjectmapper.exceptions.ImproperHBTableAnnotationExceptions.EmptyColumnFamilyOnHBTableAnnotationException;
import com.flipkart.hbaseobjectmapper.exceptions.ImproperHBTableAnnotationExceptions.EmptyTableNameOnHBTableAnnotationException;
import com.flipkart.hbaseobjectmapper.exceptions.ImproperHBTableAnnotationExceptions.InvalidValueForVersionsOnHBTableAnnotationException;
import com.flipkart.hbaseobjectmapper.exceptions.ImproperHBTableAnnotationExceptions.MissingHBTableAnnotationException;
import org.junit.Assert;
import org.junit.Test;

public class ImproperHBTableAnnotationExceptionsTest {

  @Test
  public void constructorInputNotNullOutputNotNull() {
    final String arg0 = "aaaaa";
    final EmptyColumnFamilyOnHBTableAnnotationException actual = new EmptyColumnFamilyOnHBTableAnnotationException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }

  @Test
  public void constructorInputNotNullOutputNotNull1() {
    final String arg0 = "aaaaa";
    final MissingHBTableAnnotationException actual = new MissingHBTableAnnotationException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }

  @Test
  public void constructorInputNotNullOutputNotNull2() {
    final String arg0 = "aaaaa";
    final InvalidValueForVersionsOnHBTableAnnotationException actual = new InvalidValueForVersionsOnHBTableAnnotationException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }

  @Test
  public void constructorInputNotNullOutputNotNull3() {
    final String arg0 = "aaaaa";
    final EmptyTableNameOnHBTableAnnotationException actual = new EmptyTableNameOnHBTableAnnotationException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }

  @Test
  public void constructorInputNotNullOutputNotNull4() {
    final String arg0 = "aaaaa";
    final DuplicateColumnFamilyNamesOnHBTableAnnotationException actual = new DuplicateColumnFamilyNamesOnHBTableAnnotationException(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("aaaaa", actual.getMessage());
  }
}
