package ac.kr.daegu.jspmvcpractice.controller;

import ac.kr.daegu.jspmvcpractice.model.TestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dbTest")
public class DBConnectTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            boolean isConnected = TestDAO.getConnection();
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("db 연결 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}