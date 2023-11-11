package br.com.fiap.autohelp.beans;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Guincho {
	
	@JsonProperty
	private int idGuincho;
	
	@JsonProperty
    private double capacidadeCarga;

    public Guincho(int idGuincho, double capacidadeCarga) {
        this.setIdGuincho(idGuincho);
        this.setCapacidadeCarga(capacidadeCarga);
    }

    public Guincho() {
    	
    }
	public int getIdGuincho() {
		return idGuincho;
	}

	public void setIdGuincho(int idGuincho) {
		this.idGuincho = idGuincho;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
}
