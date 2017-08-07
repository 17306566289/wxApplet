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
 * Created by Administrator on 2017/8/1.
 */
@WebServlet(name = "ShopServlet")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId=1;
        if (request.getParameter("classId")!=null)
            classId=Integer.parseInt( request.getParameter("classId")) ;
        WXApplet wxApplet=new WXApplet();
        JSONArray jsonArray= wxApplet.getProductsByClassId(classId);

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonArray.toString());
        out.print(jsonArray.toString());
    }
}
