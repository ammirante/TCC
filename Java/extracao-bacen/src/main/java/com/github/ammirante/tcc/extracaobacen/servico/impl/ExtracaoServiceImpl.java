package com.github.ammirante.tcc.extracaobacen.servico.impl;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.extracao.BacenExtracaoAPI;
import com.github.ammirante.tcc.extracaobacen.extracao.Normativo;
import com.github.ammirante.tcc.extracaobacen.extracao.RetornoBacen;
import com.github.ammirante.tcc.extracaobacen.servico.DominioTipoNormaService;
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService;
import com.github.ammirante.tcc.extracaobacen.servico.NormativoService;

import io.quarkus.scheduler.Scheduled;

/**
 * ExtracaoServiceImpl
 *
 */
@ApplicationScoped
public class ExtracaoServiceImpl implements ExtracaoService {

	private static final Logger LOGGER = Logger.getLogger(ExtracaoServiceImpl.class);
	
	@Inject
	BacenExtracaoAPI bacenExtracaoAPI;
	
	@Inject
	DominioTipoNormaService dominioTipoNormaService;
	
	@Inject
	NormativoService normativoService;
	
	/**
	 * @throws IOException
	 */
	/*@Scheduled(every="10s")
	void recuperarNormaSchedule() throws IOException {
		this.extrairNormas("");
	}*/
	
	/** (non-Javadoc)
	 * @throws IOException 
	 * @see com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService#extrairNormas(java.lang.String)
	*/
	@Override
	@Transactional
	public void extrairNormas(String conteudo) throws IOException {
		LOGGER.info("Iniciando a extração das normas");
		long tempoInicialExtracao = System.currentTimeMillis();
    	RetornoBacen retornoBacen = bacenExtracaoAPI.buscaNormativos(conteudo);
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
