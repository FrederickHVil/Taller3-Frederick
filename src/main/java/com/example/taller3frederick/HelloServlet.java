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
            out.println("<link rel=\"stylesheet\" href=\"./style.css\">");
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

        }else{
            response.sendError(401);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String volver = request.getParameter("volver");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv='refresh' content='1; URL=owner-page.html'>");
        out.println("</head><body>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}

/*html{
        background-color: rgb(31, 31, 31);
        color: white;
        padding-top: 30px; padding-left: 10px; padding-right: 10px;
        font-size: larger;
        text-align: center;
        }
        .fondo{
        background-image: url("https://www.atiramhotels.com/wp-content/uploads/2018/12/grey-dark-vintage-background-texture-510x300.jpg");
        }

        .med{
        font-size: 60px;
        }*/

//<link rel="stylesheet" href="./style.css">