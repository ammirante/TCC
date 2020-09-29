package com.github.ammirante.tcc.extracaobacen.servico;

import java.io.IOException;

/**
 * ExtracaoService
 *
 */
public interface ExtracaoService {

	/**
	 * @param conteudo
	 * @throws IOException
	 */
	void extrairNormas(String conteudo) throws IOException;
	
}
