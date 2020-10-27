package com.github.ammirante.tcc.site.dto;

import com.github.ammirante.tcc.site.infra.DTO;

/**
 * AutenticacaoDTO
 *
 */
public class AutenticacaoDTO implements DTO {

	public String token;
	public String nomeUsuario;
	public String email;
	
	/**
	 * @param token
	 * @param nomeUsuario
	 * @param email
	 */
	public AutenticacaoDTO(String token, String nomeUsuario, String email) {
		this.token = token;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
	}
}
