package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.Date;

/**
 * NormativoDTO
 *
 */
public class NormativoDTO {

	private String titulo;
	private String assuntoNormativo;
	private String responsavel;
	private Integer itemId;
	private String tipoNormativo;
	private String numeroOWS;
	private Boolean isRevogado;
	private String sumario;
	private Boolean isCancelado;
	private Date data;
	private Integer linha;
	
	/**
	 * @param titulo
	 * @param assuntoNormativo
	 * @param responsavel
	 * @param itemId
	 * @param tipoNormativo
	 * @param numeroOWS
	 * @param isRevogado
	 * @param sumario
	 * @param isCancelado
	 * @param data
	 * @param linha
	 */
	private NormativoDTO(String titulo, String assuntoNormativo, String responsavel, Integer itemId,
			String tipoNormativo, String numeroOWS, Boolean isRevogado, String sumario, Boolean isCancelado, Date data,
			Integer linha) {
		super();
		this.titulo = titulo;
		this.assuntoNormativo = assuntoNormativo;
		this.responsavel = responsavel;
		this.itemId = itemId;
		this.tipoNormativo = tipoNormativo;
		this.numeroOWS = numeroOWS;
		this.isRevogado = isRevogado;
		this.sumario = sumario;
		this.isCancelado = isCancelado;
		this.data = data;
		this.linha = linha;
	}

	/**
	 * @param normativo
	 * @return
	 */
	public static NormativoDTO of(Normativo normativo) {
		return new NormativoDTO(normativo.getTitle(), normativo.getAssuntoNormativoOWSMTXT(), normativo.getResponsavelOWSText(), normativo.getListItemId(), 
				normativo.getTipodoNormativoOWSCHCS(), normativo.getNumeroOWSNMBR(), normativo.getRevogadoOWSBOOL(), normativo.getHitHighlightedSummary(), 
				normativo.getCanceladoOWSBOOL(), normativo.getData(), normativo.getRowNumber());
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
	 * @return the responsavel
	 */
	public String getResponsavel() {
		return responsavel;
	}
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @return the tipoNormativo
	 */
	public String getTipoNormativo() {
		return tipoNormativo;
	}
	/**
	 * @return the numeroOWS
	 */
	public String getNumeroOWS() {
		return numeroOWS;
	}
	/**
	 * @return the isRevogado
	 */
	public Boolean getIsRevogado() {
		return isRevogado;
	}
	/**
	 * @return the sumario
	 */
	public String getSumario() {
		return sumario;
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
	 * @return the linha
	 */
	public Integer getLinha() {
		return linha;
	}
}
