package com.nova.packetlib.test;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 10:50 PM
 */
import com.nova.packetlib.event.session.DisconnectedEvent;
import com.nova.packetlib.event.session.DisconnectingEvent;
import com.nova.packetlib.event.session.PacketReceivedEvent;
import com.nova.packetlib.event.session.SessionAdapter;

public class ServerSessionListener extends SessionAdapter {

    @Override
    public void packetReceived(PacketReceivedEvent event) {
        if(event.getPacket() instanceof PingPacket) {
            System.out.println("SERVER RECV: " + event.<PingPacket>getPacket().getPingId());
            event.getSession().send(event.getPacket());
        }
    }

    @Override
    public void disconnecting(DisconnectingEvent event) {
        System.out.println("SERVER Disconnecting: " + event.getReason());
    }

    @Override
    public void disconnected(DisconnectedEvent event) {
        System.out.println("SERVER Disconnected: " + event.getReason());
    }

}