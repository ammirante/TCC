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
	 * @throws IOException
	 */
	void persistirResumoNormativo(Normativo normativo) throws IOException;
	
}
