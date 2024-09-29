package com.pokemontypecalculator.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pokemontypecalculator.service.CalTypeService;

@WebServlet("/calType")
public class CalTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CalTypeService CalTypeService = new CalTypeService(); // Instancia del servicio

    public CalTypeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Reutilizamos el método POST
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configurar la codificación UTF-8
        request.setCharacterEncoding("UTF-8");

        // Leer el cuerpo de la solicitud
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String body = stringBuilder.toString();

        // Verifica si el cuerpo no está vacío antes de intentar procesarlo
        if (body.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cuerpo de la solicitud vacío");
            return;
        }

        // Parsear el cuerpo como JSON
        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();

        // Leer los tipos enviados (pueden ser uno o dos)
        String tipo1 = jsonObject.has("tipo1") ? jsonObject.get("tipo1").getAsString() : null;
        String tipo2 = jsonObject.has("tipo2") ? jsonObject.get("tipo2").getAsString() : null;

        // Llamar al servicio para obtener la respuesta en formato JSON
        String jsonResponse = CalTypeService.calcularTiposEnJSON(tipo1, tipo2);

        // Configurar la respuesta HTTP y enviar el resultado
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}