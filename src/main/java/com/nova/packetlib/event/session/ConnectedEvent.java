/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.session;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 1:31 PM
 */
import com.nova.packetlib.Session;

/**
 * Called when the session connects.
 */
public class ConnectedEvent implements SessionEvent {

    private Session session;

    public ConnectedEvent(Session session) {
        this.session = session;
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
    public void call(SessionListener listener) {
        listener.connected(this);
    }

}