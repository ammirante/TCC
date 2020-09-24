package com.github.ammirante.tcc.site.dto;

import java.io.Serializable;

import com.github.ammirante.tcc.site.util.ToString;


/**
 * Classe padrão para utilização de DTO.
 * 
 *	CadastroDTO
 */
public class CadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5099502895233855918L;

	/**
	 *
	 */
	public String toString() {
		return ToString.build(this);
	}
}
