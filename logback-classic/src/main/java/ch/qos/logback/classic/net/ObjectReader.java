/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.classic.net;

import java.io.Closeable;
import java.io.IOException;

/**
 * Reads objects from an input. This class is the reverse of
 * {@link ch.qos.logback.core.net.ObjectWriter}.
 */
public interface ObjectReader extends Closeable {

  /**
   * Reads an object from an input.
   *
   * @returns the {@link Object} read
   * @throws IOException in case input/output fails, details are defined by the implementation
   * @throws ClassNotFoundException in case an unknown class is read 
   */
  Object read() throws IOException, ClassNotFoundException;
}
