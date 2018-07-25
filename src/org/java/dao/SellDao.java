package org.java.dao;

import org.java.entity.Chance;
import org.java.entity.Client;
import org.java.entity.Plan;
import org.java.entity.User;

import java.util.List;

public interface SellDao {
    public  List<Client> sellshow(int index,int size,String cname,String companyname,String cdescribe);

    public Integer getCount(String cname,String companyname,String cdescribe);

    //添加用户
    public void add(Client c);

    public List<User> fp();

    public Client checkC(String cid);

    public User userName1(String cid);

    public int zp(String cid);

    public void chan(Chance chan);

    public List<Plan> planList(String cid);

    public Chance zpName(String cid);

    public void palAdd(Plan p);

    public void jhUpdate(int pid,String presult);

    public void jhAdd(Plan p);

    public void del(int pid);

    public void zt(int zt,String cid);
}
