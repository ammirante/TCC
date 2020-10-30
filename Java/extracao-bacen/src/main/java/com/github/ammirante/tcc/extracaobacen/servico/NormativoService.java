package com.github.ammirante.tcc.extracaobacen.servico;

import java.io.IOException;

import com.github.ammirante.tcc.extracaobacen.extracao.Normativo;

/**
 * NormativoService
 *
 */
public interface NormativoService {

	/**
	 * @param normativo
	 * @param conteudo
	 * @throws IOException
	 */
	void persistirResumoNormativo(Normativo normativo, String conteudo) throws IOException;
	
}
