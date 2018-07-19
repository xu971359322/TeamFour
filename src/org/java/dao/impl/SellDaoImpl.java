package org.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.java.dao.SellDao;
import org.java.entity.Client;
import org.java.entity.User;
import org.java.util.HibernateUtil;
import org.junit.Test;

import java.util.List;

public class SellDaoImpl implements SellDao {

    @Override
    public List<Client> sellshow(int index, int size, String cname, String companyname, String cdescribe) {Session ses = HibernateUtil.getCurrentSession();
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
        c.setFirstResult((index-1)*size);
        c.setMaxResults(index*size);
        List<Client> list = c.list();
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
}
