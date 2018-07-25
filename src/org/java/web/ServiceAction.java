package org.java.web;

/*import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONObject;*/
import org.java.entity.Clienphone;
import org.java.entity.User;
import org.java.service.impl.ServiceClientServImpl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceAction extends ServiceBaseAction{

    private ServiceClientServImpl service = new ServiceClientServImpl();

    //模糊查询
    public String sel(){
        User user =(User) session.getAttribute("user");
        ss.setUid(user.getUid());
        users =service.getUsers();
        servedetail =service.getDetail();
        //查询状态
        status =ss.getScstatus();
        //模糊查询出来的集合
        newService = service.selSeach(ss);
        System.out.println(newService);
        return "give";
    }

    public String lastDetail(){
        status =4;
        datail =service.getOver(scId);
        return "dispose";
    }

    //已归档
    public String last(){
        users =service.getUsers();
        servedetail =service.getDetail();
        newService =service.selLast();
        return "give";
    }


    //服务反馈
    public String over(){
        status =3;
        datail =service.getOver(scId);
        return "dispose";
    }

    //已处理
    public String dealOver(){
        users =service.getUsers();
        servedetail =service.getDetail();
        //已处理的服务
        newService =service.getDealOver();

        return "give";
    }

    public String addDeal(){
        User user =(User) session.getAttribute("user");
        dis.setUid(user.getUid());
        if(status==2){
            System.out.println(dis);
            service.addDisponse(dis);
            return dis();
        }
        if(status==3){
            System.out.println(dis);
            service.updateDispose(dis);
            return dealOver();
        }

        return NONE;
    }

    public String deal(){
        status =2;
        datail =service.getDetail(scId);
        System.out.println(datail.get(0).values());
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

//        Map<String ,List<Map<String,String>>> map =new HashMap<String ,List<Map<String,String>>>();
//        map.put("userList",userList);
//        map.put("giveService",giveService);
//
//        String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd",SerializerFeature.QuoteFieldNames,
//                SerializerFeature.WriteMapNullValue
//                ,SerializerFeature.WriteNullNumberAsZero
//        );
       // out.write(json);
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
        return "addservice";
    }

    public String load(){
        servedetail =service.getDetail();
        client =service.getClient();
        session.setAttribute("clients",client);
        maxId =service.getId();
        return "addservice";
    }
}
