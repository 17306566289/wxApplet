package wechat.service.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wechat.model.Order;
import wechat.model.OrderCartItem;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 生成订单时用到的函数
 */
public class OrderUtil {
    public static  Order getOrder(HttpServletRequest request)
    {
        //使用方法getParameter来获取键值对应的value值，这里的Key参数要和客户端传上来的Key值一样！
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置日期格式
        String createTime=df.format(new Date());
        int homePartyId=Integer.parseInt( request.getParameter("homePartyId"));//预定的轰趴馆的id
//         String wxId= request.getParameter("wxId");//微信id
        String wxId="testID";
        int year=Integer.parseInt( request.getParameter("year"));//预定年份
        int month=Integer.parseInt( request.getParameter("month"));//预定的月
        int day=Integer.parseInt( request.getParameter("day"));//预定日期
        String dayOrNight=request.getParameter("dayOrNight") ;//预定的日场还是夜场
        int basePrice=Integer.parseInt( request.getParameter("basePrice"));//轰趴馆起价 基础价
        int packagePrice=Integer.parseInt( request.getParameter("packagePrice"));//套餐价格
        int cartPrice=Integer.parseInt( request.getParameter("cartPrice"));//套餐外消费
//         List<OrderCartItem> cart;//购物车里额外购买的商品的列表
        int packageId=Integer.parseInt( request.getParameter("packageId"));//选择的套餐编号
        int peopleNum=Integer.parseInt( request.getParameter("peopleNum"));//入驻人数
        String name= request.getParameter("name");//入住人姓名
        String phoneNum=request.getParameter("phoneNum");//手机号码
        String idCard=request.getParameter("idCard");//身份证
        String visitedNum= request.getParameter("visitedNum");//邀请码
        String studentId= request.getParameter("studentId");//学生证
       int  cutId=Integer.parseInt( request.getParameter("cutId"));//优惠券id
            int  cutPrice=Integer.parseInt( request.getParameter("cutPrice"));//优惠券优惠额度
        String remark= request.getParameter("remark");//备注
        int deposit=Integer.parseInt( request.getParameter("deposit"));//押金
        int total=Integer.parseInt( request.getParameter("total"));//最后需要支付的金额
        List<OrderCartItem>  orderCartItemList=new ArrayList<OrderCartItem>();
        if (  !request.getParameter("cart").equals("")&!request.getParameter("cart").equals("null"))
            orderCartItemList=  OrderUtil.getOrderCartItemList(request.getParameter("cart"));
//生成order 并返回
        Order order=new Order( createTime,  homePartyId,  wxId,  year,
         month,  day,  dayOrNight,  basePrice,  packagePrice,
         cartPrice, orderCartItemList,  cutPrice,  packageId,
         peopleNum,  name,  phoneNum,  idCard,  visitedNum,  studentId,
         cutId,  remark,  deposit,  total);
        return order;
    }

    public static   List<OrderCartItem>  getOrderCartItemList(String cart){
        {
            List<OrderCartItem> orderCartItemList=new ArrayList<OrderCartItem>();
            String [] cartItems=cart.split(";");
           for (String cartItem : cartItems)
           {
               OrderCartItem orderCartItem=new OrderCartItem();
              orderCartItemList.add(orderCartItem);
               String productId=cartItem.split(",")[0].substring(10);
               String quantity=cartItem.split(",")[0].substring(10);
               orderCartItem.setProductId(Integer.parseInt(productId));
               orderCartItem.setQuantity(Integer.parseInt(quantity));
           }
            return orderCartItemList;
        }
    }






}
