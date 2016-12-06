/*
 * OpenRemote, the Home of the Digital Home.
 * Copyright 2008-2011, OpenRemote Inc.
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.controller.model.event;

import org.junit.Test;
import org.junit.Assert;

/**
 * Basic tests for {@link org.openremote.controller.model.event.Level} class.  <p>
 *
 * (ORCJAVA-86 -- http://jira.openremote.org/browse/ORCJAVA-86)
 *
 * @author <a href="mailto:juha@openremote.org">Juha Lindfors</a>
 * @author <a href="mailto:rainer@openremote.org">Rainer Hitz</a>
 */
public class LevelTest
{

  /**
   * Basic constructor and validation.
   */
  @Test public void basicConstruction()
  {
    Level l = new Level(0, "name", 100);

    Assert.assertTrue(l.getValue() == 100);
    Assert.assertTrue(l.getSource().equals("name"));
    Assert.assertTrue(l.getSourceID() == 0);

    Assert.assertTrue(l.serialize().equals("100"));

    Assert.assertTrue(l.toString() != null);
    Assert.assertFalse(l.toString().equals(""));
  }


  /**
   * Basic constructor and validation with value parameter above max limit of 100.
   */
  @Test public void basicConstructionMaxLimit()
  {
    Level l = new Level(4, "xXx", 101);

    Assert.assertTrue(l.getValue() == 100);
    Assert.assertTrue(l.getSource().equals("xXx"));
    Assert.assertTrue(l.getSourceID() == 4);

    Assert.assertTrue(l.serialize().equals("100"));

    Assert.assertTrue(l.toString() != null);
    Assert.assertFalse(l.toString().equals(""));
  }


  /**
   * Basic constructor and validation with value parameter below min limit of 0.
   */
  @Test public void basicConstructionMinLimit()
  {
    Level l = new Level(444, "aaa", -1);

    Assert.assertTrue(l.getValue() == 0);
    Assert.assertTrue(l.getSource().equals("aaa"));
    Assert.assertTrue(l.getSourceID() == 444);

    Assert.assertTrue(l.serialize().equals("0"));

    Assert.assertTrue(l.toString() != null);
    Assert.assertFalse(l.toString().equals(""));
  }


  @Test public void testEquals()
  {
    Level l1 = new Level(1, "Source-1", 50);
    Level l2 = new Level(1, "Source-1", 50);

    Assert.assertTrue(l1.equals(l1));
    Assert.assertTrue(l1.equals(l2));
    Assert.assertTrue(l2.equals(l1));
    Assert.assertTrue(l1.hashCode() == l2.hashCode());


    Level l3 = new Level(2, "Source-1", 50);

    Assert.assertFalse(l3.equals(l1));


    Level l4 = new Level(1, "Source-2", 50);

    Assert.assertFalse(l4.equals(l1));


    Level l5 = new Level(1, "Source-1", 10);

    Assert.assertFalse(l5.equals(l1));


    Range r1 = new Range(1, "Source-1", 50, 10, 90);

    Assert.assertFalse(l1.equals(r1));
    Assert.assertFalse(r1.equals(l1));
  }
}

