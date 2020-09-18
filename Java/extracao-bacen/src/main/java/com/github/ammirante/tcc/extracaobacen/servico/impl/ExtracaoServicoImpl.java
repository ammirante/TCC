package com.github.ammirante.tcc.extracaobacen.servico.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.extracao.BacenExtracaoAPI;
import com.github.ammirante.tcc.extracaobacen.extracao.RetornoBacen;
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoServico;

/**
 * ExtracaoServicoImpl
 *
 */
@ApplicationScoped
public class ExtracaoServicoImpl implements ExtracaoServico {

	private static final Logger LOGGER = Logger.getLogger(ExtracaoServico.class);
	
	@RestClient
	@Inject
	BacenExtracaoAPI bacenExtracaoAPI;
	
	/**
	 *
	 */
	@Override
	public void teste() {
		System.out.println("Douglas");
		LOGGER.info("teste");
		
		RetornoBacen retornoBance = bacenExtracaoAPI.getNormativos("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");
		LOGGER.info(retornoBance.toString());
	}

}
