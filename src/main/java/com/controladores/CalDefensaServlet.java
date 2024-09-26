package com.controladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import DAO.CombType;
import DAO.CombTypeDAO;
import DAO.PokemonType;
import DAO.PokemonTypeDAO;

@WebServlet("/calDefensa")
public class CalDefensaServlet extends HttpServlet {
    public static Connection conexion;
    private static final long serialVersionUID = 1L;

    public CalDefensaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Leer el cuerpo de la solicitud
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String body = stringBuilder.toString();
        
        // Verifica si el cuerpo no está vacío antes de intentar parsearlo
        if (body.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cuerpo de la solicitud vacío");
            return; // Salir si el cuerpo está vacío
        }
        
        // Parsear el cuerpo como JSON
        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();

        // Leer los tipos enviados (pueden ser uno o dos)
        String tipo1 = jsonObject.has("tipo1") ? jsonObject.get("tipo1").getAsString() : null;
        String tipo2 = jsonObject.has("tipo2") ? jsonObject.get("tipo2").getAsString() : null;


        System.out.print("Tipo: " + tipo1);
        PokemonType tipoPrimario = PokemonTypeDAO.buscarPorNombre(tipo1);
        if (tipo2 != null) {
            System.out.println(" " + tipo2);
            PokemonType tipoSecundario = PokemonTypeDAO.buscarPorNombre(tipo2);
            CombType tipoComb = CombTypeDAO.combinarTipos(tipoPrimario, tipoSecundario);
            tipoComb.mostrarInfo();

//            // Obtiene la sesión, creando una nueva si no existe
//            HttpSession session = request.getSession(true); // true crea una nueva sesión si no existe
//
//            
//            session.setAttribute("party1", tipoComb);
         // Enviar respuesta JSON
            
            Gson gson = new Gson();
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(tipoComb));
            out.flush();
            
        } else {
        	CombType tipoComb = CombTypeDAO.crearTipoPuro(tipoPrimario);
        	
 // Enviar respuesta JSON
            
            Gson gson = new Gson();
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(tipoComb));
            out.flush();
        	
            System.out.println(); // Solo imprime un salto de línea
        }
    }
}
