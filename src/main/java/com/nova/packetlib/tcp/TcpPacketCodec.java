/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.tcp;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:51 PM
 */
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import com.nova.packetlib.Session;
import com.nova.packetlib.event.session.PacketReceivedEvent;
import com.nova.packetlib.io.NetInput;
import com.nova.packetlib.io.NetOutput;
import com.nova.packetlib.packet.Packet;
import com.nova.packetlib.tcp.io.ByteBufNetInput;
import com.nova.packetlib.tcp.io.ByteBufNetOutput;

import java.util.List;

public class TcpPacketCodec extends ByteToMessageCodec<Packet> {

    private Session session;

    public TcpPacketCodec(Session session) {
        this.session = session;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf buf) throws Exception {
        NetOutput out = new ByteBufNetOutput(buf);
        out.writeVarInt(this.session.getPacketProtocol().getOutgoingId(packet.getClass()));
        packet.write(out);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        NetInput in = new ByteBufNetInput(buf);
        int id = in.readVarInt();
        Packet packet = this.session.getPacketProtocol().createIncomingPacket(id);
        packet.read(in);
        if(packet.isPriority()) {
            this.session.callEvent(new PacketReceivedEvent(this.session, packet));
        }

        out.add(packet);
    }

}