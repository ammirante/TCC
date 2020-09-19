package com.github.ammirante.tcc.extracaobacen.servico.impl;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.extracao.Normativo;
import com.github.ammirante.tcc.extracaobacen.servico.NormativoService;

/**
 * NormativoServiceImpl
 *
 */
@ApplicationScoped
public class NormativoServiceImpl implements NormativoService {

	private static final Logger LOGGER = Logger.getLogger(NormativoServiceImpl.class);

	/** (non-Javadoc)
	 * Método responsável por persistir um normativo.
	 * @see com.github.ammirante.tcc.extracaobacen.servico.NormativoService#persistir(com.github.ammirante.tcc.extracaobacen.extracao.Normativo)
	*/
	@Override
	public void persistir(Normativo normativo) {
		
	}
	
}
