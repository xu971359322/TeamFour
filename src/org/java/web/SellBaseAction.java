package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import org.java.dao.SellDao;
import org.java.dao.impl.SellDaoImpl;
import org.java.entity.Client;

public class SellBaseAction extends ActionSupport {
    SellDao dao = new SellDaoImpl();
    protected Client cl = new Client();

    public Client getU() {
        return cl;
    }

    public void setU(Client u) {
        this.cl = u;
    }
}
