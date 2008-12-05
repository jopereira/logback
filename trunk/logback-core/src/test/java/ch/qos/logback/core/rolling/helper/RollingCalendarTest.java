/**
 * LOGBack: the generic, reliable, fast and flexible logging framework.
 * 
 * Copyright (C) 1999-2006, QOS.ch
 * 
 * This library is free software, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation.
 */
package ch.qos.logback.core.rolling.helper;

import java.util.Date;

import junit.framework.TestCase;

public class RollingCalendarTest extends TestCase {

  public RollingCalendarTest(String arg0) {
    super(arg0);
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testPeriodicity() {
    {
      RollingCalendar rc = new RollingCalendar();
      assertEquals(PeriodicityType.TOP_OF_SECOND, rc
          .computePeriodicity("yyyy-MM-dd_HH_mm_ss"));
    }

    {
      RollingCalendar rc = new RollingCalendar();
      assertEquals(PeriodicityType.TOP_OF_MINUTE, rc
          .computePeriodicity("yyyy-MM-dd_HH_mm"));
    }

    {
      RollingCalendar rc = new RollingCalendar();
      assertEquals(PeriodicityType.TOP_OF_HOUR, rc
          .computePeriodicity("yyyy-MM-dd_HH"));
    }

    {
      RollingCalendar rc = new RollingCalendar();
      assertEquals(PeriodicityType.TOP_OF_DAY, rc
          .computePeriodicity("yyyy-MM-dd"));
    }

    {
      RollingCalendar rc = new RollingCalendar();
      assertEquals(PeriodicityType.TOP_OF_MONTH, rc
          .computePeriodicity("yyyy-MM"));
    }
  }

  public void testVaryingNumberOfHourlyPeriods() {
    RollingCalendar rc = new RollingCalendar();
    rc.init("yyyy-MM-dd_HH");
    long MILLIS_IN_HOUR = 3600*1000;

    for (int p = 100; p > -100; p--) {
      long now = 1223325293589L;  // Mon Oct 06 22:34:53 CEST 2008
      Date result = rc.getRelativeDate(new Date(now), p);
      long expected = now - (now % (MILLIS_IN_HOUR)) + p * MILLIS_IN_HOUR;
      assertEquals(expected, result.getTime());
    }
  }

  public void testVaryingNumberOfDailyPeriods() {
    RollingCalendar rc = new RollingCalendar();
    rc.init("yyyy-MM-dd");
    final long MILLIS_IN_DAY = 24*3600*1000;
    
    for (int p = 20; p > -100; p--) {
      long now = 1223325293589L;  // Mon Oct 06 22:34:53 CEST 2008
      Date nowDate = new Date(now);
      Date result = rc.getRelativeDate(nowDate, p);
      long offset = rc.getTimeZone().getRawOffset()+rc.getTimeZone().getDSTSavings();
    
      long origin = now - (now % (MILLIS_IN_DAY)) - offset;      
      long expected = origin + p * MILLIS_IN_DAY;
      assertEquals("p="+p, expected, result.getTime());
    }
  }
}