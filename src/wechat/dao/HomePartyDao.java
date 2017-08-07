package wechat.dao;

import org.apache.ibatis.session.SqlSession;
import wechat.db.dbAccess;
import wechat.model.HomeParty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对轰趴馆信息的处理
 */
public class HomePartyDao {
    /**
     * 获得所有轰趴馆的信息
     * @return
     */
   public List<HomeParty> getAllHomeParty()  {
       List<HomeParty> homePartyList=new ArrayList<HomeParty>();
       dbAccess sqlConnection=new dbAccess();
       SqlSession sqlSession=null;
       try {
       sqlSession=sqlConnection.getSqlSession();
           homePartyList= sqlSession.selectList("applet.getAllHomeParty");
           sqlSession.commit();
       }
       catch (IOException e){
            e.printStackTrace();
       }finally {
           if (sqlSession!=null)
               sqlSession.close();
       }
       return homePartyList;
   }


    /**
     * 根据id获取一个轰趴馆对象
     * @param id 轰趴馆的id
     * @return
     */
    public HomeParty getHomePartyById(int id)  {
       HomeParty homeParty=new HomeParty();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
             sqlSession=sqlConnection.getSqlSession();
            homeParty= sqlSession.selectOne("applet.getHomePartyById",id);
            sqlSession.commit();
        }
        catch (IOException e){

        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return homeParty;
    }
}
