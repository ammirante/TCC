package com.github.ammirante.tcc.extracaobacen.dto;

import java.io.Serializable;

import com.github.ammirante.tcc.extracaobacen.util.ToString;


/**
 * Classe padrão para utilização de DTO.
 *
 */
public class CadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2055796904694797729L;

	/**
	 *
	 */
	public String toString() {
		return ToString.build(this);
	}
}
