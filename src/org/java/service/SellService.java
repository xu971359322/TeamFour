package org.java.service;

import org.java.entity.Chance;
import org.java.entity.Client;
import org.java.entity.Plan;
import org.java.entity.User;

import java.util.List;

public interface SellService {
    public List<Client> sellshow(int index , int size,String cname,String companyname,String cdescribe );

    public Integer getCount(String cname,String companyname,String cdescribe);

    public void add(Client c);

    public List<User> fq();

    public Client checkC(String cid);

    public String userName1(String cid);

    public int zp(String cid);

    public void chanAdd(Chance c);

    public List<Plan> planListp(String cid);

    public Chance zpName(String cid);

    public String userZpName(String uid);

    public void palAdd(Plan p);

    public void jhUpdate(int pid, String presult);

    public void jhAdd(Plan p);

    public void del(int pid);

    public void zt(int zt,String cid);
}
