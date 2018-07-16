package org.java.service.impl;

import org.hibernate.Transaction;
import org.java.dao.impl.ServeClientDaoImpl;
import org.java.entity.Serveallocation;
import org.java.entity.Serveclient;
import org.java.util.HibernateUtil;

import java.util.List;
import java.util.Map;

public class ServiceClientServImpl {
    private  ServeClientDaoImpl dao = new ServeClientDaoImpl();

    public List<Map<String,String>> getDetail(Integer scId){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> list=dao.getDetail(scId);
        trans.commit();
        return list;
    }


    //项目经理下对应的服务
    public List<Map<String,String>> getService(String uid){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> list=dao.getService(uid);
        trans.commit();
        return list;
    }

    public void setType(Integer scId){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        dao.setTpye(scId);
        trans.commit();
    }

    //分配服务
    public void addGive(Serveallocation sa){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        dao.addGive(sa);
        trans.commit();

        setType(sa.getScId());
    }

    //得到所有的经理
    public  List<Map<String,String>> getUsers(){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> users= dao.getUser();
        trans.commit();
        return users;
    }

    //得到新创建的服务
    public List<Map<String,String>> newService(){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> newService= dao.getNewService();
        trans.commit();
        return newService;
    }

    //添加服务
    public void addService(Serveclient sc){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        dao.addService(sc);
        trans.commit();
    }

    //查询最大值id
    public  Integer getId(){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        Integer maxId =dao.getMaxId();
        trans.commit();
        return  maxId;

    }

    //得到服务类型
    public List<Map<String,String>> getDetail(){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> servedetail =dao.getServedetail();
        trans.commit();
        return servedetail;
    }

    //得到所有在册用户
    public List<Map<String,String>> getClient(){
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String,String>> client =dao.getClient();
        trans.commit();
        return client;
    }
}
