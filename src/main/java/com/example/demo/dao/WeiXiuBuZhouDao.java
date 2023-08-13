package com.example.demo.dao;

import com.example.demo.entry.WeiXiuBuZhou;
import com.example.demo.entry.ZhuangBeiXinxi;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WeiXiuBuZhouDao {

    public List<WeiXiuBuZhou> selectAllByObject(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<WeiXiuBuZhou> users = sqlSession.selectList("WeiXiuBuZhouMapper.selectAllByObject",weiXiuBuZhou);
        sqlSession.close();
        return users;
    }

    public void save(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("WeiXiuBuZhouMapper.save",weiXiuBuZhou);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void delete(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("WeiXiuBuZhouMapper.delete",weiXiuBuZhou);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public WeiXiuBuZhou selectOneByName(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        WeiXiuBuZhou users = sqlSession.selectOne("WeiXiuBuZhouMapper.selectOneByName",weiXiuBuZhou);
        sqlSession.close();
        return users;
    }

    public void update(String bzname, WeiXiuBuZhou weiXiuBuZhou) {
        WeiXiuBuZhou weiXiuBuZhou1 = new WeiXiuBuZhou();
        weiXiuBuZhou1.setZhuangbei(weiXiuBuZhou.getZhuangbei());
        weiXiuBuZhou1.setGztype(weiXiuBuZhou.getGztype());
        weiXiuBuZhou1.setBuzhou(bzname);

        WeiXiuBuZhou weiXiuBuZhou2 = selectOneByName(weiXiuBuZhou1);

        weiXiuBuZhou.setId(weiXiuBuZhou2.getId());
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("WeiXiuBuZhouMapper.update",weiXiuBuZhou);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void deleteAllByGz(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("WeiXiuBuZhouMapper.deleteAllByGz",weiXiuBuZhou);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void deleteAllByZb(WeiXiuBuZhou weiXiuBuZhou) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("WeiXiuBuZhouMapper.deleteAllByZb",weiXiuBuZhou);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void updateAllByGz(String gzname, WeiXiuBuZhou weiXiuBuZhou) {
        WeiXiuBuZhou weiXiuBuZhou1 = new WeiXiuBuZhou();
        weiXiuBuZhou1.setZhuangbei(weiXiuBuZhou.getZhuangbei());
        weiXiuBuZhou1.setGztype(gzname);
        List<WeiXiuBuZhou> weiXiuBuZhous = selectAllByObject(weiXiuBuZhou1);

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        for (WeiXiuBuZhou wxbz : weiXiuBuZhous) {
            weiXiuBuZhou.setId(wxbz.getId());
            sqlSession.update("WeiXiuBuZhouMapper.updateAllByGz",weiXiuBuZhou);
            sqlSession.commit(true);
        }
        sqlSession.close();
    }

    public List<WeiXiuBuZhou> selectAllByZb(String username) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<WeiXiuBuZhou> users = sqlSession.selectList("WeiXiuBuZhouMapper.selectAllByZb",username);
        sqlSession.close();
        return users;
    }

    public void updateAllByZb(String username, WeiXiuBuZhou weiXiuBuZhou) {
        List<WeiXiuBuZhou> weiXiuBuZhous = selectAllByZb(username);

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        for (WeiXiuBuZhou wxbz : weiXiuBuZhous) {
            weiXiuBuZhou.setId(wxbz.getId());
            sqlSession.update("WeiXiuBuZhouMapper.updateAllByZb",weiXiuBuZhou);
            sqlSession.commit(true);
        }
        sqlSession.close();
    }


//
//    public ZhuangBeiXinxi selectObjectByName(String newValue) {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ZhuangBeiXinxi users = sqlSession.selectOne("ZhuangBeiXinxiMapper.selectObjectByName",newValue);
//        sqlSession.close();
//        return users;
//    }
//
//
//    public void update(ZhuangBeiXinxi zhuangBeiXinxi) {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.update("ZhuangBeiXinxiMapper.update",zhuangBeiXinxi);
//        sqlSession.commit(true);
//        sqlSession.close();
//    }
//
//    public void delete(ZhuangBeiXinxi zhuangBeiXinxi) {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.delete("ZhuangBeiXinxiMapper.delete",zhuangBeiXinxi);
//        sqlSession.commit(true);
//        sqlSession.close();
//    }
}
