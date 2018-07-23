package org.java.service.impl;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.java.dao.SellDao;
import org.java.dao.impl.SellDaoImpl;
import org.java.entity.Chance;
import org.java.entity.Client;
import org.java.entity.Plan;
import org.java.entity.User;
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

    @Override
    public void add(Client c) {
        Transaction trans = HibernateUtil.getCurrentSession().beginTransaction();
        dao.add(c);
        trans.commit();
    }

    @Override
    public List<User> fq() {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        List<User> list = dao.fp();
        return list;
    }

    @Override
    public Client checkC(String cid) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        return dao.checkC(cid);
    }
    @Override
    public String userName1(String cid){
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        return dao.userName1(cid);
    }

    @Override
    public int zp(String cid) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        int rows = dao.zp(cid);
        tran.commit();
        return rows;
    }

    @Override
    public void chanAdd(Chance c){
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.chan(c);
        tran.commit();
    }

    @Override
    public List<Plan> planListp(String cid) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        List<Plan> list = dao.planList(cid);
        return list;
    }
    @Override
    public Chance zpName(String cid){
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        return dao.zpName(cid);
    }

    @Override
    public String userZpName(String uid){
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        return  dao.userZpName(uid);
    }

    @Override
    public void palAdd(Plan p) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.palAdd(p);
        tran.commit();
    }

    @Override
    public void jhUpdate(int pid, String presult) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.jhUpdate(pid,presult);
        tran.commit();

    }

    @Override
    public void jhAdd(Plan p) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.jhAdd(p);
        tran.commit();

    }

    @Override
    public void del(int pid) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.del(pid);
        tran.commit();
    }

    @Override
    public void zt(int zt,String cid) {
        Transaction tran = HibernateUtil.getCurrentSession().beginTransaction();
        dao.zt(zt,cid);
        tran.commit();
    }
}
