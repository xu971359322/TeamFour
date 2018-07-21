package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartAction extends ChartBaseAction {


    /**
     * 贡献
     * @return
     */
    public String showChartGX() {
        List<Map<String, String>> yearList = service.getYear();
        session.setAttribute("year",yearList);

        List<Map<String, Object>> list =service.showChartGX(null,null);
        request.setAttribute("list",list);
        return ActionSupport.SUCCESS;
    }

    public String search() {
        System.out.println("静茹search1111111111111111111111111111111111111111111111111");
        String searchName=request.getParameter("searchName");
        String yearName=request.getParameter("yearName");

        System.out.println(searchName+"\t"+yearName);

        request.setAttribute("searchName",searchName);
        request.setAttribute("yearSelect",yearName);


        List<Map<String, String>> yearList = service.getYear();
        session.setAttribute("year",yearList);

        List<Map<String, Object>> list =service.showChartGX(searchName,yearName);
        request.setAttribute("list",list);
        return ActionSupport.SUCCESS;
    }

    public String searchFX() {
        String type=request.getParameter("typeFX");
        List<Map<String, String>> list = service.showChartFX(type);
        request.setAttribute("type",type);
        request.setAttribute("list", list);
        return "searchFX";
    }

    public String searchFW() {
        System.out.println("分析分析服务-----------------------------------------------");
        String yearName = request.getParameter("yearName");
        System.out.println(yearName + "==========================");
        if (yearName.equals("-1")) {
            yearName = null;
        }
        List<Map<String, String>> list = service.showChartFW(yearName);
        session.setAttribute("yearName", yearName);
        request.setAttribute("list", list);
        return "searchFW";
    }


    public String searchLS() {
        String clientName=request.getParameter("companyname");
        String manger=request.getParameter("uname");

        setCount(Integer.parseInt(service.getCount(clientName,manger).toString()));

        System.out.println(Integer.parseInt(service.getCount(clientName,manger).toString())+"数值数值数值数值数值数值-----------------------------------数值数值数值");

        List<Map<String, String>> list = service.showChartLS(clientName,manger,getPageNo(),getPageSize());
        request.setAttribute("list", list);

        session.setAttribute("clientName", clientName);
        session.setAttribute("manger", manger);

        return "searchLS";
    }

    /**
     * 分页
     */
    public String changePage(){
        setPageNo(Integer.parseInt(request.getParameter("pageNo")));

        String clientName=(String)session.getAttribute("clientName");

        String manger=(String)session.getAttribute("manger");

        setCount(Integer.parseInt(service.getCount(clientName,manger).toString()));

        List<Map<String, String>> list = service.showChartLS(clientName,manger,getPageNo(),getPageSize());

        request.setAttribute("list", list);

        System.out.println(Integer.parseInt(service.getCount(clientName,manger).toString())+"数值数值数值数值数值数值-----------------------------------数值数值数值");

        return "changePage";




        /*
        System.out.println(service.getCount(null,null).toString()+"11111111111111111111111111111111111111");
        System.out.println(count+"数值数值数值数值数值数值-----------------------------------数值数值数值");
        System.out.println(getPageNo()+"::::::::::::eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");*/


    }

    /**
     * 分析
     * @return
     */
    public String showChartFX() {
        String type="level";
        List<Map<String, String>> list = service.showChartFX(type);
        request.setAttribute("list", list);
        request.setAttribute("type",type);
        return "showChartFX";
    }

    /**
     * 服务
     * @return
     */
    public String showChartFW() {
        List<Map<String, String>> list = service.showChartFW(null);
        request.setAttribute("list", list);

        List<Map<String, String>> yearList = service.getYear();
        session.setAttribute("year",yearList);


        return "showChartFW";
    }

    /**
     * 流失
     * @return
     */
    public String showChartLS(){
        List<Map<String, String>> list = service.showChartLS(null, null,getPageNo(),getPageSize());
        setCount(Integer.parseInt(service.getCount(null,null).toString()));
        request.setAttribute("list", list);
        return "showChartLS";
    }

    /**
     *
     */
    public void showTypeEChartGX(){
        response.setContentType("text/html;charset=utf-8");
        System.out.println("------------------------------静茹AJAX方法----------------------------");
        try {
            List<Map<String, Object>> list = service.showChartGX(null,null);
            JSONObject json=new JSONObject();


            List<Map<String, Object>> list2= new ArrayList<Map<String, Object>>();

            for (Map<String, Object> m: list){
                Map<String,Object> map =new HashMap<String, Object>();
                map.put("name",m.get("companyname"));
                map.put("value",m.get("sum"));
                System.out.println(m);
                list2.add(map);
            }

            json.put("list2",list2);

            //取得所有的标题，放在一个集合中
            List<Object> titles = new ArrayList<Object>();
            for(Map<String,Object>  m : list2){
                titles.add(m.get("name"));
            }

            json.put("titles",titles);//一维结构，显示在在legend中

            response.getWriter().write(json.toString());






        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTypeEChartLS(){
        response.setContentType("text/html;charset=utf-8");
        try {
            List<Map<String, String>> list =service.showChartLSCount();

            JSONObject json=new JSONObject();

            List<Map<String,String>> list2=new ArrayList<Map<String,String>>();

            for(Map<String,String> m : list){
                Map<String,String> map =new HashMap<String, String>();
                map.put("name",m.get("stauts"));
                map.put("value",m.get("count"));
                list2.add(map);
            }

            json.put("list2",list2);

            //取得所有的标题，放在一个集合中
            List<Object> titles = new ArrayList<Object>();
            for(Map<String,String>  m : list2){
                titles.add(m.get("stauts"));
            }
            json.put("titles",titles);//一维结构，显示在在legend中
            response.getWriter().write(json.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTypeEChartFW(){
        response.setContentType("text/html;charset=utf-8");
        String yearName=(String) session.getAttribute("yearName");
        try {
            List<Map<String, String>> list = service.showChartFW(yearName);
            JSONObject json=new JSONObject();
            Map<String, String> map =new HashMap<String,String>();
            for (int i=0;i<list.size();i++){
                map.put(list.get(i).get("sd_name"),list.get(i).get("count"));
            }
            json.put("names",map.keySet());//品牌名称的集合
            json.put("vals",map.values());

            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
