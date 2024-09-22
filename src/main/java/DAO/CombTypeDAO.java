package DAO;

import java.util.List;

public class CombTypeDAO {


	/**
	 * 
	 * @param tipo1
	 * @param tipo2
	 * @return
	 */
	public static CombType combinarTipos(PokemonType tipo1, PokemonType tipo2) {

		List<TypeChart> tablaTipos = TypeChartDAO.recuperarChart();

		TypeChart tipo1Chart = TypeChartDAO.buscarPorId(tipo1.getId());
		TypeChart tipo2Chart = TypeChartDAO.buscarPorId(tipo2.getId());
		CombType dobletipo = new CombType(tipo1.getNombre(), tipo2.getNombre());

		calculaDefensiva(tipo1Chart, tipo2Chart, dobletipo, tablaTipos);
		calculaOfensiva(tipo1Chart, tipo2Chart, dobletipo, tablaTipos);


		return dobletipo;

	}
	/**
	 * 
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	private static void calculaOfensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
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

	/**
	 * 	
	 * @param tipo1Chart
	 * @param tipo2Chart
	 * @param dobletipo
	 * @param tablaTipos
	 */
	private static void calculaDefensiva(TypeChart tipo1Chart, TypeChart tipo2Chart, CombType dobletipo,
			List<TypeChart> tablaTipos) {
		Double estado;

		for (int i = 0; i < 18; i++) {
			estado = tipo1Chart.getDefensa().get(i) * tipo2Chart.getDefensa().get(i);
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