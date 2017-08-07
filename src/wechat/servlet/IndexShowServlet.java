package wechat.servlet;

import net.sf.json.JSONArray;
import wechat.service.WXApplet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 微信小程序index主页请求数据
 */
public class IndexShowServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        WXApplet wxApplet=new WXApplet();
       JSONArray jsonArray= wxApplet.getAllHomeParty();
       response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonArray.toString());
        out.print(jsonArray.toString());


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            doPost(request,response);
    }
}
