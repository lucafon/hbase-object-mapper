package com.flipkart.hbaseobjectmapper.exceptions;

import com.flipkart.hbaseobjectmapper.HBRecord;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FieldNotMappedToHBaseColumnExceptionTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void constructorInputNullNotNullOutputNullPointerException() {
    final Class<HBRecord> arg0 = null;
    final String arg1 = "aaaaa";
    thrown.expect(NullPointerException.class);
    new FieldNotMappedToHBaseColumnException(arg0, arg1);
  }
}
