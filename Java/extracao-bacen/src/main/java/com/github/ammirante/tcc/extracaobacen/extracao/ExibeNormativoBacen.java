package com.github.ammirante.tcc.extracaobacen.extracao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExibeNormativoBacen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExibeNormativoBacen {

	@JsonProperty("TotalRows")
	private String titulo;
	
	@JsonProperty("DOU")
	private String diarioOficialUniao;
	
	@JsonProperty("Id")
	private Integer id;
	
	@JsonProperty("NormasVinculadas")
	private String normasVinculadas;
	
	@JsonProperty("Referencias")
	private String referencias;
	
	@JsonProperty("Atualizacoes")
	private String atualizacoes;
	
	@JsonProperty("Texto")
	private String texto;
	
	/**
	 * 
	 */
	public ExibeNormativoBacen() {
		
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the diarioOficialUniao
	 */
	public String getDiarioOficialUniao() {
		return diarioOficialUniao;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the normasVinculadas
	 */
	public String getNormasVinculadas() {
		return normasVinculadas;
	}

	/**
	 * @return the referencias
	 */
	public String getReferencias() {
		return referencias;
	}

	/**
	 * @return the atualizacoes
	 */
	public String getAtualizacoes() {
		return atualizacoes;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/** (non-Javadoc)
	*  @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "ExibeNormativoBacen [titulo=" + titulo + ", diarioOficialUniao=" + diarioOficialUniao
				+ ", id=" + id + ", normasVinculadas=" + normasVinculadas + ", referencias=" + referencias
				+ ", atualizacoes=" + atualizacoes + ", texto=" + texto + "]";
	}
}
