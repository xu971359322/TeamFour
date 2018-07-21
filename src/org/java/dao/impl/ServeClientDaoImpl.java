package org.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.java.entity.Serveallocation;
import org.java.entity.Serveclient;
import org.java.util.HibernateUtil;

import java.util.List;
import java.util.Map;

public class ServeClientDaoImpl {

    public List<Map<String,String>> getDetail(Integer scId){
        Session ses = HibernateUtil.getCurrentSession();
        Query query =ses.getNamedQuery("datelService");
        query.setInteger(0,scId);
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    //项目经理下面的服务项目
    public List<Map<String,String>> getService(String uid){
        Session ses = HibernateUtil.getCurrentSession();
        //List<Map<String,String>> list =ses.getNamedQuery("getService").setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();;
        Query query =ses.getNamedQuery("getService");
        query.setString(0,uid);
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    public void addGive(Serveallocation sa){
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(sa);

    }

    public void setTpye(Integer seId){
        Session ses = HibernateUtil.getCurrentSession();
        String hql="UPDATE Serveclient SET scStatus =1 WHERE scId=?";
        Query query =ses.createQuery(hql);
        query.setInteger(0,seId);
        query.executeUpdate();
    }

    //所有的项目经理
    public List<Map<String,String>> getUser(){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="select uid,uname from user WHERE identity =2";
        Query query =ses.createSQLQuery(sql);
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List<Map<String,String>> users =query.list();

        return users;
    }

    //新建服务
    public List<Map<String,String>> getNewService(){
        Session ses = HibernateUtil.getCurrentSession();

        List<Map<String,String>> newService =ses.getNamedQuery("newService").setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return newService;
    }

    //添加服务
    public void addService(Serveclient sc){
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(sc);
    }

    public Integer getMaxId(){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="select max(sc_id) from serveclient";
        Query query =ses.createSQLQuery(sql);
        Integer max =Integer.parseInt(query.uniqueResult().toString());

        return max;
    }

    //得到服务类型
    public List<Map<String,String>> getServedetail(){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="SELECT * FROM servedetail";
        Query query =ses.createSQLQuery(sql);
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List<Map<String,String>> servedetail =query.list();

        return servedetail;
    }

    //得到客户
    public List<Map<String ,String>> getClient(){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="select cid,companyname from client WHERE ctype IN (0,1,3)";
        Query query =ses.createSQLQuery(sql);
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List<Map<String,String>> client =query.list();

        return client;
    }
}
