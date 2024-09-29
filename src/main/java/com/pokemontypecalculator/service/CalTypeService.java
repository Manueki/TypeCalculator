package com.pokemontypecalculator.service;

import com.google.gson.Gson;
import com.pokemontypecalculator.dao.CombTypeDAO;
import com.pokemontypecalculator.dao.PokemonTypeDAO;
import com.pokemontypecalculator.impl.CombTypeDAOImpl;
import com.pokemontypecalculator.impl.PokemonTypeDAOImpl;
import com.pokemontypecalculator.model.CombType;
import com.pokemontypecalculator.model.PokemonType;

public class CalTypeService {

    private Gson gson = new Gson(); // Utilizar Gson aquí para crear la respuesta

    /**
     * Calcula el tipo combinado y devuelve el resultado en formato JSON.
     *
     * @param tipo1 Primer tipo de Pokémon (nombre)
     * @param tipo2 Segundo tipo de Pokémon (nombre, opcional)
     * @return Respuesta JSON con la combinación de tipos.
     */
    public String calcularTiposEnJSON(String tipo1, String tipo2) {
        // Buscar el primer tipo por nombre
    	
    	PokemonTypeDAO pokemonType = new PokemonTypeDAOImpl();
    	CombTypeDAO combType = new CombTypeDAOImpl();
    	
        PokemonType tipoPrimario = pokemonType.buscarPorNombre(tipo1);

        CombType tipoComb;

        // Si hay un segundo tipo, hacer la combinación
        if (tipo2 != null && !tipo2.isEmpty()) {
            PokemonType tipoSecundario = pokemonType.buscarPorNombre(tipo2);
            tipoComb = combType.combinarTipos(tipoPrimario, tipoSecundario);
        } else {
            // Si solo hay un tipo, crear un tipo puro
            tipoComb = combType.crearTipoPuro(tipoPrimario);
        }

        // Convertir el resultado en JSON y devolverlo
        return gson.toJson(tipoComb);
    }
}