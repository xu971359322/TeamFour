package org.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.java.entity.User;
import org.java.util.HibernateUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl {

    @Test
    public User selUser(String username ,String pwd){
        Session ses = HibernateUtil.getCurrentSession();

        Criteria c =ses.createCriteria(User.class);

        c.add(Restrictions.eq("username",username));
        c.add(Restrictions.eq("pwd",pwd));

        User user = (User) c.uniqueResult();
        return user;
    }

}
