package br.com.fiap.autohelp.beans;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitacaoChamado {
	
	@JsonProperty
	private int numeroSolicitacao;
	
	@JsonProperty
    private String descricao;
	
	@JsonProperty
    private String responsavel;
	
	@JsonProperty
    private Date dataAbertura;
	
	@JsonProperty
    private int idVeiculo;
	
	@JsonProperty
    private int idGuincho;
	
	@JsonProperty
    private int idContrato;
    
    public SolicitacaoChamado(int numeroSolicitacao, String descricao, String responsavel, Date dataAbertura, int idVeiculo, int idGuincho, int idContrato) {
        this.numeroSolicitacao = numeroSolicitacao;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataAbertura = dataAbertura;
        this.idGuincho = idGuincho;
        this.idVeiculo = idVeiculo;
        this.idContrato = idContrato;
    }
    
    public SolicitacaoChamado() {
    	
    }

	public int getNumeroSolicitacao() {
		return numeroSolicitacao;
	}

	public void setNumeroSolicitacao(int numeroSolicitacao) {
		this.numeroSolicitacao = numeroSolicitacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdGuincho() {
		return idGuincho;
	}

	public void setIdGuincho(int idGuincho) {
		this.idGuincho = idGuincho;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
}
