package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.java.entity.Dispose;
import org.java.entity.SelService;
import org.java.entity.Serveallocation;
import org.java.entity.Serveclient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ServiceBaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,Serializable{

    protected HttpSession session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected Serveclient sc;
    protected Serveallocation sa;
    protected Dispose dis;
    protected SelService ss;

    protected Integer status;
    protected Integer scId;

    //所有客户经理
    protected  List<Map<String,String>> users;
    //服务详情
    protected  List<Map<String,String>> datail;
    //新建服务
    protected  List<Map<String,String>> newService;
    //服务类型
    protected List<Map<String,String>> servedetail;
    //客户姓名
    protected List<Map<String,String>> client;
    //id服务
    protected Integer maxId;

    public SelService getSs() {
        return ss;
    }

    public void setSs(SelService ss) {
        this.ss = ss;
    }

    public Dispose getDis() {
        return dis;
    }

    public void setDis(Dispose dis) {
        this.dis = dis;
    }

    public Integer getScId() {

        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Map<String, String>> getDatail() {
        return datail;
    }

    public void setDatail(List<Map<String, String>> datail) {
        this.datail = datail;
    }

    public Serveallocation getSa() {
        return sa;
    }

    public void setSa(Serveallocation sa) {
        this.sa = sa;
    }

    public List<Map<String, String>> getUsers() {
        return users;
    }

    public void setUsers(List<Map<String, String>> users) {
        this.users = users;
    }

    public List<Map<String, String>> getNewService() {
        return newService;
    }

    public void setNewService(List<Map<String, String>> newService) {
        this.newService = newService;
    }

    public Serveclient getSc() {
        return sc;
    }

    public void setSc(Serveclient sc) {
        this.sc = sc;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public List<Map<String, String>> getClient() {
        return client;
    }

    public void setClient(List<Map<String, String>> client) {
        this.client = client;
    }

    public List<Map<String, String>> getServedetail() {
        return servedetail;
    }

    public void setServedetail(List<Map<String, String>> servedetail) {
        this.servedetail = servedetail;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request =request;
        this.session =request.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response =response;
    }
}
