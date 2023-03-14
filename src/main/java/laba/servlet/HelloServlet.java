package laba.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class HelloServlet extends HttpServlet {
    public HelloServlet() {
    }

    public void destroy() {
        super.destroy();
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML><HEAD>");
        out.println("<TITLE>A Servlet in GET</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("  <form action=\"/servlet_war_exploded/laba6\" method=\"POST\">");
        out.println(" <select name=\"Type\">");
        out.println("   <option value=\"C:\\Users\\vsh21\\IdeaProjects\\Servlet_xd\\servlet\\src\\main\\resources\\1_\">Люди</option>");
        out.println("   <option value=\"C:\\Users\\vsh21\\IdeaProjects\\Servlet_xd\\servlet\\src\\main\\resources\\2_\">Природа</option>");
        out.println("    <input type=\"submit\" value=\"SUBMIT\"/>");
        out.println(" </select>");
        out.println(" </form>");
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        String str = request.getParameter("Type");
        Random rand = new Random();
        int r = rand.nextInt(2);
        str = str + r + ".png";
        FileInputStream fis = new FileInputStream(new File(str));
        BufferedInputStream bis = new BufferedInputStream(fis);
        response.setContentType("image/jpeg");
        BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());

        int data;
        while((data = bis.read()) > -1) {
            output.write(data);
        }

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public String getServletInfo() {
        return "This is my default servlet created by Eclipse";
    }

    public void init() throws ServletException {
    }
}
