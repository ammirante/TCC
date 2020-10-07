package com.github.ammirante.tcc.extracaobacen.servico;

import java.io.IOException;
import java.util.List;

import com.github.ammirante.tcc.extracaobacen.entidade.Norma;

/**
 * ExtracaoService
 *
 */
public interface ExtracaoService {

	/**
	 * @param conteudo
	 * @return
	 * @throws IOException
	 */
	List<Norma> extrairNormas(String conteudo) throws IOException;
	
}
