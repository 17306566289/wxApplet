package wechat.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/7/24.
 */
public class dbAccess {
    String resource = "wechat/mysql/config.xml";
    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }

}



