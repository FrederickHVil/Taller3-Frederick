package com.example.taller3frederick;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bienvenido";

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("emailInput");
        String password = request.getParameter("passwordInput");


        if (email.equals("frederick@gmail.com") && password.equals("123987")){
            response.setContentType("text/html");

            Cookie ownerCookie = new Cookie("emailCookie", "frederick@gmail.com");
            ownerCookie.setMaxAge(3600);
            response.addCookie(ownerCookie);

            Cookie roleCookie = new Cookie("ownerRole", "Owner");
            roleCookie.setMaxAge(3600);
            response.addCookie(roleCookie);

            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<meta http-equiv='refresh' content='1; URL=owner-page.html'>");
            out.println("</head><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");

        } else if (email.equals("fpenal@unbosque.edu.co") && password.equals("123456")){
            response.setContentType("text/html");

            Cookie ownerCookie = new Cookie("emailCookie", "fpenal@unbosque.edu.co");
            ownerCookie.setMaxAge(3600);
            response.addCookie(ownerCookie);

            Cookie roleCookie = new Cookie("ownerRole", "functionary");
            roleCookie.setMaxAge(3600);
            response.addCookie(roleCookie);

            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<meta http-equiv='refresh' content='1; URL=functionary-page.html'>");
            out.println("</head><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");

        }



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}