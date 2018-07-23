package org.java.web;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.*;
import org.java.entity.Chance;
import org.java.entity.Client;
import org.java.entity.Plan;
import org.java.entity.User;
import org.java.service.SellService;
import org.java.service.impl.SellServiceImpl;
import com.alibaba.fastjson.JSON;
import org.java.util.HibernateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SellAction extends SellBaseAction implements ServletRequestAware,ServletResponseAware {
    SellService service = new SellServiceImpl();
    private HttpServletRequest request;
    private HttpServletResponse response;
    //页面显示
    public String show(){
        int index = 1;
        int size = 5;
        int count = service.getCount(null,null,null);

        //计算当前信息页数
        count = count%size !=0 ? count/size+1 :count/size;

        List<Client> list = service.sellshow(index,size,null,null,null);


        request.getSession().setAttribute("sellcount",count);
        request.getSession().setAttribute("sellList",list);
        request.getSession().setAttribute("sellIndex",index);
        request.getSession().setAttribute("sellSize",size);

        return "show";
    }
    //分页显示
    public String change(){
        Integer index = Integer.parseInt(request.getParameter("index"));
        Integer size = Integer.parseInt(request.getSession().getAttribute("sellSize").toString()) ;

        List<Client> list = service.sellshow(index,size,null,null,null);

        request.getSession().setAttribute("sellList",list);
        request.getSession().setAttribute("sellIndex",index);

        String p =request.getParameter("p");
        if(p.equals("1")){
            return "show";
        }else{
            return "plan";
        }

    }

    //分页搜索
    public void json() throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int index = 1;
        int size = 10;
        String cname=request.getParameter("cname");
        String companyname=request.getParameter("companyname");
        String cdescribe=request.getParameter("cdescribe");


        request.getSession().setAttribute("cname",cname);
        request.getSession().setAttribute("companyname",companyname);
        request.getSession().setAttribute("cdescribe",cdescribe);



        PrintWriter out = response.getWriter();

        String json = JSON.toJSONString("123");
        out.write(json);
        out.flush();
        out.close();
    }

    public String jsonShow(){
        int index = 1;
        int size = 5;
        String cname =(String) request.getSession().getAttribute("cname");
        String companyname =(String) request.getSession().getAttribute("companyname");
        String cdescribe =(String) request.getSession().getAttribute("cdescribe");


        int count = service.getCount(cname,companyname,cdescribe);
        count = count%size !=0 ? count/size+1 :count/size;
        System.out.println(count);
        List<Client> list = service.sellshow(index,size,cname,companyname,cdescribe);

        request.setAttribute("cname",cname);
        request.setAttribute("companyname",companyname);
        request.setAttribute("cdescribe",cdescribe);

        request.getSession().setAttribute("sellList",list);
        request.getSession().setAttribute("sellcount",count);
        request.getSession().setAttribute("sellIndex",index);
        request.getSession().setAttribute("sellSize",size);
        String p =request.getParameter("p");
        if(p.equals("1")){
            return "show";
        }else{
            return "plan";
        }
    }

    //添加
    public String add(){
        User uid = (User) request.getSession().getAttribute("user");
        c.setCtype(0);
        c.setUid(uid.getUid());
        c.setCstatus(0);
        service.add(c);
        return show();
    }

    public String update(){
        List<User> userList = service.fq();
        String cid = request.getParameter("cid");

        String username = service.userName1(cid);
        Client clientUser = service.checkC(cid);

        request.getSession().setAttribute("sell_cid",cid);
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("clienUser",clientUser);
        request.getSession().setAttribute("userList",userList);

        return "update";
    }
    public String zp() throws Exception {

        String cid =(String) request.getSession().getAttribute("sell_cid");
        String zp2 = request.getParameter("zp");
        String string = request.getParameter("ctime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Chance chan = new Chance();
        chan.setChTime(sdf.parse(string));
        chan.setUid(zp2);
        chan.setCid(cid);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println( service.zp(cid));
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        service.chanAdd(chan);

        return show();
    }







    public String plan(){
        String str = show();
        return "plan";
    }


    public String page(){
        //获取cid 查找计划表 查找用户姓名
        String cid = request.getParameter("cid");
        if (cid==null){
            cid = (String) request.getSession().getAttribute("cid");
        }
        List<Plan> planList = service.planListp(cid);

        String username = service.userName1(cid);
        Client clientUser = service.checkC(cid);
        Chance chance = service.zpName(cid);
        String userZpName = service.userZpName(chance.getUid());

        request.getSession().setAttribute("cid",cid);
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("userZpName",userZpName);
        request.getSession().setAttribute("clientUser",clientUser);
        request.getSession().setAttribute("ctime",chance.getChTime());
        request.getSession().setAttribute("planList",planList);

        return "page";
    }

    public String jhUpdate(){
        int pid = Integer.parseInt(request.getParameter("pid"));
        String cid = (String) request.getSession().getAttribute("cid");
        String presult = request.getParameter("presult");

        service.jhUpdate(pid,presult);
        List<Plan> planList = service.planListp(cid);

        request.getSession().setAttribute("planList",planList);
        return "page";

    }
    public String jhAdd() throws Exception{
        String ptime = request.getParameter("ptime");
        String pcontent = request.getParameter("pcontent");
        String cid = (String) request.getSession().getAttribute("cid");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Chance chan = new Chance();
        Plan p = new Plan();
        p.setCid(cid);
        p.setPcontent(pcontent);
        p.setPtime(sdf.parse(ptime));
        p.setPresult("");
        service.jhAdd(p);

//        String presult = request.getParameter("presult");
//
//        service.jhUpdate(cid,presult);
        List<Plan> planList = service.planListp(cid);

        request.getSession().setAttribute("planList",planList);
        return "page";
    }

    //删除计划项
    public String jhDel(){
        Integer pid = Integer.parseInt(request.getParameter("pid"));
        String cid = (String) request.getSession().getAttribute("cid");
        service.del(pid);
        List<Plan> planList = service.planListp(cid);

        Chance chance = service.zpName(cid);
        Client clientUser = service.checkC(cid);
        String userZpName = service.userZpName(chance.getUid());

        request.getSession().setAttribute("cid",cid);
        request.getSession().setAttribute("userZpName",userZpName);
        request.getSession().setAttribute("clientUser",clientUser);
        request.getSession().setAttribute("ctime",chance.getChTime());
        request.getSession().setAttribute("planList",planList);
        return "page";
    }


    public String kfUp(){
        Integer zt = Integer.parseInt(request.getParameter("zt"));
        String cid = (String) request.getSession().getAttribute("cid");
        service.zt(zt,cid);

        String str = page();
        return str;
    }


    public String add33(){
        return "add33";
    }

    @Override
    public void setServletRequest(HttpServletRequest req) {
        request = req;
    }

    @Override
    public void setServletResponse(HttpServletResponse res) {
        this.response = res;
    }
}
