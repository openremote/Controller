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
package org.openremote.controller.protocol;

import org.openremote.controller.model.sensor.Sensor;

/**
 * TODO
 *
 * @author <a href="mailto:juha@openremote.org">Juha Lindfors</a>
 */
public abstract class ReadCommand implements EventProducer
{

  /**
   * TODO
   */
  public final static int POLLING_INTERVAL = 500;

  
  /**
   * Read a device status and translate it to a sensor's datatype <p>
   */
  public abstract String read(Sensor sensor);

  /**
   * Used by {@link Sensor.DeviceReader} to determine the interval used before the next call to read() method.
   * This method can be overridden by subclasses (protocol specific ReadCommand implementations) to specify individual polling intervals.
   * The value must be strictly positive, if a negative or zero value is provided, the default is used instead.
   * 
   * @return a polling interval in milliseconds (default is 500ms) 
   */
  public int getPollingInterval() {
    return POLLING_INTERVAL;
  }

}
