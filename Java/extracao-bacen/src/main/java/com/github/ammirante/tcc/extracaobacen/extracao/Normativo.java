package com.github.ammirante.tcc.extracaobacen.extracao;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Normativo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Normativo {

	@JsonProperty("title")
	private String titulo;
	
	@JsonProperty("AssuntoNormativoOWSMTXT")
	private String assuntoNormativo;
	
	@JsonProperty("listItemId")
	private String listItemId;
	
	@JsonProperty("TipodoNormativoOWSCHCS")
	private String tipoNormativo;
	
	@JsonProperty("RevogadoOWSBOOL")
	private Integer isRevogado;
	
	@JsonProperty("CanceladoOWSBOOL")
	private Integer isCancelado;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("NumeroOWSNMBR")
	private BigDecimal numeroNormativo;
	
	@JsonProperty("ResponsavelOWSText")
	private String responsavel;
	
	public Normativo() {
		
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the assuntoNormativo
	 */
	public String getAssuntoNormativo() {
		return assuntoNormativo;
	}


	/**
	 * @param assuntoNormativo the assuntoNormativo to set
	 */
	public void setAssuntoNormativo(String assuntoNormativo) {
		this.assuntoNormativo = assuntoNormativo;
	}


	/**
	 * @return the listItemId
	 */
	public String getListItemId() {
		return listItemId;
	}


	/**
	 * @param listItemId the listItemId to set
	 */
	public void setListItemId(String listItemId) {
		this.listItemId = listItemId;
	}


	/**
	 * @return the tipoNormativo
	 */
	public String getTipoNormativo() {
		return tipoNormativo;
	}


	/**
	 * @param tipoNormativo the tipoNormativo to set
	 */
	public void setTipoNormativo(String tipoNormativo) {
		this.tipoNormativo = tipoNormativo;
	}


	/**
	 * @return the isRevogado
	 */
	public Integer getIsRevogado() {
		return isRevogado;
	}


	/**
	 * @param isRevogado the isRevogado to set
	 */
	public void setIsRevogado(Integer isRevogado) {
		this.isRevogado = isRevogado;
	}


	/**
	 * @return the isCancelado
	 */
	public Integer getIsCancelado() {
		return isCancelado;
	}


	/**
	 * @param isCancelado the isCancelado to set
	 */
	public void setIsCancelado(Integer isCancelado) {
		this.isCancelado = isCancelado;
	}


	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}


	/**
	 * @return the numeroNormativo
	 */
	public BigDecimal getNumeroNormativo() {
		return numeroNormativo;
	}


	/**
	 * @param numeroNormativo the numeroNormativo to set
	 */
	public void setNumeroNormativo(BigDecimal numeroNormativo) {
		this.numeroNormativo = numeroNormativo;
	}


	/**
	 * @return the responsavel
	 */
	public String getResponsavel() {
		return responsavel;
	}


	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	/** (non-Javadoc)
	*  @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Normativo [titulo=" + titulo + ", assuntoNormativo=" + assuntoNormativo + ", listItemId=" + listItemId
				+ ", tipoNormativo=" + tipoNormativo + ", isRevogado=" + isRevogado + ", isCancelado=" + isCancelado
				+ ", data=" + data + ", numeroNormativo=" + numeroNormativo + "]";
	}
}
