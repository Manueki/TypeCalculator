package DAO;

import java.util.ArrayList;
import java.util.List;

public class PokemonType {

	private int id;
	private String nombre;
	private List<String> debilidades;
	private List<String> resistencias;
	private List<String> inmunidades;
	private List<String> fuerteContra;
	private List<String> debilContra;
	private List<String> inmuneContra;

	public PokemonType(String nombre) {
		this.nombre = nombre;
		this.debilidades = new ArrayList<>();
		this.resistencias = new ArrayList<>();
		this.fuerteContra = new ArrayList<>();
		this.debilContra = new ArrayList<>();
	}

	public PokemonType() {
		// TODO Auto-generated constructor stub
		this.nombre = "null";
		this.debilidades = new ArrayList<>();
		this.resistencias = new ArrayList<>();
		this.fuerteContra = new ArrayList<>();
		this.debilContra = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getDebilidades() {
		return debilidades;
	}

	public void setDebilidades(List<String> debilidades) {
		this.debilidades = debilidades;
	}

	public List<String> getResistencias() {
		return resistencias;
	}

	public void setResistencias(List<String> resistencias) {
		this.resistencias = resistencias;
	}
	
	public List<String> getinmunidades() {
		return inmunidades;
	}

	public void setinmunidades(List<String> inmunidades) {
		this.inmunidades = inmunidades;
	}

	public List<String> getFuerteContra() {
		return fuerteContra;
	}

	public void setFuerteContra(List<String> fuerteContra) {
		this.fuerteContra = fuerteContra;
	}

	public List<String> getDebilContra() {
		return debilContra;
	}

	public void setDebilContra(List<String> debilContra) {
		this.debilContra = debilContra;
	}

	public List<String> getInmuneContra() {
		return inmuneContra;
	}

	public void setInmuneContra(List<String> inmuneContra) {
		this.inmuneContra = inmuneContra;
	}


	// Método para mostrar información del tipo de Pokémon
	public void mostrarInfo() {
		System.out.println("Tipo: " + nombre);
		System.out.println("Debilidades: " + String.join(", ", debilidades));
		System.out.println("Resistencias: " + String.join(", ", resistencias));
		System.out.println("Inmunidades: " + String.join(", ", inmunidades));
		System.out.println("Fuerte contra: " + String.join(", ", fuerteContra));
		System.out.println("Débil contra: " + String.join(", ", debilContra));
		System.out.println("Inmune contra: " + String.join(", ", inmuneContra));
	}
}