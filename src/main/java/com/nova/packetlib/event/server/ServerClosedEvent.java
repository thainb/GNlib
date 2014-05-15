/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.server;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 1:24 PM
 */
import com.nova.packetlib.Server;

/**
 * Called when the server is closed.
 */
public class ServerClosedEvent implements ServerEvent {

    private Server server;

    public ServerClosedEvent(Server server) {
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
        listener.serverClosed(this);
    }

}