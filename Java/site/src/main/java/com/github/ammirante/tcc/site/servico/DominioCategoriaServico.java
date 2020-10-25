package com.github.ammirante.tcc.site.servico;

import java.util.List;

import com.github.ammirante.tcc.site.entidade.DominioCategoria;

/**
 * DominioCategoriaServico
 *
 */
public interface DominioCategoriaServico {

	/**
	 * @param nomes
	 */
	List<DominioCategoria> recuperarDominiosCategoria(List<String> nomes);
	
	/**
	 * @param codigoCategoria
	 * @return
	 */
	DominioCategoria recuperarDominioCategoria(Long codigoCategoria);
	
}
