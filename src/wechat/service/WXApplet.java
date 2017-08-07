package wechat.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wechat.dao.*;
import wechat.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信端请求和提交的逻辑业务层
 */
public class WXApplet {
    /**
     * 获取所有的轰趴馆 转换成json对象
     * @return List<HomeParty>
     */
    public JSONArray getAllHomeParty(){
        HomePartyDao homePartyDao=new HomePartyDao();
      List<HomeParty> homePartyList=  homePartyDao.getAllHomeParty();

      //将list转换为JSONArray 这样可以返回给小程序
        JSONArray jsonArray = JSONArray.fromObject(homePartyList);
        return jsonArray;
    }


    /**
     * 根据轰趴馆的ID 获取所有的套餐 转换成json对象
     * @return List<HomeParty>
     */
    public JSONArray getPackagesByHomePartyId(int homePartyId){
        PackageDao packageDao=new PackageDao();
        List<MyPackage> myPackageList =  packageDao.getPackagesByHomePartyId(homePartyId);

        //将list转换为JSONArray 这样可以返回给小程序
        JSONArray jsonArray = JSONArray.fromObject(myPackageList);
        return jsonArray;
    }


    /**
     * 根据套餐的ID 获取所有的套餐包含的商品和套餐本身 转换成json对象
     * @return List<HomeParty>
     */
    public JSONObject getProductsAndPackageByPackageId(int PackageId){
        PackageDao packageDao=new PackageDao();
        List<Product> productList=  packageDao.getProductsByPackageId(PackageId);
        MyPackage myPackage=new MyPackage();
        myPackage=packageDao.getPackageById(PackageId);

        JSONObject j=new JSONObject();
        //将list转换为JSONArray 这样可以返回给小程序
        JSONArray jsonArray = JSONArray.fromObject(productList);
        JSONObject jsonObject=JSONObject.fromObject(myPackage);
        j.put("products",jsonArray);
        j.put("package",jsonObject);
        return j;
    }


    /**
     * 根据id获取HomeParty
     * @param id
     * @return
     */
    public JSONObject getHomePartyById(int id){

        HomePartyDao homePartyDao=new HomePartyDao();
        IconDao iconDao=new IconDao();
        //获取HomeParty
        HomeParty homeParty=  homePartyDao.getHomePartyById(id);
        String iconShow=homeParty.getIconShow();

        //分割iconShow
        char[] iconShows=new char[30];
        for(int i=0;i<iconShow.length();i++)
            iconShows[i]=iconShow.charAt(i);

        //获取所有的icon 放到iconList里面
        List<Icon> iconList=iconDao.getAllIcon();
        System.out.println(iconList.size());
        //给iconList的show赋值
        for(int i=0;i<iconList.size();i++)
            iconList.get(i).setShow(iconShows[i]=='1'?true:false);
        //给HomeParty的iconList赋值
        homeParty.setIconList(iconList);
        //将HomeParty转换为JSONObject 这样可以返回给小程序
        JSONObject jsonObject = JSONObject.fromObject(homeParty);
        return jsonObject;
    }



//    getProductsByClassId

    /**
     * 根据classid获取ProductItem
     * @param classId
     * @return
     */
    public JSONArray getProductsByClassId(int classId){

        ShopDao shopDao=new ShopDao();
        //获取HomeParty
        List<ProductItem> productItemList=  shopDao.getProductsByClassId(classId);

        //将list转换为JSONArray 这样可以返回给小程序
        JSONArray jsonArray = JSONArray.fromObject(productItemList);
        return jsonArray;
    }


    /**
     * 根据月份获取日历数据
     * @param month
     * @return
     */
    public JSONObject getMonth(int month){
         Month m=new Month();
         m.setBlank("    ");
         m.setPastDayList("123");
         List<Day> dayList=new ArrayList<Day>();
         for(int i=4;i<31;i++)
         {
             Day day=new Day();
             dayList.add(day);
             day.setDay(i);
             day.setDayIsReserved(false);
             day.setDayIsReserved(false);
         }
        Day day=new Day();
        dayList.add(day);
        day.setDay(31);
        day.setDayIsReserved(true);
        day.setNightIsReserved(true);
        m.setDayList(dayList);


        //将list转换为JSONArray 这样可以返回给小程序
        JSONObject jsonObject = JSONObject.fromObject(m);
        return jsonObject;
    }

    /**
     * 添加一条order记录
     * @param order
     * @return
     */
    public static boolean addOrder(Order order){
        OrderDao orderDao=new OrderDao();
         return orderDao.addOrder(order);
    }


}
