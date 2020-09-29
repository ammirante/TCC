package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DetalhamentoNormativo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetalhamentoNormativo {

	@JsonProperty("conteudo")
	private List<ExibeNormativoBacen> conteudo;
	
	public DetalhamentoNormativo() {
		
	}

	/**
	 * @return the conteudo
	 */
	public List<ExibeNormativoBacen> getConteudo() {
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
