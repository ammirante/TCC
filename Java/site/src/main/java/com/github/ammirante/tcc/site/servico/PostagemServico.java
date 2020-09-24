package com.github.ammirante.tcc.site.servico;

import com.github.ammirante.tcc.site.dto.AdicionarPostagemDTO;

/**
 * PostagemServico
 *
 */
public interface PostagemServico {

	/**
	 * @param adicionarPostagemDTO
	 */
	void cadastrarPostagem(AdicionarPostagemDTO adicionarPostagemDTO);
	
}
