package org.java.service.impl;

import org.hibernate.Transaction;
import org.java.dao.impl.ChartDaoImpl;
import org.java.util.HibernateUtil;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ChartServiceImpl {
    private ChartDaoImpl dao=new ChartDaoImpl();

    public List<Map<String,String>> showChartGX(String clientName,String year){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> list=dao.showChartGX(clientName,year);
        transaction.commit();
        return list;
    }

    public List<Map<String,String>> showChartFX(String type){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> list=dao.showChartFX(type);
        transaction.commit();
        return list;
    }

    public List<Map<String,String>> showChartFW(String yearInfo){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> list=dao.showChartFW(yearInfo);
        transaction.commit();
        return list;
    }

    public List<Map<String,String>> showChartLS(String clientName,String manger,Integer pageNo,Integer pageSize){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, String>> list = dao.showChartLS(clientName, manger,pageNo,pageSize);
        transaction.commit();
        return list;
    }

    public List<Map<String,String>> getYear (){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, String>> year = dao.getYear();
        transaction.commit();
        return year;
    }

    public BigInteger getCount(String companyname, String uname){
        Transaction transaction= HibernateUtil.getCurrentSession().beginTransaction();
        BigInteger count = dao.getCount(companyname, uname);
        transaction.commit();
        return count;
    }

}
