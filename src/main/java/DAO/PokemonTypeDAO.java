package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypeDAO {

	private static final String FILE_PATH = "src/main/resources/typeList.json"; // Ruta del archivo JSON
	private static Gson gson = new Gson();

	public static List<PokemonType> recuperarTipos() {
		try (FileReader reader = new FileReader(FILE_PATH)) {
			Type tipoLista = new TypeToken<ArrayList<PokemonType>>() {
			}.getType();
			return gson.fromJson(reader, tipoLista);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}


	public static void insertar(PokemonType nuevoTipo) {
		List<PokemonType> lista = recuperarTipos(); // Leer los tipos actuales
		lista.add(nuevoTipo); // Añadir el nuevo tipo a la lista

		// Guardar la lista de vuelta en el archivo JSON
		try (FileWriter writer = new FileWriter(FILE_PATH)) {
			gson.toJson(lista, writer);
			System.out.println("Tipo insertado con éxito: " + nuevoTipo.getNombre());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PokemonType buscarPorNombre(String nombre) {
		List<PokemonType> lista = recuperarTipos();
		for (PokemonType tipo : lista) {
			if (tipo.getNombre().equalsIgnoreCase(nombre)) {
				return tipo;
			}
		}
		return null; // Si no se encuentra, devuelve null
	}
}