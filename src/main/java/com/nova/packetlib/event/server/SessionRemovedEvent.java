/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.server;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 1:29 PM
 */
import com.nova.packetlib.Server;
import com.nova.packetlib.Session;

/**
 * Called when a session is removed and disconnected from the server.
 */
public class SessionRemovedEvent implements ServerEvent {

    private Server server;
    private Session session;

    public SessionRemovedEvent(Server server, Session session) {
        this.server = server;
        this.session = session;
    }

    /**
     * Gets the server involved in this event.
     *
     * @return The event's server.
     */
    public Server getServer() {
        return this.server;
    }

    /**
     * Gets the session involved in this event.
     *
     * @return The event's session.
     */
    public Session getSession() {
        return this.session;
    }

    @Override
    public void call(ServerListener listener) {
        listener.sessionRemoved(this);
    }

}