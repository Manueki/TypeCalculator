package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeChartDAO {

	private static final String FILE_PATH = "src/main/resources/typeChart.json"; // Ruta del archivo JSON
	private static Gson gson = new Gson();

	public static List<TypeChart> recuperarChart() {
		try (FileReader reader = new FileReader(FILE_PATH)) {
			Type chartLista = new TypeToken<ArrayList<TypeChart>>() {
			}.getType();
			return gson.fromJson(reader, chartLista);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public static TypeChart buscarPorId(int id) {
		List<TypeChart> lista = recuperarChart();
		for (TypeChart tipo : lista) {
			if (tipo.getId()==(id)) {
				return tipo;
			}
		}
		return null; // Si no se encuentra, devuelve null
	}
}