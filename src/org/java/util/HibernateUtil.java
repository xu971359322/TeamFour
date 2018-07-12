package org.java.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static{
        Configuration config = new Configuration().configure();
        FACTORY = config.buildSessionFactory();
    }

    public static Session getCurrentSession(){
        return FACTORY.getCurrentSession();
    }

}
