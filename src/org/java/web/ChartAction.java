package org.java.web;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ChartAction extends ChartBaseAction {


    /**
     * 贡献
     * @return
     */
    public String showChartGX() {
        List<Map<String, String>> yearList = service.getYear();
        session.setAttribute("year",yearList);

        List<Map<String, Object>> list =service.showChartGX(null,null);
        session.setAttribute("list",list);
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
        session.setAttribute("list",list);

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

    public void showTypeEChartFW() {
        response.setContentType("text/html;charset=utf-8");
        String yearName = (String) session.getAttribute("yearName");
        try {
            List<Map<String, String>> list = service.showChartFW(yearName);
            JSONObject json = new JSONObject();
            Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i).get("sd_name"), list.get(i).get("count"));
            }
            json.put("names", map.keySet());//品牌名称的集合
            json.put("vals", map.values());

            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showExcel(){
        try {
            String title="订单数据汇总.xls";
            String fname = URLEncoder.encode(title,"utf-8");
            //响应的类型是一个excel文档
            response.setContentType("application/vnd.ms-excel");
            //设置下载的面板中，要显示哪些内容
            response.setHeader("Content-disposition","attachment;fileName="+fname);

            //产生输出流，用于保存文件到客户端
            OutputStream out=response.getOutputStream();

            //得到查询到数据
            List<Map<String,Object>> list = (List<Map<String,Object>>)session.getAttribute("list");
           /* for (Map<String,Object> m :list){
                System.out.println(m.get("sum")+"------------------------------------进入remove方法进入remove方法------------------------------------");
                if(m.get("sum").equals("0")){
                    System.out.println("-----------!!!!!!!!!!!!!!!!!!!!-------------------------进入remove方法进入remove方法------------------------------------");
                    m.remove("sum");
                }
            }*/

            /****************************************************************************************************/

            //得到一个可以用流输出数据的工作簿-------
            WritableWorkbook wb = Workbook.createWorkbook(out);

            //在工作簿中创建一个可以流输出数据的表单
            WritableSheet st = wb.createSheet("订单记录汇总",0);//表单名称，下标
            /*********************指定电子文档的样式 **********************************/
            st.getSettings().setDefaultColumnWidth(30);//列宽

            //创建可以用流输出到文件的字体格式
            WritableFont ft = new WritableFont(WritableFont.ARIAL,18,WritableFont.BOLD);

            //指定单元格的格式,并且设置字体
            WritableCellFormat wft = new WritableCellFormat(ft);
            wft.setBorder(Border.ALL,BorderLineStyle.THIN);//指定边框

            wft.setAlignment(Alignment.CENTRE);//对齐方式
            wft.setWrap(true);//自动换行

            /********************添加大标题***********************************/
            Label t = new Label(0,0,"订单记录汇总",wft);
            st.addCell(t);//添加到表单
            st.mergeCells(0,0,5,0);//开始列下标，开始行下标，结束列下标，结束 行下标

            /********************************************************/
            //在表单中，指定列下标，指定行下标处，产生一个Label，用于显示数据
            Label labId = new Label(0,1,"编号",wft);//列下标，行下标，内容
            Label labCompanyname = new Label(1,1,"客户名称",wft);//列下标，行下标，内容
            Label labSum = new Label(2,1,"订单金额",wft);//列下标，行下标，内容
            Label labStaust = new Label(3,1,"回款状态",wft);
            Label labYear = new Label(4,1,"年份",wft);


            //把标签添加到表单中
            st.addCell(labId);
            st.addCell(labCompanyname);
            st.addCell(labSum);
            st.addCell(labStaust);
            st.addCell(labYear);

            /**************读取数据表的数据，写入文件***************************/

            for(int i=0;i<list.size();i++){
                Map<String,Object> m = list.get(i);
                if(!m.get("sum").toString().equals("0")){
                    String id= String.valueOf(i+1);
                    String companyname = m.get("companyname").toString();
                    String sum = m.get("sum").toString();
                    String result = m.get("result").toString();
                    String year = m.get("year").toString();

                    Label mid = new Label(0,i+2,id,wft);
                    Label mcompanyname = new Label(1,i+2,companyname,wft);
                    Label msum = new Label(2,i+2,sum,wft);
                    Label mresult = new Label(3,i+2,result,wft);
                    Label myear = new Label(4,i+2,year,wft);

                    st.addCell(mid);
                    st.addCell(mcompanyname);
                    st.addCell(msum);
                    st.addCell(mresult);
                    st.addCell(myear);
                }
            }

            /*****************************************/


            //将工作簿的数据，写入到文件
            wb.write();

            //关闭流
            wb.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "showExcel";
    }


    public void showQuarter(){
        response.setContentType("text/html;charset=utf-8");
        try {
            List<Map<String, String>> list = service.showQuarter();
            for(Map<String, String> m :list){
                System.out.println(m);
            }
            List<Map<String, String>> year = service.getYear();
            JSONObject json = new JSONObject();
            List<String> yearInfo=new ArrayList<String>();
            for (int i = 0; i < year.size(); i++) {
                yearInfo.add(year.get(i).get("year"));
            }
            json.put("yearInfo",yearInfo);


            List<Integer> count1 =new ArrayList<Integer>();
            List<Integer> count2 =new ArrayList<Integer>();
            List<Integer> count3 =new ArrayList<Integer>();
            List<Integer> count4 =new ArrayList<Integer>();

            for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).get("result").equals("第一季度")) {
                        if (list.get(i).get("count") != null && !"".equals(list.get(i).get("count"))) {
                            count1.add(Integer.parseInt(list.get(i).get("count")));
                        }
                    }
                    if (list.get(i).get("result").equals("第二季度")) {
                        if (list.get(i).get("count") != null && !"".equals(list.get(i).get("count"))) {
                            count2.add(Integer.parseInt(list.get(i).get("count")));
                        }
                    }
                    if (list.get(i).get("result").equals("第三季度")) {
                        if (list.get(i).get("count") != null && !"".equals(list.get(i).get("count"))) {
                            count3.add(Integer.parseInt(list.get(i).get("count")));
                        }
                    }
                    if (list.get(i).get("result").equals("第四季度")) {
                        if (list.get(i).get("count") != null && !"".equals(list.get(i).get("count"))) {
                            count4.add(Integer.parseInt(list.get(i).get("count")));
                        }
                    }
                }
            System.out.println("季度一");
            Object[] arrayA =count1.toArray();
            Integer [] array1=new Integer[5];
            for (int i=0;i<arrayA.length;i++) {
                array1[i]=Integer.parseInt(arrayA[i].toString());
            }for (int i=0; i<array1.length/2; i++){
                int tmp = array1[i];
                array1[i] = array1[array1.length-1-i];
                array1[array1.length-1-i] = tmp;
            }
            System.out.println("-------------------------------------------------------------------------");
            Object[] arrayB =count2.toArray();
            Integer [] array2=new Integer[5];
            for (int i=0;i<arrayB.length;i++) {
                array2[i]=Integer.parseInt(arrayB[i].toString());
            }
            for (int i=0; i<array2.length/2; i++){
                int tmp = array2[i];
                array2[i] = array2[array2.length-1-i];
                array2[array2.length-1-i] = tmp;
            }
            System.out.println("-------------------------------------------------------------------------");
            Object[] arrayC =count3.toArray();
            Integer [] array3=new Integer[5];
            for (int i=0;i<arrayC.length;i++) {
                array3[i]=Integer.parseInt(arrayC[i].toString());
            }
            for (int i=0; i<array3.length/2; i++){
                int tmp = array3[i];
                array3[i] = array3[array3.length-1-i];
                array3[array3.length-1-i] = tmp;
            }
            System.out.println("-------------------------------------------------------------------------");
            Object[] arrayD =count4.toArray();
            Integer [] array4=new Integer[5];
            for (int i=0;i<arrayD.length;i++) {
                array4[i]=Integer.parseInt(arrayD[i].toString());
            }
            for (int i=0; i<array4.length/2; i++){
                int tmp = array4[i];
                array4[i] = array4[array4.length-1-i];
                array4[array4.length-1-i] = tmp;
            }

            json.put("count1",array1);

            json.put("count2",array2);

            json.put("count3",array3);

            json.put("count4",array4);

            response.getWriter().write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}