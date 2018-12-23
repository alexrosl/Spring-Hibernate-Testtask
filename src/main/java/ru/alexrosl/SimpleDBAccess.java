package ru.alexrosl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleDBAccess {
    public SessionFactory sessionFactory;

    @Autowired
    public SimpleDBAccess(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String getVersion() {
        Session session = sessionFactory.openSession();
        String version = (String) session.createSQLQuery("select version()").uniqueResult();
        session.close();
        return version;
    }
}
