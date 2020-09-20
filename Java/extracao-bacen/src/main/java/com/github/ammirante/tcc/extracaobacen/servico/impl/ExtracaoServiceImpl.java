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
import com.github.ammirante.tcc.extracaobacen.servico.NormativoService;

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
	
	@Inject
	NormativoService normativoService;
	
	/** (non-Javadoc)
	*  @see com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService#extrairNormas(java.lang.String)
	*/
	@Override
	@Transactional
	public void extrairNormas(String conteudo) {
		LOGGER.info("Iniciando a extração das normas");
		long tempoInicialExtracao = System.currentTimeMillis();
		RetornoBacen retornoBacen = bacenExtracaoAPI.buscaNormativos("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");
		long tempoFinalExtracao = System.currentTimeMillis();
		LOGGER.info("Extração das normas finalizada. Tempo da extração em milisegundos: " + (tempoFinalExtracao - tempoInicialExtracao));

		LOGGER.info("Iniciando procedimento para persistências das normas e seus respectivos domínios.");
		long tempoInicialPersistencia = System.currentTimeMillis();
		for(Normativo normativo : retornoBacen.getRows()) {
			dominioTipoNormaService.persistir(normativo.getTipoNormativo());
			normativoService.persistirResumoNormativo(normativo);
		}
		long tempoFinalPersistencia = System.currentTimeMillis();
		LOGGER.info("Finalizado o procedimento para persistência das normas e seus respectivos domínios. Tempo da persistência: " + (tempoFinalPersistencia - tempoInicialPersistencia));
	}
}
