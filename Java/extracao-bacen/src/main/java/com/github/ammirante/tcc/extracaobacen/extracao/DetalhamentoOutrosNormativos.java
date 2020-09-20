package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * DetalhamentoOutrosNormativos
 *
 */
public class DetalhamentoOutrosNormativos {

	private List<ExibeOutrosNormativosBacen> conteudo;
	
	/**
	 * 
	 */
	/**
	 * @param conteudo
	 */
	public DetalhamentoOutrosNormativos(List<ExibeOutrosNormativosBacen> conteudo) {
		this.conteudo = conteudo;
	}
	
	/**
	 * @param conteudo
	 * @return
	 */
	@JsonbCreator
	public static DetalhamentoOutrosNormativos of(@JsonbProperty("conteudo") List<ExibeOutrosNormativosBacen> conteudo) {
		return new DetalhamentoOutrosNormativos(conteudo); 
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
