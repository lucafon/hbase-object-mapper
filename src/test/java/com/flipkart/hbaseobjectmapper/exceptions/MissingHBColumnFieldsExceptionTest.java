package com.flipkart.hbaseobjectmapper.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MissingHBColumnFieldsExceptionTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void constructorInputNullOutputNullPointerException() {
    final Class arg0 = null;
    thrown.expect(NullPointerException.class);
    new MissingHBColumnFieldsException(arg0);
  }
}
