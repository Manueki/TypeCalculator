package com.pokemontypecalculator.dao;

import java.util.List;

import com.pokemontypecalculator.impl.TypeChartDAOImpl;
import com.pokemontypecalculator.model.CombType;
import com.pokemontypecalculator.model.PokemonType;
import com.pokemontypecalculator.model.TypeChart;

public interface CombTypeDAO {

	/** Combina dos tipos para obtener los datos de una combinacion de tipos
	 * 
	 * @param tipo1
	 * @param tipo2
	 * @return
	 */
	public CombType combinarTipos(PokemonType tipo1, PokemonType tipo2);

	/** Crea una estructura combType con un unico tipo
	 * 
	 * @param tipo1
	 * @return
	 */
	public CombType crearTipoPuro(PokemonType tipo1);

	/** Calcula la parte ofensiva (cuando ataca)
	 * 
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	void calculaOfensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
			List<TypeChart> tablaTipos);

	/** Calcula la parte defensiva (cuando le atacan)
	 * 
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	void calculaDefensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
			List<TypeChart> tablaTipos);

}