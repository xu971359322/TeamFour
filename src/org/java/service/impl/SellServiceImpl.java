package org.java.service.impl;

import org.hibernate.Transaction;
import org.java.dao.SellDao;
import org.java.dao.impl.SellDaoImpl;
import org.java.entity.Client;
import org.java.service.SellService;
import org.java.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SellServiceImpl implements SellService {
    SellDao dao = new SellDaoImpl();
    public List<Client> sellshow(int index ,int size,String cname,String companyname,String cdescribe ) {
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Client> list = dao.sellshow(index,size,cname,companyname,cdescribe);
        return list;
    }
    //分页
    @Override
    public Integer getCount(String cname,String companyname,String cdescribe) {
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        int count = dao.getCount(cname,companyname,cdescribe);
        return count;
    }
}
