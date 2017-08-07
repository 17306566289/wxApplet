package wechat.dao;

import org.apache.ibatis.session.SqlSession;
import wechat.db.dbAccess;
import wechat.model.MyPackage;
import wechat.model.ProductItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商店的数据访问层
 */
public class ShopDao {
//    getProductsByClassId
    /**
     *根据ClassId返回对应的所有ProductItem对象
     * @return
     */
    public List<ProductItem> getProductsByClassId(int classId)  {
        List<ProductItem> productItemList=new ArrayList<ProductItem>();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=sqlConnection.getSqlSession();
            productItemList= sqlSession.selectList("applet.getProductsByClassId",classId);
            sqlSession.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return productItemList;
    }

}
