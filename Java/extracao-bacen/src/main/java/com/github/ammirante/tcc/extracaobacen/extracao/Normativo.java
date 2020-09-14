package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.Date;

/**
 * Normativo
 *
 */
public class Normativo {

	private String title;
	private String refinableString01;
	private String assuntoNormativoOWSMTXT;
	private String responsavelOWSText;
	private Integer listItemId;
	private String tipodoNormativoOWSCHCS;
	private String numeroOWSNMBR;
	private Boolean revogadoOWSBOOL;
	private String hitHighlightedSummary;
	private Boolean canceladoOWSBOOL;
	private Date data;
	private String refinableString03;
	private Integer rowNumber;
	
	/**
	 * 
	 */
	public Normativo() {
		
	}
	
	/**
	 * @param title
	 * @param refinableString01
	 * @param assuntoNormativoOWSMTXT
	 * @param responsavelOWSText
	 * @param listItemId
	 * @param tipodoNormativoOWSCHCS
	 * @param numeroOWSNMBR
	 * @param revogadoOWSBOOL
	 * @param hitHighlightedSummary
	 * @param canceladoOWSBOOL
	 * @param data
	 * @param refinableString03
	 * @param rowNumber
	 */
	public Normativo(String title, String refinableString01, String assuntoNormativoOWSMTXT, String responsavelOWSText,
			Integer listItemId, String tipodoNormativoOWSCHCS, String numeroOWSNMBR, Boolean revogadoOWSBOOL,
			String hitHighlightedSummary, Boolean canceladoOWSBOOL, Date data, String refinableString03,
			Integer rowNumber) {
		super();
		this.title = title;
		this.refinableString01 = refinableString01;
		this.assuntoNormativoOWSMTXT = assuntoNormativoOWSMTXT;
		this.responsavelOWSText = responsavelOWSText;
		this.listItemId = listItemId;
		this.tipodoNormativoOWSCHCS = tipodoNormativoOWSCHCS;
		this.numeroOWSNMBR = numeroOWSNMBR;
		this.revogadoOWSBOOL = revogadoOWSBOOL;
		this.hitHighlightedSummary = hitHighlightedSummary;
		this.canceladoOWSBOOL = canceladoOWSBOOL;
		this.data = data;
		this.refinableString03 = refinableString03;
		this.rowNumber = rowNumber;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the refinableString01
	 */
	public String getRefinableString01() {
		return refinableString01;
	}
	/**
	 * @param refinableString01 the refinableString01 to set
	 */
	public void setRefinableString01(String refinableString01) {
		this.refinableString01 = refinableString01;
	}
	/**
	 * @return the assuntoNormativoOWSMTXT
	 */
	public String getAssuntoNormativoOWSMTXT() {
		return assuntoNormativoOWSMTXT;
	}
	/**
	 * @param assuntoNormativoOWSMTXT the assuntoNormativoOWSMTXT to set
	 */
	public void setAssuntoNormativoOWSMTXT(String assuntoNormativoOWSMTXT) {
		this.assuntoNormativoOWSMTXT = assuntoNormativoOWSMTXT;
	}
	/**
	 * @return the responsavelOWSText
	 */
	public String getResponsavelOWSText() {
		return responsavelOWSText;
	}
	/**
	 * @param responsavelOWSText the responsavelOWSText to set
	 */
	public void setResponsavelOWSText(String responsavelOWSText) {
		this.responsavelOWSText = responsavelOWSText;
	}
	/**
	 * @return the listItemId
	 */
	public Integer getListItemId() {
		return listItemId;
	}
	/**
	 * @param listItemId the listItemId to set
	 */
	public void setListItemId(Integer listItemId) {
		this.listItemId = listItemId;
	}
	/**
	 * @return the tipodoNormativoOWSCHCS
	 */
	public String getTipodoNormativoOWSCHCS() {
		return tipodoNormativoOWSCHCS;
	}
	/**
	 * @param tipodoNormativoOWSCHCS the tipodoNormativoOWSCHCS to set
	 */
	public void setTipodoNormativoOWSCHCS(String tipodoNormativoOWSCHCS) {
		this.tipodoNormativoOWSCHCS = tipodoNormativoOWSCHCS;
	}
	/**
	 * @return the numeroOWSNMBR
	 */
	public String getNumeroOWSNMBR() {
		return numeroOWSNMBR;
	}
	/**
	 * @param numeroOWSNMBR the numeroOWSNMBR to set
	 */
	public void setNumeroOWSNMBR(String numeroOWSNMBR) {
		this.numeroOWSNMBR = numeroOWSNMBR;
	}
	/**
	 * @return the revogadoOWSBOOL
	 */
	public Boolean getRevogadoOWSBOOL() {
		return revogadoOWSBOOL;
	}
	/**
	 * @param revogadoOWSBOOL the revogadoOWSBOOL to set
	 */
	public void setRevogadoOWSBOOL(Boolean revogadoOWSBOOL) {
		this.revogadoOWSBOOL = revogadoOWSBOOL;
	}
	/**
	 * @return the hitHighlightedSummary
	 */
	public String getHitHighlightedSummary() {
		return hitHighlightedSummary;
	}
	/**
	 * @param hitHighlightedSummary the hitHighlightedSummary to set
	 */
	public void setHitHighlightedSummary(String hitHighlightedSummary) {
		this.hitHighlightedSummary = hitHighlightedSummary;
	}
	/**
	 * @return the canceladoOWSBOOL
	 */
	public Boolean getCanceladoOWSBOOL() {
		return canceladoOWSBOOL;
	}
	/**
	 * @param canceladoOWSBOOL the canceladoOWSBOOL to set
	 */
	public void setCanceladoOWSBOOL(Boolean canceladoOWSBOOL) {
		this.canceladoOWSBOOL = canceladoOWSBOOL;
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
	 * @return the refinableString03
	 */
	public String getRefinableString03() {
		return refinableString03;
	}
	/**
	 * @param refinableString03 the refinableString03 to set
	 */
	public void setRefinableString03(String refinableString03) {
		this.refinableString03 = refinableString03;
	}
	/**
	 * @return the rowNumber
	 */
	public Integer getRowNumber() {
		return rowNumber;
	}
	/**
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	
}
