package org.java.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.java.entity.Clienphone;
import org.java.util.HibernateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ShowUserDaoImpl {

//    测试类
//    @Test
    public  void zz(){


    }
//    确定流失
    public  void  updatemeasure(String id){
        String sql="UPDATE  CLIENT c SET  c.ctype='4' WHERE  c.cid=:id";
        Session ses=HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("id",id).executeUpdate();
    }
//    添加展缓流失信息
    public void addmeasure(String name,String id){
        String sql="INSERT INTO LoseClient VALUES(NULL,:name,NOW(),:id)";
        Session ses=HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("name",name).setParameter("id",id).executeUpdate();
    }

//    查询人
    public  List<Map<String, Object>> inquirer (String id){
        String sql=" SELECT cl.cid id ,cl.companyname `name`, cl.cname uname,MAX(c.otime) `time` , cl.ctype FROM CLIENT cl,Orders c,LoseClient l WHERE c.cid=cl.cid AND l.cid=c.cid AND  cl.ctype IN(3)  AND cl.cid=:id GROUP BY c.cid";
        Session ses=HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list= ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }


//    查询流失措施
    public  List<Map<String, Object>> measure (String id){
        String sql="SELECT c.lc_content content FROM LoseClient c WHERE c.cid=:id" ;
        Session ses=HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list= ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }



    //    查询流失1
    public   List<Map<String, Object>> select1(){
        Session ses=HibernateUtil.getCurrentSession();
        String sql=" SELECT cl.cid id ,cl.companyname `name`, cl.cname uname,MAX(c.otime) `time` , cl.ctype FROM CLIENT cl,Orders c,LoseClient l WHERE c.cid=cl.cid AND l.cid=c.cid AND  cl.ctype IN(3) GROUP BY c.cid";
        List<Map<String, Object>> list= ses.createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }




    //修改用户状态
    public   void updatecontact(String id){
        Session ses=HibernateUtil.getCurrentSession();
        String sql="UPDATE  CLIENT c SET  c.ctype='3' WHERE  c.cid=:id";
       ses.createSQLQuery(sql).setParameter("id",id).executeUpdate();
    }

    //查询出来所有正常的交往记录
    public    List<Map<String, Object>> contactall(){
        Session ses=HibernateUtil.getCurrentSession();
        String sql="SELECT  c.cid id,MAX(c.otime) time FROM `Orders` c,CLIENT cl WHERE cl.cid=c.cid AND cl.ctype NOT IN (3,4) GROUP BY c.cid";

        List<Map<String, Object>> list= ses.createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return  list;
    }




    //    显示单个历史订单详情 ---下的所有商品
    public   List<Map<String, Object>> showgoods(String id){
        Session ses=HibernateUtil.getCurrentSession();
        String sql="SELECT  g.gname `name`,g.gtype gtype,o.ocount ocount,g.gprice gprice, g.gprice*o.ocount price FROM Goods g,Orders o WHERE \n" +
                " o.gid=g.gid AND  g.gid=:id ";
        List<Map<String, Object>> list= ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return  list;
    }

//    显示单个历史订单详情
        public   List<Map<String, Object>> showdetail(String id){
            Session ses=HibernateUtil.getCurrentSession();
            String sql="SELECT o.oid id,o.otime `time`,o.opath opath,o.ostutas ostutas,o.ocount ocount,o.gid  gid  FROM Orders o " +
                    " WHERE    o.oid=:id";
            List<Map<String, Object>> list= ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

            return  list;
        }


    //显示全部历史订单
    public   List<Map<String, Object>> selectorder(String id){
        String sql="SELECT o.oid id,o.otime time,o.opath opath,o.ostutas ostutas FROM Orders o WHERE cid=:id";
        Session ses=HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list=  ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }


    //    修改单个交往记录
    public  void updatechat(String time,String path,String describe,String detail,String camark,String id){
        String sql="UPDATE contact SET  Co_time=:time,Co_path=:path," +
                "Co_describe=:describe,Co_ramark=:detail,Co_detail=:camark WHERE Co_id=:id";
        Session ses=HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("time",time).
                setParameter("path",path).setParameter("describe",describe)
                .setParameter("camark",camark).setParameter("detail",detail)
                .setParameter("id",id).executeUpdate();

    }
    //    查询单个交往记录
    public  List<Map<String, Object>> selectchat(String id){
        String sql=" SELECT c.Co_id id,c.Co_time `time`,c.Co_path path,c.Co_describe `describe`,c.Co_ramark camark,c.Co_detail detail FROM contact  c WHERE Co_id=:id";
        Session ses=HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list=  ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return  list ;
    }
    //    添加单个交往记录
    public void addchat(String time,String path,String describe,String camark,String detail,String id){
        String sql="INSERT INTO contact VALUES(NULL,:time,:path,:describe," +
                ":camark,:detail,:id)";
        Session ses = HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("time",time).
                setParameter("path",path).setParameter("describe",describe)
                .setParameter("camark",camark).setParameter("detail",detail)
                .setParameter("id",id).executeUpdate();

    }
    //    删除单个交往记录
    public void deletechat(String id){
        String sql="DELETE FROM contact WHERE  Co_id=:id";
        Session ses = HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("id",id).executeUpdate();

    }
//    查询全部交往记录
    public  List<Map<String, Object>> showchat(String id){
        String sql="SELECT c.Co_id id,c.Co_time `time`,c.Co_path path,c.Co_describe `describe`,c.Co_ramark camark,c.Co_detail detail FROM contact  c WHERE c.cid=:id";
        Session ses=HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list=  ses.createSQLQuery(sql).setParameter("id",id).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();

        return  list ;
    }

    //    添加单个联系人
            public void addlinkman(String name,String sex,String post,String tel,String phone,String ramark,String id){
            Session ses = HibernateUtil.getCurrentSession();
                String sql="INSERT INTO ClienPhone VALUES(NULL,:name,:sex,:post,:tel," +
                        ":phone,:ramark,:id)";
            ses.createSQLQuery(sql).setParameter("name",name).setParameter("sex",sex).setParameter("post",post)
                    .setParameter("tel",tel).setParameter("phone",phone).setParameter("ramark",ramark).setParameter("id",id).executeUpdate();

             }

    //修改单个联系人
    public void updatelinkman(String name,String sex,String post,String tel,String phone,String ramark,String id){
        Session ses = HibernateUtil.getCurrentSession();
        String sql="UPDATE ClienPhone SET Cp_name=:name,Cp_gender=:sex," +
                "Cp_post=:post,Cp_tel=:tel,Cp_phone=:phone," +
                "Cp_ramark=:ramark WHERE  Cp_id=:id";
        ses.createSQLQuery(sql).setParameter("name",name).setParameter("sex",sex).setParameter("post",post)
                .setParameter("tel",tel).setParameter("phone",phone).setParameter("ramark",ramark).setParameter("id",id).executeUpdate();

    }

    //查询单个联系人
    public List<Map<String, Object>> getlinkman(String sid){
        Session ses = HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list = ses.createSQLQuery("SELECT ce.Cp_id cid,ce.Cp_name `name`,ce.Cp_gender gender,ce.Cp_post post,ce.Cp_tel tel,ce.Cp_phone phone,ce.Cp_ramark ramark FROM ClienPhone ce WHERE  Cp_id=:sid").setParameter("sid",sid)
                .setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }
    //    删除单个用户
    public void deleuser(String id){
        String sql="DELETE FROM ClientDetail WHERE cid=:id";
        Session ses = HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("id",id).executeUpdate();

    }

//    删除单个联系人
    public void delelinkman(String id){
        String sql=" DELETE  FROM ClienPhone WHERE Cp_id=:id";
        Session ses = HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("id",id).executeUpdate();

    }
//    查询所有联系人
    public List<Map<String, Object>> getcontacts(String sid){
        Session ses = HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list = ses.createSQLQuery("SELECT ce.Cp_id cid,ce.Cp_name `name`,ce.Cp_gender gender,ce.Cp_post post,ce.Cp_tel tel,ce.Cp_phone phone,ce.Cp_ramark ramark FROM ClienPhone ce WHERE ce.cid= :sid").setParameter("sid",sid)
                .setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return  list;
    }

//    修改单个集团名称
    public void updategroup(String sid,String name){
        String sql="UPDATE  CLIENT  SET  companyname =:name  WHERE cid=:sid";
        Session ses=HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("name",name).setParameter("sid",sid).executeUpdate();
    }


//    修改单个用户
    public void updateuser(String place,String manager,String lv,String satisfaction,String credit,String placeDetail,String email,String companytel,String fax,String url,String busineslicense,String legalperson,String loginprice,String yearprice,String openback ,String backNo,String governmentNo, String countryNo,String sid) {

        String sql="UPDATE ClientDetail  SET place=:place,manager=:manager,Lv_id=:lv,satisfaction=:satisfaction," +
                "credit=:credit,placeDetail=:placeDetail,email=:email,companytel=:companytel,fax=:fax,url=:url," +
                "busineslicense=:busineslicense,legalperson=:legalperson,loginprice=:loginprice,yearprice=:yearprice," +
                "openback=:openback,backNo=:backNo,governmentNo=:governmentNo,countryNo=:countryNo WHERE cid=:sid";

        Session ses=HibernateUtil.getCurrentSession();
        ses.createSQLQuery(sql).setParameter("place",place)
                .setParameter("manager",manager).setParameter("lv",lv)
                .setParameter("satisfaction",satisfaction)
                .setParameter("credit",credit)
                .setParameter("placeDetail",placeDetail)
                .setParameter("email",email)
                .setParameter("companytel",companytel)
                .setParameter("fax",fax)
                .setParameter("url",url)
                .setParameter("busineslicense",busineslicense)
                .setParameter("legalperson",legalperson)
                .setParameter("loginprice",loginprice)
                .setParameter("yearprice",yearprice)
                .setParameter("openback",openback)
                .setParameter("backNo",backNo)
                .setParameter("governmentNo",governmentNo)
                .setParameter("countryNo",countryNo)
                .setParameter("sid",sid).executeUpdate();
    }


    //  查询全部客户经理
    public List<Map<String, Object>> getmanager() {
        Session ses = HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list = ses.createSQLQuery(" SELECT uname manager FROM USER WHERE identity='2'")
                .setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
    //    显示单个用户
    public List<Map<String, Object>> getuser(String id) {
        Session ses = HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list = ses.createSQLQuery("  SELECT ct.cid id,ct.companyname NAME,cl.place place,cl.manager uname,cl.Lv_id lv,cl.satisfaction satisfaction,cl.credit  credit ,\n" +
                "    cl.placeDetail  placeDetail,cl.email email,cl.companytel companytel,cl.fax fax ,cl.url url,\n" +
                "    cl.busineslicense busineslicense ,cl.legalperson legalperson,cl.loginprice loginprice,\n" +
                "    cl.yearprice yearprice,cl.openback openback,cl.backNo backNo,\n" +
                "    cl.governmentNo governmentNo,cl.countryNo countryNo\n" +
                "    FROM  CLIENT ct,ClientDetail cl\n" +
                "    WHERE ct.cid=cl.cid AND ct.cid='"+id+"'")
                .setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwww"+id);
        return list;
    }

    //    显示全部用户
    public List<Map<String, Object>> getalluser() {
        Session ses = HibernateUtil.getCurrentSession();
        List<Map<String, Object>> list = ses.createSQLQuery("SELECT ct.cid id,ct.companyname NAME,cl.place place,cl.manager uname,cl.Lv_id  lv FROM  CLIENT ct,ClientDetail cl WHERE ct.cid=cl.cid")
                .setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
}
