/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.alphaInnotec;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link alphaInnotecBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Reiner Maass - Initial contribution
 */
public class AlphaInnotecBindingConstants {

    public static final String BINDING_ID = "AlphaInnotec";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_HEAT_PUMP = new ThingTypeUID(BINDING_ID, "heatPump");

    public final static String PROPERTY_SERIAL_DEVICE = "serialDevice";

    // List of all Channel ids
    public static final String CHANNEL_TEMP_AMBIENT_AIR = "tempAmbientAir";
    public static final String CHANNEL_TEMP_INLET_AIR = "tempInletAir";
    public static final String CHANNEL_TEMP_EXHAUST_AIR = "tempExhaustAir";
    public static final String CHANNEL_TEMP_HEAT_EXCHANGE_AIR = "tempHeatExchangeAir";
    public static final String CHANNEL_TEMP_COOLING_PLATE = "tempCoolingPlate";
    public static final String CHANNEL_TEMP_TAP_WATER_TOP = "tempTapWaterTop";
    public static final String CHANNEL_TEMP_TAP_WATER_BOTTOM = "tempTapWaterBottom";
    public static final String CHANNEL_TEMP_EXT_STORAGE_UNIT = "tempExtStorageUnit";
    public static final String CHANNEL_CURRENT_STATUS = "currentStatus";
    public static final String CHANNEL_FAN_STAGE = "fanStage";

    public final static int BAUD_RATE = 19200;

    public final static int INDEX_TEMP_AMBIENT_AIR = 0;
    public final static int INDEX_TEMP_INLET_AIR = 2;
    public final static int INDEX_TEMP_EXHAUST_AIR = 4;
    public final static int INDEX_TEMP_HEAT_EXCHANGE_AIR = 6;
    public final static int INDEX_TEMP_COOLING_PLATE = 8;
    public final static int INDEX_TEMP_TAP_WATER_TOP = 10;
    public final static int INDEX_TEMP_TAP_WATER_BOTTOM = 12;
    public final static int INDEX_TEMP_EXT_STORAGE_UNIT = 14;
    public final static int INDEX_CURRENT_STATUS = 16;
    public final static int INDEX_FAN_STAGE = 81;

    // public final static String CHANNEL_1 = "channel1";

}
