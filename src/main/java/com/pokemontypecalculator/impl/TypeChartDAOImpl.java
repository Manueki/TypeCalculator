package com.pokemontypecalculator.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pokemontypecalculator.dao.TypeChartDAO;
import com.pokemontypecalculator.model.TypeChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeChartDAOImpl implements TypeChartDAO{

    private static final String FILE_PATH = "/typeChart.json"; // Ruta del archivo JSON en el classpath
    private static Gson gson = new Gson();

	/** Recupera en una lista la tabla de tipos del json
	 * @return
	 */
    public List<TypeChart> recuperarChart() {
        List<TypeChart> typeCharts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(TypeChartDAOImpl.class.getResourceAsStream(FILE_PATH)))) {
            Type chartLista = new TypeToken<ArrayList<TypeChart>>() {}.getType();
            typeCharts = gson.fromJson(reader, chartLista);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si el archivo no se encuentra o hay un problema en la lectura
        }
        return typeCharts;
    }

    
	/** Recupera las efectividades de un tipo por su id
	 * @param id
	 * @return
	 */
    public TypeChart buscarPorId(int id) {
        List<TypeChart> lista = recuperarChart();
        for (TypeChart tipo : lista) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
}