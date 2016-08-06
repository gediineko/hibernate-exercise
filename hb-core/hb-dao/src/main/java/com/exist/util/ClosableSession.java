package com.exist.util;

import org.hibernate.Session;

/**
 * Created by NazIsEvil on 06/08/2016.
 */
public class ClosableSession implements AutoCloseable {

    private Session session;

    public ClosableSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public void close() throws Exception {
        session.close();
    }
}
