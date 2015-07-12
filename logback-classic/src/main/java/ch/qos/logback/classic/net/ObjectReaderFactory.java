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

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Factory for {@link ch.qos.logback.classic.net.ObjectReader} instances. This
 * class is the reverse of {@link ch.qos.logback.core.net.ObjectWriterFactory}.
 */
public class ObjectReaderFactory {

  /**
   * Creates a new {@link ch.qos.logback.classic.net.SerializationObjectReader} instance.
   *
   * @param inputStream the underlying {@link java.io.InputStream} to write from
   * @return a new {@link ch.qos.logback.classic.net.SerializationObjectReader} instance
   * @throws IOException if an I/O error occurs while writing stream header
   */
  public ObjectReader newObjectReader(InputStream inputStream) throws IOException {
    return new SerializationObjectReader(new ObjectInputStream(inputStream));
  }
}
