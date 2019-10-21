package com.flipkart.hbaseobjectmapper.codec;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JavaObjectStreamCodecTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void canDeserializeInputNullOutputTrue() {
    final JavaObjectStreamCodec thisObj = new JavaObjectStreamCodec();
    final Type arg0 = null;
    final boolean actual = thisObj.canDeserialize(arg0);
    Assert.assertTrue(actual);
  }

  @Test
  public void deepCopyInputNotNullOutputNotNull() {
    final Throwable throwable = new Throwable();
    final DeserializationException arg0 = new DeserializationException("Could not deep copy: ", throwable);
    final Serializable actual = JavaObjectStreamCodec.deepCopy(arg0);
    Assert.assertNotNull(actual);
    Assert.assertEquals("Could not deep copy: ", ((DeserializationException) actual).getMessage());
  }

  @Test
  public void deserializeInput24NullNotNullOutputDeserializationException() throws DeserializationException {
    final JavaObjectStreamCodec thisObj = new JavaObjectStreamCodec();
    final byte[] arg0 = { (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0 };
    final Type arg1 = null;
    final HashMap<String, String> arg2 = new HashMap<String, String>();
    arg2.put("Could not deep copy: ", "Could not deep copy: ");
    thrown.expect(DeserializationException.class);
    thisObj.deserialize(arg0, arg1, arg2);
  }

  @Test
  public void canDeserializeInputNullOutputTrue1() {
    final JavaObjectStreamCodec javaObjectStreamCodec = new JavaObjectStreamCodec();
    Assert.assertTrue(javaObjectStreamCodec.canDeserialize(null));
  }
}
