package com.github.ammirante.tcc.extracaobacen.servico.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.extracao.BacenExtracaoAPI;
import com.github.ammirante.tcc.extracaobacen.extracao.Normativo;
import com.github.ammirante.tcc.extracaobacen.extracao.RetornoBacen;
import com.github.ammirante.tcc.extracaobacen.servico.DominioTipoNormaService;
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService;

/**
 * ExtracaoServiceImpl
 *
 */
@ApplicationScoped
public class ExtracaoServiceImpl implements ExtracaoService {

	private static final Logger LOGGER = Logger.getLogger(ExtracaoServiceImpl.class);
	
	@RestClient
	@Inject
	BacenExtracaoAPI bacenExtracaoAPI;
	
	@Inject
	DominioTipoNormaService dominioTipoNormaService;
	
	/** (non-Javadoc)
	*  @see com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService#extrairNormas(java.lang.String)
	*/
	@Override
	@Transactional
	public void extrairNormas(String conteudo) {
		RetornoBacen retornoBacen = bacenExtracaoAPI.getNormativos("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");

		for(Normativo normativo : retornoBacen.getRows()) {
			dominioTipoNormaService.persistir(normativo.getTipoNormativo());
		}
		
		LOGGER.info(retornoBacen.toString());
	}
}
