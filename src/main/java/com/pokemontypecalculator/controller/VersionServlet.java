package com.pokemontypecalculator.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemontypecalculator.service.CalTypeService;

@WebServlet("/versiones")
public class VersionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CalTypeService CalTypeService = new CalTypeService(); // Instancia del servicio

    public VersionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Reutilizamos el método POST
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.getRequestDispatcher("versiones.jsp").forward(request, response);
    }
}