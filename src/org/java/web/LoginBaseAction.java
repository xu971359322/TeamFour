package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LoginBaseAction extends ActionSupport implements ServletRequestAware {

    protected Map<String,Object> ses;
    protected HttpServletRequest request;
    protected HttpSession session;
    protected String err;

    protected User u =new User();

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.session =request.getSession();
        this.request =request;
    }
}
