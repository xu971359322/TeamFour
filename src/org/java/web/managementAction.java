package org.java.web;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.java.entity.Clienphone;
import sun.security.util.BigInt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

public class managementAction  extends  ManagementBaseAction implements ServletRequestAware {
    protected HttpServletRequest req;
    protected HttpSession ses;


//    确定流失
    public String updatemeasure(){
        String  id=req.getParameter("id");
        inf.updatemeasure(id);

        List<Map<String, Object>> list1= inf.select1();
        ses.setAttribute("list1",list1);
        ses.setAttribute("list1count",list1.size() );
        return "ww";
    }
//    添加流失措施
    public  String addmeasure(){
    String name= req.getParameter("name");

        List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("inquirer");
        String id=sz.get(0).get("id").toString();

        inf.addmeasure(name,id);

        List<Map<String, Object>> list1= inf.select1();
        ses.setAttribute("list1",list1);
        ses.setAttribute("list1count",list1.size() );

        return "addmeasure";
    }
//    查询流失措施
    public  String selectmeasure(){
        String id=req.getParameter("id");
        //人
        List<Map<String, Object>> inquirer=inf.inquirer(id);
        //措施
        List<Map<String, Object>> measure=inf.measure(id);
        ses.setAttribute("inquirer",inquirer);

        ses.setAttribute("measure",measure);

        return  "ww";
    }
//    显示客户流失管理
    public String  showclient(){
        try {
            //原有日期格式
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            List<Map<String, Object>> list= inf.contactall();
        for (Map<String, Object> n:
             list) {
            String time=n.get("time").toString();

            String str=sdf.format(new Date());


                String d1 = time;
                String d2 = str;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = format.parse(d1);
                Date date2 = format.parse(d2);

                // d2减去d1是多少
                long day = (date2.getTime() - date1.getTime()) / (24L * 60L * 60L * 1000L);
               if (day>180){
                   String id=n.get("id").toString();
                   inf.updatecontact(id);
               }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> list1= inf.select1();
        ses.setAttribute("list1",list1);
        ses.setAttribute("list1count",list1.size() );

        return "showclient";
    }


    //    显示单个历史订单和商品
    public String showdetail(){
        String id=req.getParameter("id");
        List<Map<String, Object>> list= inf.showdetail(id);
        String sid=list.get(0).get("gid").toString();

        //查询单个历史信息
        List<Map<String, Object>> lists= inf.showgoods(sid);
        ses.setAttribute("detaillist",list);

        Long count=0l;
        for (Map<String, Object> s:
                lists) {
            System.out.println(s);
            count+=Integer.parseInt(s.get("price").toString());
        }
        ses.setAttribute("addresslist",lists);
        ses.setAttribute("addresscount",count);
        ses.setAttribute("addresslistsize",lists.size());
        return "showorders";
    }

    //    显示全部历史订单
    public String showorders(){
        List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
        String id=sz.get(0).get("sid").toString();
        List<Map<String, Object>> list=inf.selectorder(id);
        ses.setAttribute("orderslist",list);
        ses.setAttribute("orderslistcount",list.size());
        return "showorders";
    }

    //    查询单个交往记录   跳转修改交往记录页面
    public String updatechats(){
        String id=req.getParameter("id");
        String time=req.getParameter("time");
        String path=req.getParameter("path");
        String describe=req.getParameter("describe");
        String camark=req.getParameter("camark");
        String detail=req.getParameter("detail");

     inf.updatechat(time, path, describe, camark, detail, id);

        return showchat();
    }
    //    查询单个交往记录   跳转修改交往记录页面
        public String updatechat(){
            String id=req.getParameter("id");
            List<Map<String, Object>> list=inf.selectchat(id);
            ses.setAttribute("listchatz",list);
            return "ww";
        }
        //    添加交往记录   跳转所有交往记录页面
        public String addchat(){
            List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
            String id=sz.get(0).get("sid").toString();
            String time=req.getParameter("time");
            String path=req.getParameter("path");
            String describe=req.getParameter("describe");
            String camark=req.getParameter("camark");
            String detail=req.getParameter("detail");
            String sql="INSERT INTO contact VALUES(NULL,:time,:path,:describe," +
                    ":camark,:detail,:id)";
            inf.addchat(time, path, describe, camark, detail, id);

            return showchat();
        }
        //    删除单个交往记录页面  跳转并且查询所有交往记录
        public String deletechat(){
          String id=req.getParameter("id");
          inf.deletechat(id);
            return showchat();
        }

        //    显示交往记录页面  查询所有交往记录
            public String showchat (){
                List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
                String sid=sz.get(0).get("sid").toString();
                List<Map<String, Object>> list= inf.showchat(sid);
                ses.setAttribute("chatlist",list);
                ses.setAttribute("chatlistcount",list.size());
                return  "showchat";
            }

        //    添加单个联系人  跳转所有联系人页面
        public String addlinkmanww(){

            String name=req.getParameter("name");
            String sex=req.getParameter("sex");
            String post=req.getParameter("post");
            String phone=req.getParameter("phone");
            String tel=req.getParameter("tel");
            String ramark=req.getParameter("ramark");

            List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
            String id=sz.get(0).get("sid").toString();
            inf.addlinkman(name, sex, post, tel, phone, ramark, id);
            return showcontacts();
        }

        //    修改单个联系人  跳转所有联系人页面
        public String updatelinkmanww(){

            String id=req.getParameter("id");
            String name=req.getParameter("name");
            String sex=req.getParameter("sex");
            String post=req.getParameter("post");
            String phone=req.getParameter("phone");
            String tel=req.getParameter("tel");
            String ramark=req.getParameter("ramark");

            inf.updatelinkman(name, sex, post, tel, phone, ramark, id);



            return showcontacts();
        }

        //    跳转修改联系人页面 查询单个联系人
            public String updatelinkman (){
                String id=req.getParameter("id");
                List<Map<String, Object>> list = inf.getlinkman(id);
                ses.setAttribute("linkmanlist",list);
                //        存储性别
                List<String> xx=new ArrayList<String>();
                xx.add("男");
                xx.add("女");
                ses.setAttribute("sex",xx);
                return "ww";
            }


        //   删除单个联系人  查询全部联系人
        public String delectlinkman (){
            String id=req.getParameter("id");
            inf.delelinkman(id);
            return  showcontacts();
        }

        //   删除单个联系人  查询联系人
        public String deleuser(){
            String id=req.getParameter("id");
            inf.deleuser(id);
            return  show();
        }

        //    显示联系人页面  查询联系人
        public String showcontacts(){
            List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
            String sid=sz.get(0).get("sid").toString();
            List<Map<String, Object>> list = inf.getcontacts(sid);
            ses.setAttribute("contactslist",list);
            ses.setAttribute("contactscount",list.size());

            return "showcontacts";
        }

        //    修改单个用户
        public  String updateuser(){
            String name=req.getParameter("name");
            String place=req.getParameter("place");
            String manager=req.getParameter("manager");
            String lv=req.getParameter("lv");
            String satisfaction=req.getParameter("satisfaction");
            String credit=req.getParameter("credit");
            String placeDetail=req.getParameter("placeDetail");
            String email=req.getParameter("email");
            String companytel=req.getParameter("companytel");
            String fax=req.getParameter("fax");
            String url=req.getParameter("url");
            String busineslicense=req.getParameter("busineslicense");
            String legalperson=req.getParameter("legalperson");
            String loginprice=req.getParameter("loginprice");
            String yearprice=req.getParameter("yearprice");
            String openback=req.getParameter("openback");
            String backNo=req.getParameter("backNo");
            String governmentNo=req.getParameter("governmentNo");
            String countryNo=req.getParameter("countryNo");
            List<Map<String, Object>> sz=( List<Map<String, Object>> )ses.getAttribute("user");
            String sid=sz.get(0).get("sid").toString();

            inf.updateuser(place, manager, lv, satisfaction, credit, placeDetail, email, companytel, fax, url, busineslicense, legalperson, loginprice, yearprice, openback , backNo, governmentNo,  countryNo, sid);
            inf.updategroup(sid,name);

            List<Map<String, Object>> list = inf.getalluser();
            ses.setAttribute("list",list);
            ses.setAttribute("count",list.size());


            return  "update";
        }
        //    获取单个用户详情信息
        public String userredact(){
           String id= req.getParameter("id");


        //        客户等级
            List<String> dj=new ArrayList<String>();
            dj.add("战略伙伴");
            dj.add("合作伙伴");
            dj.add("大客户");
            dj.add("重点开发客户");
            dj.add("普通客户");

            ses.setAttribute("dj",dj);

        //        存储星星
            List<String> xx=new ArrayList<String>();
            xx.add("❤");
            xx.add("❤❤");
            xx.add("❤❤❤");
            xx.add("❤❤❤❤");
            xx.add("❤❤❤❤❤");

            ses.setAttribute("xx",xx);

        //        单个用户信息
            List<Map<String, Object>> list = inf.getuser(id);
            String z=id.substring(24);
            Map<String, Object> m=list.get(0);
            m.remove("id");
            m.put("id",z);
            m.put("sid",id);
            List<Map<String, Object>> list2 =new ArrayList<Map<String, Object>>();
            list2.add(m);
            ses.setAttribute("user",list2);



        //        全部客户经理
            List<Map<String, Object>> list1 = inf.getmanager();
            ses.setAttribute("managerr",list1);

        //        地址
            List<String> dz=new ArrayList<String>();
            dz.add("华西");
            dz.add("华中");
            dz.add("华南");
            dz.add("华北");
            dz.add("华东");
            ses.setAttribute("dz",dz);

            return "ww";
        }


        //    显示全部用户
        public  String show(){
            List<Map<String, Object>> list = inf.getalluser();
            ses.setAttribute("list",list);
            ses.setAttribute("count",list.size());
            return  "showuser";
        }

        @Override
        public void setServletRequest(HttpServletRequest req) {
            this.req=req;
            this.ses=req.getSession();
        }
    }
