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
@WebServlet(name = "PackageListServlet")
public class PackageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//id为套餐的编号
        int id=1;
        if (request.getParameter("id")!=null)
            id=Integer.parseInt( request.getParameter("id")) ;
        WXApplet wxApplet=new WXApplet();

        JSONObject jsonObject= wxApplet.getProductsAndPackageByPackageId(id);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonObject.toString());
        out.print(jsonObject.toString());
    }
}
