/*
 * #%L
 * Simple Java Database Swing Application - Part 06 - Domain
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.app;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  public static void main(final String[] args) {
    DbHelper.getInstance().init();

    try {
      final Contact c = new Contact();
      c.setName("Albert Attard");
      c.setContacts("albert@javacreed.com");
      c.save();
    } catch (final SQLException e) {
      Main.LOGGER.error("Failed to save the contact", e);
    }

    DbHelper.getInstance().close();
    Main.LOGGER.info("Done");
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
}
