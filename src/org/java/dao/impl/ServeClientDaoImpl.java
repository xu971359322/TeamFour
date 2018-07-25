package org.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.java.entity.Dispose;
import org.java.entity.SelService;
import org.java.entity.Serveallocation;
import org.java.entity.Serveclient;
import org.java.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class ServeClientDaoImpl {

    public List<Map<String,String>> selSeach(SelService sel){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="SELECT sc.sc_id scid ,\n" +
                "        c.companyname ,\n" +
                "        sc_describe scdescribe,\n" +
                "\tsd.sd_name sdname,\n" +
                "\tu.uname,\n" +
                "\tsc.Sc_settime TIME\n" +
                "        FROM serveclient sc ,servedetail sd,CLIENT c,USER u,serveallocation sa\n" +
                "        WHERE sd.sd_id =sc.sd_id \n" +
                "        AND c.cid =sc.cid\n" +
                "        AND u.uid=sc.uid\n" +
                "        AND sc.sc_id = sa.sc_id" ;

        if(sel.getScstatus()!=null&&sel.getScstatus()!=-1){
            sql+=" and sc_status=" + (sel.getScstatus()-1);
            if(sel.getScstatus()==2 || sel.getScstatus()==3){
                sql+=" and sa.uid='"+sel.getUid()+"'";
            }
        }
        if(sel.getSdId()!=null&&sel.getSdId()!=-1){
            sql+=" AND sc.sd_id=" +sel.getSdId();
        }
        if(sel.getCid()!=null&&!sel.getCid().equals("-1")){
            sql+="  and c.cid= '"+sel.getCid()+"'";
        }
        if(sel.getContent()!=null && !sel.getContent().equals("")){
            sql+=" AND sc_describe LIKE '%"+sel.getContent()+"%' ";
        }
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        if(sel.getBeginTime()!=null&&!sel.getBeginTime().equals("")){
            String date= format.format(sel.getBeginTime());
            sql+="  and sc.Sc_settime >  '"+date+"'";
        }
        if(sel.getEndTime()!=null&&!sel.getEndTime().equals("")){
            String date= format.format(sel.getBeginTime());
            sql+="  and sc.Sc_settime <  '"+date+"'";
        }
        Query query =ses.createSQLQuery(sql);
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

    public List<Map<String,String>> selLast(){
        Session ses = HibernateUtil.getCurrentSession();
        Query query = ses.getNamedQuery("selLast");
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;

    }

    public void delAllocation(Integer scId){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="delete from serveallocation where sc_id =?";
        Query query =ses.createSQLQuery(sql);
        query.setInteger(0,scId);
        query.executeUpdate();
    }

    //删除没有达到满意度的服务
    public void delService(Integer diId){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="delete from dispose where di_id =?";
        Query query =ses.createSQLQuery(sql);
        query.setInteger(0,diId);
        query.executeUpdate();

    }

    //满意度达到要求就归档
    public void updateDispose(Dispose dis){
        Session ses = HibernateUtil.getCurrentSession();
        String sql ="update dispose set di_result=:result,faction=:faction where di_id=:diId";
        Query query =ses.createSQLQuery(sql);
        query.setString("result",dis.getDiResult());
        query.setInteger("faction",dis.getFaction());
        query.setInteger("diId",dis.getDiId());
        query.executeUpdate();

    }

    public List<Map<String,String>> getOver(Integer seId){
        Session ses = HibernateUtil.getCurrentSession();
        Query query = ses.getNamedQuery("overService");
        query.setInteger(0,seId);
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    public List<Map<String,String>> getDealOver(){
        Session ses = HibernateUtil.getCurrentSession();
        Query query =ses.getNamedQuery("dealService");
        List<Map<String,String>> list = query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    public void addDisponse(Dispose dis){
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(dis);
    }
    public void updateType(Integer status,Integer seId){
        Session ses = HibernateUtil.getCurrentSession();
        String hql="UPDATE Serveclient SET scStatus =? WHERE scId=?";
        Query query =ses.createQuery(hql);
        query.setInteger(0,status);
        query.setInteger(1,seId);
        query.executeUpdate();
    }

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
