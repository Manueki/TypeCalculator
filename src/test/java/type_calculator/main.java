package type_calculator;

import com.pokemontypecalculator.dao.CombTypeDAO;
import com.pokemontypecalculator.dao.PokemonTypeDAO;
import com.pokemontypecalculator.impl.CombTypeDAOImpl;
import com.pokemontypecalculator.impl.PokemonTypeDAOImpl;
import com.pokemontypecalculator.model.CombType;
import com.pokemontypecalculator.model.PokemonType;

public class main {
    public static void main(String[] args) {

        // Recuperar todos los tipos de Pokémon
//        System.out.println("Tipos de Pokémon disponibles:");
//        for (PokemonType tipo : PokemonTypeDAO.recuperarTipos()) {
//            tipo.mostrarInfo();
//        }

//        // Buscar un tipo de Pokémon por nombre
//        PokemonType buscado = PokemonTypeDAO.buscarPorNombre("Fuego");
//        if (buscado != null) {
//            System.out.println("Información del tipo Fuego:");
//            buscado.mostrarInfo();
//        } else {
//            System.out.println("Tipo Fuego no encontrado.");
//        }
//        
    	PokemonTypeDAO pokemonType = new PokemonTypeDAOImpl();
    	CombTypeDAO combType = new CombTypeDAOImpl();
        //Crear tipo compuesto
        PokemonType tipo1 = pokemonType.buscarPorNombre("Agua");
        PokemonType tipo2 = pokemonType.buscarPorNombre("Tierra");
        CombType tipoCompuesto = combType.combinarTipos(tipo1, tipo2);
        tipoCompuesto.mostrarInfo();
    }
}