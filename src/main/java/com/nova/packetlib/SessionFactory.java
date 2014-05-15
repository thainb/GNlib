/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 9:13 AM
 */
/**
 * A factory for creating sessions.
 */
public interface SessionFactory {

    /**
     * Creates a client session.
     *
     * @param client Client to create the session for.
     * @return The created session.
     */
    public Session createClientSession(Client client);

    /**
     * Creates a server network listener.
     *
     * @param server Server to create the listener for.
     * @return The created listener.
     */
    public ConnectionListener createServerListener(Server server);

}