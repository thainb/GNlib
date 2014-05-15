/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.server;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 1:22 PM
 */
/**
 * An adapter for picking server events to listen for.
 */
public class ServerAdapter implements ServerListener {

    @Override
    public void serverBound(ServerBoundEvent event) {
    }

    @Override
    public void serverClosing(ServerClosingEvent event) {
    }

    @Override
    public void serverClosed(ServerClosedEvent event) {
    }

    @Override
    public void sessionAdded(SessionAddedEvent event) {
    }

    @Override
    public void sessionRemoved(SessionRemovedEvent event) {
    }

}