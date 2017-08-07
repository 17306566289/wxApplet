package wechat.servlet;

import net.sf.json.JSONArray;
import wechat.service.WXApplet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 预定界面
 */
public class ReserveShowServlet  extends javax.servlet.http.HttpServlet{
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int homePartyId=1;
        if (request.getParameter("homePartyId")!=null)
            homePartyId=Integer.parseInt( request.getParameter("homePartyId")) ;
        WXApplet wxApplet=new WXApplet();
        JSONArray jsonArray= wxApplet.getPackagesByHomePartyId(homePartyId);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonArray.toString());
        out.print(jsonArray.toString());


    }
}
