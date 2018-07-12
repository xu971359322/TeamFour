package org.java.web;

import org.java.service.UserService;
import org.java.service.impl.UserServiceImpl;

public class LoginAction extends LoginBaseAction {

    private UserServiceImpl service  = new UserServiceImpl();

    public String login(){
        u =service.selUser(u.getUsername(),u.getPwd());
        if(u!=null){
            session.setAttribute("user",u);
            System.out.println(u);
            return  "main";
        }else {
            err ="您输入的账号密码有误";
            return  "login";
        }
    }


}
