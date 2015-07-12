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
import java.io.ObjectInputStream;

/**
 * Reads objects from a stream using Java serialization. This class is the
 * reverse of {@link ch.qos.logback.core.net.AutoFlushingObjectWriter}.
 */
public class SerializationObjectReader implements ObjectReader {

  private final ObjectInputStream objectInputStream;

  /**
   * Creates a new instance for the given {@link java.io.ObjectInputStream}.
   *
   * @param objectInputStream the stream to read from
   */
  public SerializationObjectReader(ObjectInputStream objectInputStream) {
    this.objectInputStream = objectInputStream;
  }

  @Override
  public Object read() throws IOException, ClassNotFoundException {
	  return objectInputStream.readObject();
  }
  
  /**
   * {@inheritDoc}
   */
  public void close() throws IOException {
	  objectInputStream.close();
  }
}
