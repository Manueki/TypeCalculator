package com.pokemontypecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class CombType {

	private String tipo1;
	private String tipo2;
	private List<String> superDebilidades;
	private List<String> debilidades;
	private List<String> danoNormal;
	private List<String> resistencias;
	private List<String> superResistencias;
	private List<String> inmunidades;
	private List<String> fuerteContra;
	private List<String> debilContra;
	private List<String> inmuneContra;
	private List<String> normalContra;



	public String getTipo1() {
		return tipo1;
	}



	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}



	public String getTipo2() {
		return tipo2;
	}



	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}



	public List<String> getSuperDebilidades() {
		return superDebilidades;
	}



	public void setSuperDebilidades(List<String> superDebilidades) {
		this.superDebilidades = superDebilidades;
	}



	public List<String> getDebilidades() {
		return debilidades;
	}



	public void setDebilidades(List<String> debilidades) {
		this.debilidades = debilidades;
	}



	public List<String> getDanoNormal() {
		return danoNormal;
	}



	public void setDanoNormal(List<String> danoNormal) {
		this.danoNormal = danoNormal;
	}



	public List<String> getResistencias() {
		return resistencias;
	}



	public void setResistencias(List<String> resistencias) {
		this.resistencias = resistencias;
	}



	public List<String> getSuperResistencias() {
		return superResistencias;
	}



	public void setSuperResistencias(List<String> superResistencias) {
		this.superResistencias = superResistencias;
	}



	public List<String> getInmunidades() {
		return inmunidades;
	}



	public void setInmunidades(List<String> inmunidades) {
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



	public List<String> getNormalContra() {
		return normalContra;
	}



	public void setNormalContra(List<String> normalContra) {
		this.normalContra = normalContra;
	}



	public void mostrarInfo() {
		System.out.println("Tipo: " + tipo1 +" "+ tipo2);
		System.out.println("\n Defensivamente: \n");		
		System.out.println("Sufre x4: " + String.join(", ", superDebilidades));
		System.out.println("Sufre x2: " + String.join(", ", debilidades));
		System.out.println("Daño normal: " + String.join(", ", danoNormal));		
		System.out.println("Resiste x0.5: " + String.join(", ", resistencias));
		System.out.println("Resiste x0.25: " + String.join(", ", superResistencias));
		System.out.println("Inmune: " + String.join(", ", inmunidades));
		System.out.println("\n Ofensivamente: \n");
		System.out.println("Fuerte contra: " + String.join(", ", fuerteContra));
		System.out.println("Débil contra: " + String.join(", ", debilContra));
		System.out.println("Inmune contra: " + String.join(", ", inmuneContra));
		System.out.println("Normal contra: " + String.join(", ", normalContra));		
	}



    public CombType(String tipo1, String tipo2) {
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.superDebilidades = new ArrayList<>();
        this.debilidades = new ArrayList<>();
        this.danoNormal = new ArrayList<>();
        this.resistencias = new ArrayList<>();
        this.superResistencias = new ArrayList<>();
        this.inmunidades = new ArrayList<>();
        this.fuerteContra = new ArrayList<>();
        this.debilContra = new ArrayList<>();
        this.inmuneContra = new ArrayList<>();
        this.normalContra = new ArrayList<>();
    }


}