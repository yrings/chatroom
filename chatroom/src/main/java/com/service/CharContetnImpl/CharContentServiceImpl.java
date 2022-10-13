package com.service.CharContetnImpl;

import com.dao.CharContentDao;
import com.pojo.CharContent;
import com.service.CharContentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CharContentServiceImpl implements CharContentService {

    public void addNewcontent(CharContent charContent) throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        charContentDao.addNewcontent(charContent);

        sqlSession.commit();

        sqlSession.close();
    }
    public List<CharContent> findNewcontent() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);


        List<CharContent> list = charContentDao.findNewcontent();

        sqlSession.commit();

        sqlSession.close();

        return list;

    }

    public List<CharContent> findAllContent() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        List<CharContent> list = charContentDao.findAllContent();

        sqlSession.commit();

        sqlSession.close();

        return list;
    }
    public void deleteContent(CharContent charContent) throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        charContentDao.deleteContent(charContent);

        sqlSession.commit();

        sqlSession.close();
    }

    public void logicDelete(CharContent charContent) throws IOException {

        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        charContentDao.logicDelete(charContent);

        sqlSession.commit();
        sqlSession.close();
    }

    public void recover(CharContent charContent) throws IOException {

        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        charContentDao.recoverContent(charContent);

        sqlSession.commit();

        sqlSession.close();

    }

    public List<CharContent> findAllLogicDelete() throws IOException {

        InputStream is = Resources.getResourceAsStream("sqlMapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        List<CharContent> list = charContentDao.findAllLogicDelete();

        sqlSession.commit();

        sqlSession.close();

        return list;
    }
}
