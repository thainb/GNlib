/*
 * Copyright (c) 2014 by ThaiNB
 */

package com.nova.packetlib.event.session;

/**
 * User: ThaiNB
 * Date: 5/15/14
 * Time: 9:08 AM
 */
/**
 * An event relating to sessions.
 */
public interface SessionEvent {

    /**
     * Calls the event.
     *
     * @param listener Listener to call the event on.
     */
    public void call(SessionListener listener);

}