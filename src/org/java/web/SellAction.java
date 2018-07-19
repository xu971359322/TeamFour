package org.java.web;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.java.entity.Client;
import org.java.service.SellService;
import org.java.service.impl.SellServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellAction extends SellBaseAction implements ServletRequestAware,ServletResponseAware {
    SellService service = new SellServiceImpl();
    private HttpServletRequest request;
    private HttpServletResponse response;
    //页面显示
    public String show(){
        int index = 1;
        int size = 10;

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

        return "show";
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
        int size = 10;
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
        return "show";
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
