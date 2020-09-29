package com.github.ammirante.tcc.extracaobacen.extracao;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExibeOutrosNormativosBacen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExibeOutrosNormativosBacen {

	@JsonProperty("Titulo")
	private String titulo;
	
	@JsonProperty("DOU")
	private String diarioOficialUniao;
	
	@JsonProperty("Id")
	private Integer id;
	
	@JsonProperty("Texto")
	private String texto;
	
	/**
	 * 
	 */
	public ExibeOutrosNormativosBacen() {
		
	}
	
    /**
     * @param titulo
     * @param diarioOficialUniao
     * @param id
     * @param texto
     */
    public ExibeOutrosNormativosBacen(String titulo, Integer id, String texto) {
		this.titulo = titulo;
		this.id = id;
		this.texto = texto;
	}

    /**
     * @param titulo
     * @param diarioOficialUniao
     * @param id
     * @param texto
     * @return
     */
    @JsonbCreator
    public static ExibeOutrosNormativosBacen of(@JsonbProperty("Titulo") String titulo, @JsonbProperty("Id") Integer id, @JsonbProperty("Texto") String texto) {
        return new ExibeOutrosNormativosBacen(titulo, id, texto);
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
		return "ExibeOutrosNormativosBacen [titulo=" + titulo + ", diarioOficialUniao=" + diarioOficialUniao + ", id="
				+ id + ", texto=" + texto + "]";
	}
}
