package com.github.ammirante.tcc.extracaobacen.util;

/**
 * DominioNormaEnum
 *
 */
public enum DominioNormaEnum {

	COMUNICADO("Comunicado"),
	CIRCULAR("Circular"),
	RESOLUCAO_CONJUNTA("Resolução Conjunta");
	
	private String nomeNorma;
	
	/**
	 * @param nomeNorma
	 */
	private DominioNormaEnum(String nomeNorma) {
		this.nomeNorma = nomeNorma;
	}
	
	/**
	 * @return
	 */
	public String getNomeNorma() {
		return this.nomeNorma;
	}
}
