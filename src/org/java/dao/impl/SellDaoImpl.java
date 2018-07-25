package org.java.dao.impl;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.java.dao.SellDao;
import org.java.entity.Chance;
import org.java.entity.Client;
import org.java.entity.Plan;
import org.java.entity.User;
import org.java.util.HibernateUtil;
import org.junit.Test;

import java.util.List;

@SuppressWarnings("unchecked")
public class SellDaoImpl implements SellDao {

    @Override
    public List<Client> sellshow(int index, int size, String cname, String companyname, String cdescribe){
        Session ses = HibernateUtil.getCurrentSession();
        Criteria c = ses.createCriteria(Client.class);
        if (cname!=null&&!cname.equals("")){
            c.add(Restrictions.ilike("cname",cname, MatchMode.ANYWHERE));
        }
        if (companyname!=null&&!companyname.equals("")){
            c.add(Restrictions.ilike("companyname",companyname,MatchMode.ANYWHERE));
        }
        if (cdescribe!=null&&!cdescribe.equals("")){
            c.add(Restrictions.ilike("cdescribe",cdescribe,MatchMode.ANYWHERE));
        }
        //c.setFirstResult((index-1)*size);
        //c.setMaxResults(index*size);
        List<Client> list = c.list();

        System.out.println("--------------------------------------------------");
        System.out.println(list.size());
        System.out.println("SELECT * FROM CLIENT LIMIT "+(index-1)*size+","+index*size+"");
        System.out.println("index值\t"+index);
        System.out.println("index-1*size\t"+(index-1)*size);
        System.out.println("index*size\t"+index*size);
        System.out.println("--------------------------------------------------");
        return list;
    }

    @Test
    public Integer getCount(String cname,String companyname,String cdescribe){
        Session ses = HibernateUtil.getCurrentSession();
        Criteria c = ses.createCriteria(Client.class);
        if (cname!=null&&!cname.equals("")){
            c.add(Restrictions.ilike("cname",cname, MatchMode.ANYWHERE));
        }
        if (companyname!=null&&!companyname.equals("")){
            c.add(Restrictions.ilike("companyname",companyname,MatchMode.ANYWHERE));
        }
        if (cdescribe!=null&&!cdescribe.equals("")){
            c.add(Restrictions.ilike("cdescribe",cdescribe,MatchMode.ANYWHERE));
        }

        c.setProjection(Projections.count("cid"));
        Integer count = Integer.parseInt(c.uniqueResult().toString());
        return count;
    }

    @Override
    public void add(Client c) {
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(c);
    }

    @Override
    public List<User> fp() {

        Session ses = HibernateUtil.getCurrentSession();
        Criteria c = ses.createCriteria(User.class);
        c.add(Restrictions.gt("identity",0));
        c.add(Restrictions.lt("identity",3));
        List<User> list = c.list();

        return list;
    }

    @Override
    public Client checkC(String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "from Client where cid =:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("cid",cid);
        List<Client> list = query.list();
        Client cli = list.get(0);
        return cli;
    }

    @Override
    public User userName1(String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "FROM Client WHERE cid =:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("cid",cid);
        List<Client> list = query.list();
        Client u = list.get(0);
        return userName(u.getUid());
    }

    @Override
    public int zp(String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "update Client set cstatus=1 where cid=:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("cid",cid);
        int rows = query.executeUpdate();
        return rows;
    }

    @Override
    public void chan(Chance chan) {
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(chan);
    }

    @Override
    public List<Plan> planList(String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = " FROM Plan where cid=:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("cid",cid);
        List<Plan> list = query.list();
        System.out.println(list.size());
        return list;
    }

    @Override
    public Chance zpName(String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = " FROM Chance where cid=:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("cid",cid);
        List<Chance> list = query.list();
        Chance ch = new Chance();
        if (list.size()>0){
            ch = list.get(0);
        }
        return ch;
    }

    @Override
    public void palAdd(Plan p) {
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(p);
    }

    @Override
    public void jhUpdate(int pid, String presult) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "update Plan set presult=:presult where pid=:pid";
        Query query = ses.createQuery(hql);
        query.setParameter("presult",presult);
        query.setParameter("pid",pid);
        int rows = query.executeUpdate();
    }

    @Override
    public void jhAdd(Plan p) {
        Session ses = HibernateUtil.getCurrentSession();
        ses.save(p);
    }

    @Override
    public void del(int pid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "DELETE from Plan where pid=:pid";
        Query query = ses.createQuery(hql);
        query.setParameter("pid",pid);
        int rows = query.executeUpdate();
    }

    @Override
    public void zt(int zt,String cid) {
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "update Client set ctype=:zt where cid=:cid";
        Query query = ses.createQuery(hql);
        query.setParameter("zt",zt);
        query.setParameter("cid",cid);
        int rows = query.executeUpdate();
    }


    public User userName(String uid){
        Session ses = HibernateUtil.getCurrentSession();
        String hql = "from User where uid=:id";
        Query query = ses.createQuery(hql);
        query.setParameter("id",uid);
        List<User> list = query.list();
        User u = list.get(0);
        return u;
    }


}
