package com.github.ammirante.tcc.extracaobacen.servico.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.dto.AdicionarDominioNormaDTO;
import com.github.ammirante.tcc.extracaobacen.dto.DominioNormaMapper;
import com.github.ammirante.tcc.extracaobacen.entidade.DominioNorma;
import com.github.ammirante.tcc.extracaobacen.servico.DominioTipoNormaService;

/**
 * DominioTipoNormaServiceImpl
 *
 */
@ApplicationScoped
public class DominioTipoNormaServiceImpl implements DominioTipoNormaService {
	
	@Inject
	DominioNormaMapper dominioNormaMapper;
	
	private static final Logger LOGGER = Logger.getLogger(DominioTipoNormaServiceImpl.class);

	/** (non-Javadoc)
	 * Método responsável por persistir os tipos de normativos que existem.
	 * 
	 * @see com.github.ammirante.tcc.extracaobacen.servico.DominioTipoNormaService#persistir(java.lang.String)
	*/
	@Override
	@Transactional
	public void persistir(String tipoNorma) {
		LOGGER.debug("Iniciando a persistência da norma: " + tipoNorma);
		DominioNorma dominioNorma = DominioNorma.findByNomeIgnoreCase(tipoNorma).firstResult();
		Long qtdRegistros = DominioNorma.count();
		Long codigoTipoNorma = qtdRegistros > 0 ? qtdRegistros + 1 : 1L;
		
		if(dominioNorma == null) {
			AdicionarDominioNormaDTO adicionarDominioNormaDTO = new AdicionarDominioNormaDTO();
			adicionarDominioNormaDTO.codigoTipoNorma = codigoTipoNorma;
			adicionarDominioNormaDTO.nome = tipoNorma;
			dominioNorma = dominioNormaMapper.toDominioNorma(adicionarDominioNormaDTO);
			dominioNorma.persist();
		}
		LOGGER.debug("Fim a persistência da norma: " + dominioNorma.toString());
	}

}
