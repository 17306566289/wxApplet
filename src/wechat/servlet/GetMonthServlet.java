package wechat.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wechat.service.WXApplet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/8/3.
 */
@WebServlet(name = "GetMonthServlet")
public class GetMonthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int month=1;
        if (request.getParameter("month")!=null)
            month=Integer.parseInt( request.getParameter("month")) ;
        WXApplet wxApplet=new WXApplet();
        JSONObject jsonObject= wxApplet.getMonth(month);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonObject.toString());
        out.print(jsonObject.toString());
    }
}
