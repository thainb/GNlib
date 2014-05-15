package com.nova.packetlib.tcp;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:51 PM
 */
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import com.nova.packetlib.ConnectionListener;

public class TcpConnectionListener implements ConnectionListener {

    private String host;
    private int port;
    private EventLoopGroup group;
    private Channel channel;

    public TcpConnectionListener(String host, int port, EventLoopGroup group, Channel channel) {
        this.host = host;
        this.port = port;
        this.group = group;
        this.channel = channel;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public boolean isListening() {
        return this.channel.isOpen();
    }

    @Override
    public void close() {
        if(this.channel.isOpen()) {
            this.channel.close().syncUninterruptibly();
        }

        try {
            this.group.shutdownGracefully().sync();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}