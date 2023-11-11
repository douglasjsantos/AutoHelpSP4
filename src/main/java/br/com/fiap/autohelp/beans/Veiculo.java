package br.com.fiap.autohelp.beans;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Veiculo {
	
	@JsonProperty
	private int idVeiculo; 
	
	@JsonProperty
    private String placa;
	
	@JsonProperty
    private String marca;
	
	@JsonProperty
    private String modelo;
	
	@JsonProperty
    private String tipo;
	
	@JsonProperty
    private String carga;
	
	@JsonProperty
    private String ano;

    public Veiculo(int idVeiculo, String marca, String modelo, String tipo, String carga, String ano) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.carga = carga;
        this.ano = ano;
    }
    
    public Veiculo() {
    	
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
