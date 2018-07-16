package org.java.web;

import com.opensymphony.xwork2.ActionSupport;

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

        List<Map<String, String>> list =service.showChartGX(null,null);
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

        List<Map<String, String>> list =service.showChartGX(searchName,yearName);
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
        request.setAttribute("yearName", yearName);
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
}
