package wechat.dao;

import org.apache.ibatis.session.SqlSession;
import wechat.db.dbAccess;
import wechat.model.Icon;
import wechat.model.MyPackage;
import wechat.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */
public class PackageDao {
    /**
     *根据HomePartyID返回对应的所有Package对象
     * @return
     */
    public List<MyPackage> getPackagesByHomePartyId(int homePartyId)  {
        List<MyPackage> packageList=new ArrayList<MyPackage>();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=sqlConnection.getSqlSession();
            packageList= sqlSession.selectList("applet.getPackagesByHomePartyId",homePartyId);
            sqlSession.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return packageList;
    }


    /**
     *根据PackageID返回对应的Package对象
     * @return
     */
    public MyPackage getPackageById(int Id)  {
        MyPackage myPackage=new MyPackage();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=sqlConnection.getSqlSession();
            myPackage= sqlSession.selectOne("applet.getPackageById",Id);
            sqlSession.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return myPackage;
    }

    /**
     *根据PackageID返回对应的所有Product对象
     * @return
     */
    public List<Product> getProductsByPackageId(int PackageId)  {
        List<Product> productList=new ArrayList<Product>();
        dbAccess sqlConnection=new dbAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=sqlConnection.getSqlSession();
            productList= sqlSession.selectList("applet.getProductsByPackageId",PackageId);
            sqlSession.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return productList;
    }
}
