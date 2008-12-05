/** 
 * LOGBack: the reliable, fast and flexible logging library for Java.
 *
 * Copyright (C) 1999-2005, QOS.ch, LOGBack.com
 *
 * This library is free software, you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation.
 */
package ch.qos.logback.core.pattern;

/**
 * A minimal converter which sets up the general interface for derived classes. 
 * It also implements the functionality to chain converters in a linked list.
 * 
 * @author ceki
 */
abstract public class Converter<E> {
  
  Converter<E> next;

  /**
   * The convert method is responsible for extracting data from the event and
   * storing it for later use by the write method.
   * 
   * @param event
   */
  public abstract String  convert(E event);

  /**
   * In its simplest incarnation, a convert simply appends the data extracted from
   * the event to the buffer passed as parameter.
   * 
   * @param buf The input buffer where data is appended
   * @param event The event from where data is extracted
   */
  public void write(StringBuffer buf, E event) {
    buf.append(convert(event));
  }
  
  public final void setNext(Converter<E> next) {
    if (this.next != null) {
      throw  new IllegalStateException("Next converter has been already set");
    }
    this.next = next;
  }

  public final Converter<E> getNext() {
    return next;
  }
}