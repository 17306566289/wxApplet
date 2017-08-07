package wechat.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wechat.db.dbAccess;
import wechat.model.*;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/6.
 */
public class OrderDao {
//    往Order表 添加一个order记录
    public boolean addOrder(Order order)  {
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        Boolean b=false;
        try {
            sqlSession=sqlConnection.getSqlSession();
         sqlSession.insert("server.addOrder",order);
         if (order.getCartPrice()>0)
            sqlSession.insert("server.addCartItems",order);
            sqlSession.commit();
           b=true;
        }
        catch (IOException e){
            throw e;
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
            return b;
        }

    }
}
