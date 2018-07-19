package org.java.dao;

import org.java.entity.Client;

import java.util.List;

public interface SellDao {
    public  List<Client> sellshow(int index,int size,String cname,String companyname,String cdescribe);

    public Integer getCount(String cname,String companyname,String cdescribe);
}
