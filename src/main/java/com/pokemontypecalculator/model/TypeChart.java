package com.pokemontypecalculator.model;

import java.util.List;

public class TypeChart {

	private int id;
	private String nombre;
	private List<Double> defensa;
	private List<Double> ataque;

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

	public List<Double> getDefensa() {
		return defensa;
	}

	public void setDefensa(List<Double> defensa) {
		this.defensa = defensa;
	}

	public List<Double> getAtaque() {
		return ataque;
	}

	public void setAtaque(List<Double> ataque) {
		this.ataque = ataque;
	}

	public TypeChart(int id, String nombre, List<Double> defensa, List<Double> ataque) {
		this.id = id;
		this.nombre = nombre;
		this.defensa = defensa;
		this.ataque = ataque;
	}
}