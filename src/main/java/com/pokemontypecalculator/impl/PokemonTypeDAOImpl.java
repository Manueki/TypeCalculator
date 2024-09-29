package com.pokemontypecalculator.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pokemontypecalculator.dao.PokemonTypeDAO;
import com.pokemontypecalculator.model.PokemonType;

public class PokemonTypeDAOImpl implements PokemonTypeDAO {

	/**
	 * Recupera en una lista con datos de los tipos del json
	 * 
	 * @return
	 */
	public List<PokemonType> recuperarTipos() {

		Gson gson = new Gson();
		try (InputStream inputStream = PokemonTypeDAO.class.getClassLoader().getResourceAsStream("typeList.json");
				InputStreamReader reader = new InputStreamReader(inputStream)) {

			if (inputStream == null) {
				throw new IOException("No se pudo encontrar el archivo JSON.");
			}

			Type tipoLista = new TypeToken<ArrayList<PokemonType>>() {
			}.getType();
			return gson.fromJson(reader, tipoLista);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	/**
	 * Recupera datos de un tipo mediante su nombre (en español)
	 * 
	 * @return
	 */
	public PokemonType buscarPorNombre(String nombre) {

		List<PokemonType> lista = recuperarTipos();
		for (PokemonType tipo : lista) {
			if (tipo.getNombre().equalsIgnoreCase(nombre)) {
				return tipo;
			}
		}
		return null; // Si no se encuentra, devuelve null
	}
}
