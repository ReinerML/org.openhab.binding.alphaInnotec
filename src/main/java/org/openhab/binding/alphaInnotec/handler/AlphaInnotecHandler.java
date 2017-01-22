/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.alphaInnotec.handler;

//import static org.eclipse.smarthome.binding.yahooweather.YahooWeatherBindingConstants.CHANNEL_TEMPERATURE;
import static org.openhab.binding.alphaInnotec.AlphaInnotecBindingConstants.*;

import java.util.concurrent.ScheduledFuture;

import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.openhab.binding.alphaInnotec.internal.AlphaInnotecSerial;
import org.openhab.binding.alphaInnotec.internal.InitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link AlphaInnotecHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Reiner Maass - Initial contribution
 */
public class AlphaInnotecHandler extends BaseThingHandler {

    private Logger logger = LoggerFactory.getLogger(AlphaInnotecHandler.class);
    ScheduledFuture<?> refreshJob;

    public AlphaInnotecHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(CHANNEL_TEMP_AMBIENT_AIR)) {
            // TODO: handle command
            logger.debug("AlphaInnotec handler for my command ");

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    public void publishData(final String string, final State state) {
        updateState(new ChannelUID(getThing().getUID(), string), state);
    }

    @Override
    public void updateStatus(ThingStatus status, ThingStatusDetail detail, String msg) {
        super.updateStatus(status, detail, msg);
    }

    @Override
    public void initialize() {
        // TODO: Initialize the thing. If done set status to ONLINE to indicate proper working.
        // Long running initialization should be done asynchronously in background.

        try {
            logger.debug("Initializing AlphaInnotec handler for my '{}'.", getThing().getUID().toString());

            Configuration config = getThing().getConfiguration();
            String port = (String) config.get(PROPERTY_SERIAL_DEVICE);

            AlphaInnotecSerial serialDevice = new AlphaInnotecSerial(this, port);

            try {
                serialDevice.initialize();
            } catch (InitializationException e) {
                String msg = "Could not open serial port " + port + ": " + e.getMessage();
                logger.debug(msg);
                updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.HANDLER_INITIALIZING_ERROR, msg);
            } catch (Throwable e) {
                String msg = "Could not open serial port " + port + ": " + e.getMessage();
                logger.debug(msg);
                updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.HANDLER_INITIALIZING_ERROR, msg);
            }

        } catch (Exception ex) {
            String msg = "Error occured while initializing AlphaInnotec handler: " + ex.getMessage();
            logger.error(msg, ex);
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, msg);
        }

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work
        // as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");
    }

    // public void startTimeoutSupervision() {
    // refreshJob.cancel(true);
    // Runnable runnable = new Runnable() {
    // @Override
    // public void run() {
    // String msg = "Timeout no sync received";
    // logger.error(msg);
    // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR, msg);
    // }
    // };
    // refreshJob = scheduler.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
    // }

}
