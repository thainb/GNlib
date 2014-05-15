/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.test;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 10:52 PM
 */
import com.nova.packetlib.Client;
import com.nova.packetlib.Server;
import com.nova.packetlib.tcp.TcpSessionFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class PingServerTest {

    public static void main(String[] args) {
        SecretKey key = null;
        try {
            KeyGenerator gen = KeyGenerator.getInstance("AES");
            gen.init(128);
            key = gen.generateKey();
        } catch(NoSuchAlgorithmException e) {
            System.err.println("AES algorithm not supported, exiting...");
            return;
        }

        Server server = new Server("127.0.0.1", 25565, TestProtocol.class, new TcpSessionFactory()).bind();
        server.addListener(new ServerListener(key));

        Client client = new Client("127.0.0.1", 25565, new TestProtocol(key), new TcpSessionFactory());
        client.getSession().connect();
    }

}