package com.example.taller3frederick;

import com.example.taller3frederick.dtos.Pet;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "jsonServlet", value = "/jsonServlet")
public class JsonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setContentType("aplication/json");

        ArrayList<Pet> pets = new ArrayList<Pet>();

        pets.add(new Pet("petName", "pet-image"));

        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(pets));

    }

}
