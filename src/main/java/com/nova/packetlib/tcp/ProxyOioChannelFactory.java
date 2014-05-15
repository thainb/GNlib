/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.tcp;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 2:54 PM
 */
import io.netty.bootstrap.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.oio.OioSocketChannel;

import java.net.Proxy;
import java.net.Socket;

public class ProxyOioChannelFactory implements ChannelFactory<OioSocketChannel> {

    private Proxy proxy;

    public ProxyOioChannelFactory(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public OioSocketChannel newChannel(EventLoop eventLoop) {
        return new OioSocketChannel(eventLoop, new Socket(this.proxy));
    }

}