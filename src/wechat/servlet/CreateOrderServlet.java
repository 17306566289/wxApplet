package wechat.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wechat.model.Order;
import wechat.model.OrderCartItem;
import wechat.service.WXApplet;
import wechat.service.util.OrderUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
@WebServlet(name = "CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       根据post来的信息 创建一个order
    Order order=  OrderUtil.getOrder(request);


//     将他写入数据库
        WXApplet.addOrder(order);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Error Method");
    }
}
