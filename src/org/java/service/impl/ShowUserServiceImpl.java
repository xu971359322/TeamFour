package org.java.service.impl;

import org.hibernate.Transaction;
import org.java.dao.impl.ShowUserDaoImpl;
import org.java.entity.Clienphone;
import org.java.util.HibernateUtil;

import java.util.List;
import java.util.Map;

public class ShowUserServiceImpl {
    private ShowUserDaoImpl dao=new ShowUserDaoImpl();
    //    确定流失
    public  void  updatemeasure(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.updatemeasure(id);
        tr.commit();
    }

        //    添加展缓流失信息
    public void addmeasure(String name,String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.addmeasure(name,id);
        tr.commit();

    }

        //    查询人
    public  List<Map<String, Object>> inquirer (String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.inquirer(id);
        tr.commit();
        return list;
    }


    //    查询流失措施
    public  List<Map<String, Object>> measure (String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.measure(id);
        tr.commit();
        return list;
    }



        //    查询流失1
    public   List<Map<String, Object>> select1(){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.select1();
        tr.commit();
        return list;
    }


        //修改用户状态
    public   void updatecontact(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.updatecontact(id);
        tr.commit();
    }

        //查询出来所有正常的交往记录
    public    List<Map<String, Object>> contactall(){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.contactall();
        tr.commit();
        return list;
    }


        //    显示单个历史订单
    public List<Map<String, Object>> showgoods(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.showgoods(id);
        tr.commit();
        return list;
    }
    //    显示单个历史订单
    public List<Map<String, Object>> showdetail(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.showdetail(id);
        tr.commit();
        return list;
    }

    //    显示全部历史订单
    public List<Map<String, Object>> selectorder(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.selectorder(id);
        tr.commit();
        return list;
    }
    //    修改单个交往记录
    public void updatechat(String time,String path,String describe,String camark,String detail,String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.updatechat(time, path, describe, camark, detail, id);
        tr.commit();
    }
    //    显示全部交往记录
    public List<Map<String, Object>> selectchat(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list =dao.selectchat(id);
        tr.commit();
        return list;
    }
    //    添加单个交往记录
    public void addchat(String time,String path,String describe,String camark,String detail,String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
       dao.addchat(time, path, describe, camark, detail, id);
        tr.commit();
    }

    //    删除单个交往记录
    public void deletechat(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
       dao.deletechat(id);
        tr.commit();

    }
    //    显示全部交往记录
    public List<Map<String, Object>> showchat(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.showchat(id);
        tr.commit();
        return list;
    }

    //    添加单个联系人
    public void addlinkman(String name,String sex,String post,String tel,String phone,String ramark,String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
      dao.addlinkman(name, sex, post, tel, phone, ramark, id);
        tr.commit();

    }
    //    修改单个联系人
    public void updatelinkman(String name,String sex,String post,String tel,String phone,String ramark,String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.updatelinkman(name, sex, post, tel, phone, ramark, id);
        tr.commit();

    }
    //    查询单个联系人
    public List<Map<String, Object>> getlinkman(String sid){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.getlinkman(sid);
        tr.commit();
        return list;
    }
    //    删除单个用户
    public void deleuser(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.deleuser(id);
        tr.commit();

    }
    //    删除单个联系人
    public void delelinkman(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.delelinkman(id);
        tr.commit();

    }
    //    查询全部联系人
    public List<Map<String, Object>> getcontacts(String sid){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.getcontacts(sid);
        tr.commit();
        return list;
    }
    //    修改单个集团名称
    public void updategroup(String sid,String name){
        Transaction tr=HibernateUtil.getCurrentSession().beginTransaction();
        dao.updategroup(sid, name);
        tr.commit();
    }
    //    修改单个用户
    public void updateuser(String place,String manager,String lv,String satisfaction,String credit,String placeDetail,String email,String companytel,String fax,String url,String busineslicense,String legalperson,String loginprice,String yearprice,String openback ,String backNo,String governmentNo, String countryNo,String sid) {
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        dao.updateuser(place, manager, lv, satisfaction, credit, placeDetail, email, companytel, fax, url, busineslicense, legalperson, loginprice, yearprice, openback , backNo, governmentNo,  countryNo, sid);
        tr.commit();

    }
        //    查询全部客户经理
    public List<Map<String, Object>> getmanager(){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.getmanager();
        tr.commit();
        return list;
    }
    //    显示单个用户
    public List<Map<String, Object>> getuser(String id){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.getuser(id);
        tr.commit();
        return list;
    }
//    显示全部用户
    public List<Map<String, Object>> getalluser(){
        Transaction tr= HibernateUtil.getCurrentSession().beginTransaction();
        List<Map<String, Object>> list = dao.getalluser();
        tr.commit();
        return list;
    }
}
