package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.entry.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {


//    @Test
//    void selectAll() {
//        PrimaryStageDao primaryStageDao = new PrimaryStageDao();
//        List<PrimaryStageEntry> primaryStageEntries = primaryStageDao.selectAll();
//        System.out.println(primaryStageEntries);
//    }
//    @Test
//    void selectAll1() {
//        ZhuangBeiXinxiDao zhuangBeiXinxiDao = new ZhuangBeiXinxiDao();
//        List<ZhuangBeiXinxi> primaryStageEntries = zhuangBeiXinxiDao.selectAll();
//        System.out.println(primaryStageEntries);
//    }
//    @Test
//    void selectObject() {
//        ZhuangBeiXinxiDao zhuangBeiXinxiDao = new ZhuangBeiXinxiDao();
//        ZhuangBeiXinxi zbxx = zhuangBeiXinxiDao.selectObjectByName("齿轮泵");
//        System.out.println(zbxx.getDiyname());
//    }
//    @Test
//    void save() {
//        ZhuangBeiXinxiDao zhuangBeiXinxiDao = new ZhuangBeiXinxiDao();
//        ZhuangBeiXinxi zhuangBeiXinxi = new ZhuangBeiXinxi();
//        zhuangBeiXinxi.setDiyname("机舱装备");
//        zhuangBeiXinxi.setSumlingjian(10);
//        zhuangBeiXinxi.setShunxuhz("按上次发我的v稳定v稳定v我为v文旅部为日本为日本");
//        zhuangBeiXinxiDao.save(zhuangBeiXinxi);
//    }
//    @Test
//    void update() {
//        ZhuangBeiXinxiDao zhuangBeiXinxiDao = new ZhuangBeiXinxiDao();
//        ZhuangBeiXinxi zhuangBeiXinxi = new ZhuangBeiXinxi();
//        zhuangBeiXinxi.setDiyname("机舱装备");
//        zhuangBeiXinxi.setSumlingjian(10);
//        zhuangBeiXinxi.setShunxuhz("按上次发我的v稳定v稳定v我为v文旅部为日本为日本");
//        zhuangBeiXinxiDao.update(zhuangBeiXinxi);
//    }
//
//        @Test
//    void delete() {
//        ZhuangBeiXinxiDao zhuangBeiXinxiDao = new ZhuangBeiXinxiDao();
//        ZhuangBeiXinxi zhuangBeiXinxi = new ZhuangBeiXinxi();
//        zhuangBeiXinxi.setDiyname("机舱装备");
//        zhuangBeiXinxi.setSumlingjian(10);
//        zhuangBeiXinxi.setShunxuhz("按上次发我的v稳定v稳定v我为v文旅部为日本为日本");
//        zhuangBeiXinxiDao.delete(zhuangBeiXinxi);
//    }
//    @Test
//    void selectAll() {
//        ZbDao zbDao = new ZbDao();
//        List<Zb> zbxxList = zbDao.selectAll();
//        System.out.println(zbxxList);
//    }
//    @Test
//    void insertzb() {
//        ZbDao zbDao = new ZbDao();
//        Zb zb = new Zb();
//        zb.setZbname("zb1");
//        zbDao.save(zb);
//    }
//    @Test
//    void deletezb() {
//        WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
//        WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
//        weiXiuBuZhou.setZhuangbei("s12");
//        weiXiuBuZhouDao.deleteAllByZb(weiXiuBuZhou);
//
//        ZbGzDao zbGzDao = new ZbGzDao();
//        ZbGz zbGz = new ZbGz();
//        zbGz.setZbgzname("s12");
//        zbGzDao.deleteAllByZb(zbGz);
//
//        ZbDao zbDao = new ZbDao();
//        Zb zb = new Zb();
//        zb.setZbname("s12");
//        zbDao.delete(zb);
//    }
//    @Test
//    void updatezb() {
//        ZbDao zbDao = new ZbDao();
//        Zb zb = new Zb();
//        zb.setZbname("s1");
//        zbDao.update("zb1",zb);
//    }
//    @Test
//    void savegz() {
//        ZbGzDao zbGzDao = new ZbGzDao();
//        ZbGz zbGz = new ZbGz();
//        zbGz.setZbgzname("说");
//        zbGz.setZbgztype("aa");
//        zbGzDao.save(zbGz);
//    }
//    @Test
//    void saveczbz() {
//        WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
//        WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
//        weiXiuBuZhou.setZhuangbei("说");
//        weiXiuBuZhou.setGztype("去啊");
//        weiXiuBuZhou.setBuzhou("aaa");
//        weiXiuBuZhouDao.save(weiXiuBuZhou);
//    }
//    @Test
//    void deleteczbz() {
//        WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
//        WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
//        weiXiuBuZhou.setZhuangbei("说");
//        weiXiuBuZhou.setGztype("去啊");
//        weiXiuBuZhou.setBuzhou("aaa");
//        weiXiuBuZhouDao.delete(weiXiuBuZhou);
//    }
//    @Test
//    void deletegz() {
//        ZbGzDao zbGzDao = new ZbGzDao();
//        ZbGz zbGz = new ZbGz();
//        zbGz.setZbgzname("s12");
//        zbGz.setZbgztype("菜单");
//        zbGzDao.delete(zbGz);
//
//        WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
//        WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
//        weiXiuBuZhou.setZhuangbei("s12");
//        weiXiuBuZhou.setGztype("菜单");
//        weiXiuBuZhouDao.deleteAllByGz(weiXiuBuZhou);
//    }
//    @Test
//    void updategz() {
//        ZbGzDao zbGzDao = new ZbGzDao();
//        ZbGz zbGz = new ZbGz();
//        zbGz.setZbgzname("说");
//        zbGz.setZbgztype("修改完成");
//        zbGzDao.update("去啊",zbGz);
//
//        WeiXiuBuZhouDao weiXiuBuZhouDao = new WeiXiuBuZhouDao();
//        WeiXiuBuZhou weiXiuBuZhou = new WeiXiuBuZhou();
//        weiXiuBuZhou.setZhuangbei("说");
//        weiXiuBuZhou.setGztype("修改完成");
//        weiXiuBuZhouDao.updateAllByGz("去啊",weiXiuBuZhou);
//    }

}
