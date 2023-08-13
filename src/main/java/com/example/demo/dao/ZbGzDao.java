package com.example.demo.dao;

import com.example.demo.entry.WeiXiuBuZhou;
import com.example.demo.entry.Zb;
import com.example.demo.entry.ZbGz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ZbGzDao {
    public List<ZbGz> selectAllByname(String newValue) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<ZbGz> users = sqlSession.selectList("ZbGzMapper.selectAllByname",newValue);
        sqlSession.close();
        return users;
    }

    public void save(ZbGz zbGz) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("ZbGzMapper.save",zbGz);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void delete(ZbGz zbGz) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("ZbGzMapper.delete",zbGz);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void deleteAllByZb(ZbGz zbGz) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("ZbGzMapper.deleteAllByZb",zbGz);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public ZbGz selectOneByObject(ZbGz zbGz1) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ZbGz users = sqlSession.selectOne("ZbGzMapper.selectOneByObject",zbGz1);
        sqlSession.close();
        return users;
    }

    public void update(String gzname, ZbGz zbGz) {
        ZbGz zbGz1 = new ZbGz();
        zbGz1.setZbgzname(zbGz.getZbgzname());
        zbGz1.setZbgztype(gzname);

        ZbGz zbGz2 = selectOneByObject(zbGz1);
        zbGz.setId(zbGz2.getId());

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("ZbGzMapper.update",zbGz);
        sqlSession.commit(true);
        sqlSession.close();
    }

    public void updateAllByObject(String username, ZbGz zbGz) {
        List<ZbGz> zbGzs = selectAllByname(username);

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        for (ZbGz zbgz1 : zbGzs) {
            zbGz.setId(zbgz1.getId());
            sqlSession.update("ZbGzMapper.updateAllByObject",zbGz);
            sqlSession.commit(true);
        }
        sqlSession.close();
    }
}
