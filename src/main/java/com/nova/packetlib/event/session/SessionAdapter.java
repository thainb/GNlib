/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.session;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:40 PM
 */
/**
 * An adapter for picking session events to listen for.
 */
public class SessionAdapter implements SessionListener {

    @Override
    public void packetReceived(PacketReceivedEvent event) {
    }

    @Override
    public void packetSent(PacketSentEvent event) {
    }

    @Override
    public void connected(ConnectedEvent event) {
    }

    @Override
    public void disconnecting(DisconnectingEvent event) {
    }

    @Override
    public void disconnected(DisconnectedEvent event) {
    }

}