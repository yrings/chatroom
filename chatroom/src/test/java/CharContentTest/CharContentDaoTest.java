package CharContentTest;


import com.dao.CharContentDao;
import com.pojo.CharContent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CharContentDaoTest {

    @Test
    public void addNewcontent() throws IOException {

        CharContent cc = new CharContent();
        cc.setUsername("tom");
        cc.setContent("彳亍");


        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);

        charContentDao.addNewcontent(cc);

    }
    @Test
    public void findNewcontent() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CharContentDao charContentDao = sqlSession.getMapper(CharContentDao.class);


        List<CharContent> list = charContentDao.findNewcontent();

        for(CharContent charContent : list){
            System.out.println(charContent);
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
