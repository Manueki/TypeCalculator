package com.pokemontypecalculator.dao;

import java.util.List;

import com.pokemontypecalculator.model.TypeChart;

public interface TypeChartDAO {

	/** Recupera en una lista la tabla de tipos del json
	 * @return
	 */
	public List<TypeChart> recuperarChart();

	/** Recupera las efectividades de un tipo por su id
	 * @param id
	 * @return
	 */
	public TypeChart buscarPorId(int id);

}