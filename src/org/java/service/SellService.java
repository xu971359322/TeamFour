package org.java.service;

import org.java.entity.Client;

import java.util.List;

public interface SellService {
    public List<Client> sellshow(int index , int size,String cname,String companyname,String cdescribe );

    public Integer getCount(String cname,String companyname,String cdescribe);
}
