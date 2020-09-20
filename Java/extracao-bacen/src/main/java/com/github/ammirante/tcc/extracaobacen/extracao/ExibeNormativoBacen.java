package com.github.ammirante.tcc.extracaobacen.extracao;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * ExibeNormativoBacen
 *
 */
public class ExibeNormativoBacen {

	private String titulo;
	private String diarioOficialUniao;
	private Integer id;
	private String normasVinculadas;
	private String referencias;
	private String atualizacoes;
	private String texto;
	
	/**
	 * 
	 */
	public ExibeNormativoBacen() {
		
	}
	
    /**
     * @param tipo
     * @param diarioOficialUniao
     * @param id
     * @param normasVinculadas
     * @param referencias
     * @param texto
     */
    public ExibeNormativoBacen(String titulo, String diarioOficialUniao, Integer id, String normasVinculadas, String referencias, String texto) {
		this.titulo = titulo;
		this.diarioOficialUniao = diarioOficialUniao;
		this.id = id;
		this.normasVinculadas = normasVinculadas;
		this.referencias = referencias;
		this.texto = texto;
	}

    /**
     * @param titulo
     * @param diarioOficialUniao
     * @param id
     * @param normasVinculadas
     * @param referencias
     * @param texto
     * @return
     */
    @JsonbCreator
    public static ExibeNormativoBacen of(@JsonbProperty("Titulo") String titulo, @JsonbProperty("DOU") String diarioOficialUniao, @JsonbProperty("Id") Integer id, @JsonbProperty("NormasVinculadas") String normasVinculadas, 
    		@JsonbProperty("Referencias") String referencias, @JsonbProperty("Texto") String texto) {
        return new ExibeNormativoBacen(titulo, diarioOficialUniao, id, normasVinculadas, referencias, texto);
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
