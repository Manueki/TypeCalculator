package type_calculator;

import java.util.List;

import DAO.PokemonType;
import DAO.PokemonTypeDAO;

public class main {
    public static void main(String[] args) {

        // Recuperar todos los tipos de Pokémon
        System.out.println("Tipos de Pokémon disponibles:");
        for (PokemonType tipo : PokemonTypeDAO.recuperarTipos()) {
            tipo.mostrarInfo();
        }

        // Insertar un nuevo tipo de Pokémon
        PokemonType electrico = new PokemonType("Eléctrico");
        electrico.setDebilidades(List.of("Tierra"));
        electrico.setResistencias(List.of("Eléctrico", "Volador", "Acero"));
        electrico.setFuerteContra(List.of("Agua", "Volador"));
        electrico.setDebilContra(List.of("Tierra"));
        PokemonTypeDAO.insertar(electrico);

        // Buscar un tipo de Pokémon por nombre
        PokemonType buscado = PokemonTypeDAO.buscarPorNombre("Fuego");
        if (buscado != null) {
            System.out.println("Información del tipo Fuego:");
            buscado.mostrarInfo();
        } else {
            System.out.println("Tipo Fuego no encontrado.");
        }
    }
}