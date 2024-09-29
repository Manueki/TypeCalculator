package type_calculator;

import DAO.CombType;
import DAO.CombTypeDAO;
import DAO.PokemonType;
import DAO.PokemonTypeDAO;

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
        //Crear tipo compuesto
        PokemonType tipo1 = PokemonTypeDAO.buscarPorNombre("Tierra");
        PokemonType tipo2 = PokemonTypeDAO.buscarPorNombre("Agua");
        CombType tipoCompuesto = CombTypeDAO.combinarTipos(tipo1, tipo2);
        tipoCompuesto.mostrarInfo();
    }
}