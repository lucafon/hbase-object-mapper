package com.flipkart.hbaseobjectmapper;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class HBObjectMapperTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void constructorInputNullOutputIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    new HBObjectMapper(null);
  }

  @Test
  public void writeValueAsPutInputNotNullOutput0() {
    final HBObjectMapper hBObjectMapper = new HBObjectMapper();
    final ArrayList records = new ArrayList();
    final List actual = hBObjectMapper.writeValueAsPut(records);
    final ArrayList<Put> arrayList = new ArrayList<Put>();
    Assert.assertEquals(arrayList, actual);
  }

  @Test
  public void writeValueAsResultInputNotNullOutput0() {
    final HBObjectMapper hBObjectMapper = new HBObjectMapper();
    final ArrayList records = new ArrayList();
    final List actual = hBObjectMapper.writeValueAsResult(records);
    final ArrayList<Result> arrayList = new ArrayList<Result>();
    Assert.assertEquals(arrayList, actual);
  }
}
