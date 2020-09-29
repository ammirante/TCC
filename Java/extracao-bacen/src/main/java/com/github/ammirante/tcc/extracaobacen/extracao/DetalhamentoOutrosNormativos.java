package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DetalhamentoOutrosNormativos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetalhamentoOutrosNormativos {

	@JsonProperty("conteudo")
	private List<ExibeOutrosNormativosBacen> conteudo;
	
	public DetalhamentoOutrosNormativos() {
	}
	
	/**
	 * @return the conteudo
	 */
	public List<ExibeOutrosNormativosBacen> getConteudo() {
		return conteudo;
	}

	/** (non-Javadoc)
	*  @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "DetalhamentoNormativo [conteudo=" + conteudo + "]";
	}
}
