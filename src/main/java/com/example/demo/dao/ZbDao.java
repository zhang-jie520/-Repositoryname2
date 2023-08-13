package com.example.demo.dao;

import com.example.demo.entry.WeiXiuBuZhou;
import com.example.demo.entry.Zb;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ZbDao {
    public List<Zb> selectAll() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Zb> users = sqlSession.selectList("ZbMapper.selectAll");
        sqlSession.close();
        return users;
    }

    public Zb selectOneByName(String name) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Zb users = sqlSession.selectOne("ZbMapper.selectOneByName",name);
        sqlSession.close();
        return users;
    }
    public void save(Zb zb) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("ZbMapper.save",zb);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void delete(Zb zb) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("ZbMapper.delete",zb);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void update(String username, Zb zb) {
        Zb zb1 = selectOneByName(username);
        zb.setId(zb1.getId());
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("ZbMapper.update",zb);
        sqlSession.commit(true);
        sqlSession.close();
    }


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
