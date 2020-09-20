package com.github.ammirante.tcc.extracaobacen.extracao;

import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Normativo
 *
 */
public class Normativo {

	private String titulo;
	private String assuntoNormativo;
	private String listItemId;
	private String tipoNormativo;
	private Boolean isRevogado;
	private Boolean isCancelado;
	private Date data;
	private BigDecimal numeroNormativo;
	
    /**
     * @param titulo
     * @param assuntoNormativo
     * @param listItemId
     * @param tipoNormativo
     * @param isRevogado
     * @param isCancelado
     * @param data
     * @param numeroNormativo
     */
    public Normativo(String titulo, String assuntoNormativo, String listItemId, String tipoNormativo, Boolean isRevogado, Boolean isCancelado, Date data, BigDecimal numeroNormativo) {
		this.titulo = titulo;
		this.assuntoNormativo = assuntoNormativo;
		this.listItemId = listItemId;
		this.tipoNormativo = tipoNormativo;
		this.isRevogado = isRevogado;
		this.isCancelado = isCancelado;
		this.data = data;
		this.numeroNormativo = numeroNormativo;
	}
    
    /**
     * @param titulo
     * @param assuntoNormativo
     * @param listItemId
     * @param tipoNormativo
     * @param isRevogado
     * @param isCancelado
     * @param data
     * @return
     */
    @JsonbCreator
    public static Normativo of(@JsonbProperty("title") String titulo, @JsonbProperty("AssuntoNormativoOWSMTXT") String assuntoNormativo, @JsonbProperty("listItemId") String listItemId, 
    		@JsonbProperty("TipodoNormativoOWSCHCS") String tipoNormativo, @JsonbProperty("RevogadoOWSBOOL") Boolean isRevogado, @JsonbProperty("CanceladoOWSBOOL") Boolean isCancelado, @JsonbProperty("data") Date data,
    		@JsonbProperty("NumeroOWSNMBR") BigDecimal numeroNormativo) {
    	return new Normativo(titulo, assuntoNormativo, listItemId, tipoNormativo, isRevogado, isCancelado, data, numeroNormativo);
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the assuntoNormativo
	 */
	public String getAssuntoNormativo() {
		return assuntoNormativo;
	}

	/**
	 * @return the listItemId
	 */
	public String getListItemId() {
		return listItemId;
	}

	/**
	 * @return the tipoNormativo
	 */
	public String getTipoNormativo() {
		return tipoNormativo;
	}

	/**
	 * @return the isRevogado
	 */
	public Boolean getIsRevogado() {
		return isRevogado;
	}

	/**
	 * @return the isCancelado
	 */
	public Boolean getIsCancelado() {
		return isCancelado;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
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
