package br.com.fiap.autohelp.beans;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contrato {
	
	@JsonProperty
	private String tipoContrato;
	
    @JsonProperty
    private String codigoContrato;
    
    @JsonProperty
    private String coberturaContrato;
    
    @JsonProperty
    private int idContrato;
    
    private Date dataInicio;
    
    private Date dataTermino;
    
    private double valorContrato;
    
    private boolean ativo;
    
    public Contrato(String tipoContrato, String codigoContrato, String coberturaContrato, int idContrato, Date dataInicio, Date dataTermino, double valorContrato) {
        this.tipoContrato = tipoContrato;
        this.codigoContrato = codigoContrato;
        this.coberturaContrato = coberturaContrato;
        this.idContrato = idContrato;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorContrato = valorContrato;
        this.ativo = true;
    }

    public Contrato() {}

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getCoberturaContrato() {
        return coberturaContrato;
    }

    public void setCoberturaContrato(String coberturaContrato) {
        this.coberturaContrato = coberturaContrato;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
