package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.Date;

import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Normativo
 *
 */
public class Normativo {

	JsonbConfig config = new JsonbConfig().setProperty("ALLOW_JSONB_CREATOR_OPTIONAL_PARAMS", true);
	
	private String titulo;
	private String assuntoNormativo;
	private String responsavel;
	private String listItemId;
	private String tipoNormativo;
	private Boolean isRevogado;
	private Boolean isCancelado;
	private Date data;
	
    /**
     * @param titulo
     * @param assuntoNormativo
     * @param responsavel
     * @param listItemId
     * @param tipoNormativo
     * @param isRevogado
     * @param isCancelado
     * @param data
     */
    public Normativo(String titulo, String assuntoNormativo, String responsavel, String listItemId, String tipoNormativo, Boolean isRevogado, Boolean isCancelado, Date data) {
		this.titulo = titulo;
		this.assuntoNormativo = assuntoNormativo;
		this.responsavel = responsavel;
		this.listItemId = listItemId;
		this.tipoNormativo = tipoNormativo;
		this.isRevogado = isRevogado;
		this.isCancelado = isCancelado;
		this.data = data;
	}
    
    /**
     * @param titulo
     * @param assuntoNormativo
     * @param responsavel
     * @param listItemId
     * @param tipoNormativo
     * @param isRevogado
     * @param isCancelado
     * @param data
     * @return
     */
    @JsonbCreator
    public static Normativo of(@JsonbProperty("title") String titulo, @JsonbProperty("AssuntoNormativoOWSMTXT") String assuntoNormativo, @JsonbProperty("ResponsavelOWSText") String responsavel, @JsonbProperty("listItemId") String listItemId, 
    		@JsonbProperty("TipodoNormativoOWSCHCS") String tipoNormativo, @JsonbProperty("RevogadoOWSBOOL") Boolean isRevogado, @JsonbProperty("CanceladoOWSBOOL") Boolean isCancelado, @JsonbProperty("data") Date data) {
    	return new Normativo(titulo, assuntoNormativo, responsavel != null ? responsavel : null, listItemId, tipoNormativo, isRevogado, isCancelado, data);
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
	
}
