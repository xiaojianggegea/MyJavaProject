package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * �ض���
 *    �����ָ�����ͻ�����Ϊ
 *    ������������
 *    ��ַ�������仯
 *    respones������
 */
@WebServlet("/ser03")
public class Servlet03HttpServletResponseRedirect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet03HttpServletResponseRedirect......");
        resp.getWriter().write("Servlet03HttpServletResponseRedirect......");
        //�ض���ser04
        resp.sendRedirect("ser04");
    }
}
