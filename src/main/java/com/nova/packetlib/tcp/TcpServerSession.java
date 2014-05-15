package com.nova.packetlib.tcp;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:48 PM
 */
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import com.nova.packetlib.Server;
import com.nova.packetlib.packet.PacketProtocol;

import java.util.Map;

public class TcpServerSession extends TcpSession {

    private Server server;

    public TcpServerSession(String host, int port, PacketProtocol protocol, EventLoopGroup group, Bootstrap bootstrap, Server server) {
        super(host, port, protocol, group, bootstrap);
        this.server = server;
    }

    @Override
    public void connect() {
    }

    @Override
    public Map<String, Object> getFlags() {
        Map<String, Object> ret = super.getFlags();
        ret.putAll(this.server.getGlobalFlags());
        return ret;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        this.server.removeSession(this);
    }

}