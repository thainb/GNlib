package com.nova.packetlib.test;/*
 * Copyright (c) 2014 by ThaiNB
 */

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 10:46 PM
 */
import com.nova.packetlib.Client;
import com.nova.packetlib.Server;
import com.nova.packetlib.Session;
import com.nova.packetlib.Client;
import com.nova.packetlib.Server;
import com.nova.packetlib.Session;
import com.nova.packetlib.crypt.AESEncryption;
import com.nova.packetlib.crypt.PacketEncryption;
import com.nova.packetlib.packet.PacketProtocol;

import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;

public class TestProtocol extends PacketProtocol {

    private AESEncryption encrypt;

    @SuppressWarnings("unused")
    private TestProtocol() {
    }

    public TestProtocol(SecretKey key) {
        this.setSecretKey(key);
    }

    public void setSecretKey(SecretKey key) {
        this.register(0, PingPacket.class);
        try {
            this.encrypt = new AESEncryption(key);
        } catch(GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PacketEncryption getEncryption() {
        return this.encrypt;
    }

    @Override
    public void newClientSession(Client client, Session session) {
        session.addListener(new ClientSessionListener());
    }

    @Override
    public void newServerSession(Server server, Session session) {
        session.addListener(new ServerSessionListener());
    }

}