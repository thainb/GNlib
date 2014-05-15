/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.session;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:37 PM
 */
import com.nova.packetlib.Session;
import com.nova.packetlib.packet.Packet;

/**
 * Called when the session receives a packet.
 */
public class PacketReceivedEvent implements SessionEvent {

    private Session session;
    private Packet packet;

    public PacketReceivedEvent(Session session, Packet packet) {
        this.session = session;
        this.packet = packet;
    }

    /**
     * Gets the session involved in this event.
     *
     * @return The event's session.
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * Gets the packet involved in this event as the required type.
     *
     * @return The event's packet as the required type.
     * @throws IllegalStateException If the packet's value isn't of the required type.
     */
    @SuppressWarnings("unchecked")
    public <T extends Packet> T getPacket() {
        try {
            return (T) this.packet;
        } catch(ClassCastException e) {
            throw new IllegalStateException("Tried to get packet as the wrong type. Actual type: " + this.packet.getClass().getName());
        }
    }

    @Override
    public void call(SessionListener listener) {
        listener.packetReceived(this);
    }

}