package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeChartDAO {

    private static final String FILE_PATH = "/typeChart.json"; // Ruta del archivo JSON en el classpath
    private static Gson gson = new Gson();

    public static List<TypeChart> recuperarChart() {
        List<TypeChart> typeCharts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(TypeChartDAO.class.getResourceAsStream(FILE_PATH)))) {
            Type chartLista = new TypeToken<ArrayList<TypeChart>>() {}.getType();
            typeCharts = gson.fromJson(reader, chartLista);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si el archivo no se encuentra o hay un problema en la lectura
        }
        return typeCharts;
    }

    public static TypeChart buscarPorId(int id) {
        List<TypeChart> lista = recuperarChart();
        for (TypeChart tipo : lista) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
}