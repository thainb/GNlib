/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.session;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 9:09 AM
 */
/**
 * A listener for listening to session events.
 */
public interface SessionListener {

    /**
     * Called when a session receives a packet.
     *
     * @param event Data relating to the event.
     */
    public void packetReceived(PacketReceivedEvent event);

    /**
     * Called when a session sends a packet.
     *
     * @param event Data relating to the event.
     */
    public void packetSent(PacketSentEvent event);

    /**
     * Called when a session connects.
     *
     * @param event Data relating to the event.
     */
    public void connected(ConnectedEvent event);

    /**
     * Called when a session is about to disconnect.
     *
     * @param event Data relating to the event.
     */
    public void disconnecting(DisconnectingEvent event);

    /**
     * Called when a session is disconnected.
     *
     * @param event Data relating to the event.
     */
    public void disconnected(DisconnectedEvent event);

}