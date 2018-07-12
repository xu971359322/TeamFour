package org.java.service.impl;

import org.hibernate.Transaction;
import org.java.dao.impl.LoginDaoImpl;
import org.java.entity.User;
import org.java.service.UserService;
import org.java.util.HibernateUtil;

public class UserServiceImpl implements UserService{
    LoginDaoImpl dao = new LoginDaoImpl();

    public User selUser(String username ,String pwd){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        System.out.println(username+" "+pwd);
        User user = dao.selUser(username,pwd);
        trans.commit();

        return user;
    }
}
