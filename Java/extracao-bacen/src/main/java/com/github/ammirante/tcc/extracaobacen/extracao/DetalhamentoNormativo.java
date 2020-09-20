package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * DetalhamentoNormativo
 *
 */
public class DetalhamentoNormativo {

	private List<ExibeNormativoBacen> conteudo;
	
	/**
	 * 
	 */
	/**
	 * @param conteudo
	 */
	public DetalhamentoNormativo(List<ExibeNormativoBacen> conteudo) {
		this.conteudo = conteudo;
	}
	
	/**
	 * @param conteudo
	 * @return
	 */
	@JsonbCreator
	public static DetalhamentoNormativo of(@JsonbProperty("conteudo") List<ExibeNormativoBacen> conteudo) {
		return new DetalhamentoNormativo(conteudo); 
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
