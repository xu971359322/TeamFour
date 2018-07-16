package org.java.web;

import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.java.entity.Clienphone;
import org.java.entity.User;
import org.java.service.impl.ServiceClientServImpl;
import org.omg.PortableServer.ServantRetentionPolicyValue;

import javax.servlet.Servlet;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ServiceAction extends ServiceBaseAction{

    private ServiceClientServImpl service = new ServiceClientServImpl();

    public String deal(){
        System.out.println("1231231");
        datail =service.getDetail(scId);

        return "dispose";
    }

    public String dis(){
        User user =(User) session.getAttribute("user");
        //users =service.getUsers();
        servedetail =service.getDetail();
        newService =service.getService(user.getUid());
        return "give";
    }

    public void giveUser() throws  Exception{
        response.setContentType("html/text;charset=utf-8");
        service.addGive(sa);
        servedetail =service.getDetail();

        List<Map<String,String>> userList =service.getUsers();
        List<Map<String,String>> giveService =service.newService();

        System.out.println(userList);
        System.out.println(giveService);

        PrintWriter out = response.getWriter();

        JSONObject json =new JSONObject();

        json.put("userList",userList);
        //json.put("giveService",giveService);


        out.write(json.toString());
        out.flush();
        out.close();

    }

    public String give(){
        users =service.getUsers();
        servedetail =service.getDetail();
        newService =service.newService();
        return "give";
    }

    public String add(){
        User user =(User) session.getAttribute("user");
        sc.setUid(user.getUid());
        sc.setScStatus(0);
        System.out.println(sc);
        service.addService(sc);
        return NONE;
    }

    public String load(){
        servedetail =service.getDetail();
        client =service.getClient();
        maxId =service.getId();
        return "addservice";
    }
}
