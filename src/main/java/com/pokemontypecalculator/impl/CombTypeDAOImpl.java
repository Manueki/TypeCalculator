package com.pokemontypecalculator.impl;

import java.util.List;

import com.pokemontypecalculator.dao.CombTypeDAO;
import com.pokemontypecalculator.dao.TypeChartDAO;
import com.pokemontypecalculator.model.CombType;
import com.pokemontypecalculator.model.PokemonType;
import com.pokemontypecalculator.model.TypeChart;

public class CombTypeDAOImpl implements CombTypeDAO{

	/** Combina dos tipos para obtener los datos de una combinacion de tipos
	 * 
	 * @param tipo1
	 * @param tipo2
	 * @return
	 */
	public CombType combinarTipos(PokemonType tipo1, PokemonType tipo2) {

		TypeChartDAO typeChart = new TypeChartDAOImpl();
		
		List<TypeChart> tablaTipos = typeChart.recuperarChart();

		TypeChart tipo1Chart = typeChart.buscarPorId(tipo1.getId());
		TypeChart tipo2Chart = typeChart.buscarPorId(tipo2.getId());
		CombType dobletipo = new CombType(tipo1.getNombre(), tipo2.getNombre());

		calculaDefensiva(tipo1Chart, tipo2Chart, dobletipo, tablaTipos);
		calculaOfensiva(tipo1Chart, tipo2Chart, dobletipo, tablaTipos);

		return dobletipo;

	}

	/** Crea una estructura combType con un unico tipo
	 * 
	 * @param tipo1
	 * @return
	 */
	public CombType crearTipoPuro(PokemonType tipo1) {

		TypeChartDAO typeChart = new TypeChartDAOImpl();

		List<TypeChart> tablaTipos = typeChart.recuperarChart();

		if (tipo1 == null) {
			return null;
		}
		TypeChart tipo1Chart = typeChart.buscarPorId(tipo1.getId());
		CombType dobletipo = new CombType(tipo1.getNombre(), tipo1.getNombre());

		calculaDefensiva(tipo1Chart, tipo1Chart, dobletipo, tablaTipos);
		calculaOfensiva(tipo1Chart, tipo1Chart, dobletipo, tablaTipos);

		return dobletipo;

	}

	/** Calcula la parte ofensiva (cuando ataca)
	 * 
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	public void calculaOfensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
			List<TypeChart> tablaTipos) {
		Double estado;
		for (int i = 0; i < 18; i++) {

			estado = (tipo1Chart.getAtaque().get(i) > tipo2Chart.getAtaque().get(i)) ? tipo1Chart.getAtaque().get(i)
					: tipo2Chart.getAtaque().get(i);

			switch (String.valueOf(estado)) {

			case "1.0":
				dobletipo.getNormalContra().add(tablaTipos.get(i).getNombre());
				break;

			case "2.0":
				dobletipo.getFuerteContra().add(tablaTipos.get(i).getNombre());
				break;

			case "0.5":
				dobletipo.getDebilContra().add(tablaTipos.get(i).getNombre());
				break;

			case "0.0":
				dobletipo.getInmuneContra().add(tablaTipos.get(i).getNombre());
				break;
			}

		}

	}

	/** Calcula la parte defensiva (cuando le atacan)
	 * 
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	public void calculaDefensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
			List<TypeChart> tablaTipos) {
		Double estado;

		for (int i = 0; i < 18; i++) {
			if (tipo1Chart.equals(tipo2Chart)) {

				estado = tipo1Chart.getDefensa().get(i);

			} else {

				estado = tipo1Chart.getDefensa().get(i) * tipo2Chart.getDefensa().get(i);

			}
			switch (String.valueOf(estado)) {

			case "1.0":
				dobletipo.getDanoNormal().add(tablaTipos.get(i).getNombre());
				break;

			case "2.0":
				dobletipo.getDebilidades().add(tablaTipos.get(i).getNombre());
				break;

			case "0.5":
				dobletipo.getResistencias().add(tablaTipos.get(i).getNombre());
				break;

			case "0.25":
				dobletipo.getSuperResistencias().add(tablaTipos.get(i).getNombre());
				break;

			case "4.0":
				dobletipo.getSuperDebilidades().add(tablaTipos.get(i).getNombre());
				break;

			case "0.0":
				dobletipo.getInmunidades().add(tablaTipos.get(i).getNombre());
				break;
			}

		}

	}

}