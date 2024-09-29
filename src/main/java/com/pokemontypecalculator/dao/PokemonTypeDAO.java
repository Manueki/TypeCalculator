package com.pokemontypecalculator.dao;

import com.pokemontypecalculator.model.PokemonType;

import java.util.List;

public interface PokemonTypeDAO {

	/**
	 * Recupera en una lista con datos de los tipos del json
	 * 
	 * @return
	 */
	public List<PokemonType> recuperarTipos();

	/**
	 * Recupera datos de un tipo mediante su nombre (en español)
	 * 
	 * @return
	 */
	public PokemonType buscarPorNombre(String nombre);

}
