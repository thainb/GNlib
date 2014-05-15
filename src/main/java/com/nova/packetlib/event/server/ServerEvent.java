/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.server;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 9:04 AM
 */
/**
 * An event relating to servers.
 */
public interface ServerEvent {

    /**
     * Calls the event.
     *
     * @param listener Listener to call the event on.
     */
    public void call(ServerListener listener);

}
