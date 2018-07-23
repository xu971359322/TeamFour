package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import org.java.dao.SellDao;
import org.java.dao.impl.SellDaoImpl;
import org.java.entity.Chance;
import org.java.entity.Client;

public class SellBaseAction extends ActionSupport {
    SellDao dao = new SellDaoImpl();

    protected Client c = new Client();

    public Client getC() {
        return c;
    }

    public void setC(Client cl) {
        this.c = cl;
    }

}
