package org.java.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.java.dao.ChartDao;
import org.java.util.HibernateUtil;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ChartDaoImpl implements ChartDao{

    public List<Map<String,String>> getYear() {
        Session session = HibernateUtil.getCurrentSession();
        String sql = "select o.cid,SUBSTRING(otime,1,4) AS year from orders o GROUP BY year ORDER BY year DESC";
        List<Map<String, String>> list = session.createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        for (Map<String, String> info : list) {
            System.out.println(info);
        }
        return list;
    }


    public BigInteger getCount(String companyname,String uname){
        Session session = HibernateUtil.getCurrentSession();
        String sql="select count(*) as count from loseclient l,client c,user u where l.cid=c.cid and c.uid=u.uid";
        StringBuffer sb=new StringBuffer(sql);

        if(companyname!=null&& !"".equals(companyname)){
            sb.append(" and c.companyname like '%"+companyname+"%'");
        }
        if(uname!=null&& !"".equals(uname)){
            sb.append(" and u.uname LIKE '%"+uname+"%'");
        }
        Query query=session.createSQLQuery(sb.toString());

        BigInteger count= (BigInteger) query.uniqueResult();
        return count;
    }

    public List<Map<String, String>> showChartGX(String clientName,String year) {
        Session session = HibernateUtil.getCurrentSession();

        StringBuffer sb=new StringBuffer("SELECT g.gid as gid ,c.companyname as companyname ,(o.ocount*g.gprice) AS sum ,\n" +
                "        CASE o.ostutas\n" +
                "        WHEN 0 THEN '未回款'\n" +
                "        WHEN 1 THEN '已回款'\n" +
                "        END AS result,\n" +
                "        SUBSTRING(o.otime,1,4) AS `year`\n"+
                "        FROM goods g,`orders` o,`client` c WHERE o.gid=g.gid AND c.cid=o.cid");

        if(clientName!=null&& !"".equals(clientName)){
            sb.append(" and c.companyname like '%"+clientName+"%'");
        }
        if(year!=null&& !"".equals(year)){
            if(!year.equals("-1")){
                sb.append(" and   SUBSTRING(o.otime,1,4)='"+year+"'");
            }
        }

        System.out.println(sb.toString());

        List<Map<String, String>> list = session.createSQLQuery(sb.toString()).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        System.out.println("编号" + "\t" + "客户名称" + "\t" + "订单金额（元）" + "\t" + "状态"+"\t"+"年份");
        for (Map<String, String> info : list) {
            System.out.println(info);
        }
        return list;
    }

    public List<Map<String,String>> showChartFX(String type){
        Session session = HibernateUtil.getCurrentSession();
        List<Map<String, String>> list=null;
        if ("level".equals(type)){
             list= session.getNamedQuery("level").setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        }else if ("satisfaction".equals(type)){
            list= session.getNamedQuery("satisfaction").setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        }else if ("credit".equals(type)){//信用度
            list= session.getNamedQuery("credit").setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        }
        for (Map<String, String> info : list) {
            System.out.println(info);
        }
        return list;
    }


    public List<Map<String,String>> showChartFW(String yearInfo){
        Session session = HibernateUtil.getCurrentSession();
        List<Map<String, String>> list=null;
        if(yearInfo!=null&&!"".equals(yearInfo)){
            if (!yearInfo.equals("-1")){
                String sql="SELECT temp.sd_id,se.sd_name as sd_name ,temp.count as count FROM servedetail se,(SELECT sd_id,COUNT(sc_id) AS `count`\n" +
                        "FROM serveclient where SUBSTRING(Sc_settime,1,4) ='"+yearInfo+"' GROUP BY sd_id) temp WHERE se.sd_id=temp.sd_id";
                list = session.createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
            }
        }else{
            String sql="SELECT temp.sd_id,se.sd_name as sd_name ,temp.count as count FROM servedetail se,(SELECT sd_id,COUNT(sc_id) AS `count`\n" +
                    "FROM serveclient GROUP BY sd_id) temp WHERE se.sd_id=temp.sd_id";
            list = session.createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        }
        for (Map<String, String> info : list) {
            System.out.println(info);
        }
        return list;
    }

    public List<Map<String,String>> showChartLS(String clientName,String manger,Integer pageNo,Integer pageSize){
        Session session = HibernateUtil.getCurrentSession();

        StringBuffer sb=new StringBuffer(" SELECT lc_id,SUBSTRING(lc_time,1,4) AS `year`,`client`.companyname as companyname ,`client`.cname,temp.uname as uname,le.lc_content as lc_content\n" +
                "        FROM loseclient le ,CLIENT `client`,\n" +
                "        (SELECT user.uname uname,client.companyname,client.cid AS cid FROM `client` `client`,`user` `user` WHERE client.uid=user.uid AND client.ctype=4) temp\n" +
                "        WHERE le.cid=`client`.cid AND client.cid=temp.cid");

        if(clientName!=null&& !"".equals(clientName)){
            sb.append(" and client.companyname like '%"+clientName+"%'");
        }

        if(manger!=null&& !"".equals(manger)){
            sb.append(" and temp.uname like '%"+manger+"%'");
        }

        List<Map<String, String>> list = session.createSQLQuery(sb.toString()).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).
                setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        for (Map<String, String> info : list) {
            System.out.println(info);
        }

        return list;
    }
}