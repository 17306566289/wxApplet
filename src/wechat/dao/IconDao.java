package wechat.dao;

import org.apache.ibatis.session.SqlSession;
import wechat.db.dbAccess;
import wechat.model.Icon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public class IconDao {
    /**
     *返回所有Icon对象
     * @return
     */
    public List<Icon> getAllIcon()  {
        List<Icon> IconList=new ArrayList<Icon>();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
           sqlSession=sqlConnection.getSqlSession();
            IconList= sqlSession.selectList("applet.getAllIcon");
          sqlSession.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return IconList;
    }
}
