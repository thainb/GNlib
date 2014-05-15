/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.server;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 1:25 PM
 */
import com.nova.packetlib.Server;

/**
 * Called when the server is about to close.
 */
public class ServerClosingEvent implements ServerEvent {

    private Server server;

    public ServerClosingEvent(Server server) {
        this.server = server;
    }

    /**
     * Gets the server involved in this event.
     *
     * @return The event's server.
     */
    public Server getServer() {
        return this.server;
    }

    @Override
    public void call(ServerListener listener) {
        listener.serverClosing(this);
    }

}