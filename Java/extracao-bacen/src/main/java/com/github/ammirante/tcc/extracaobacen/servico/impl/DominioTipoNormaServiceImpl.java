package com.github.ammirante.tcc.extracaobacen.servico.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
	public void persistir(String tipoNorma) {
		LOGGER.info("Iniciando a persistência do domínio: " + tipoNorma);
		DominioNorma dominioNorma = DominioNorma.findByNomeIgnoreCase(tipoNorma).firstResult();
		Long qtdRegistros = DominioNorma.count();
		Long codigoTipoNorma = qtdRegistros > 0 ? qtdRegistros + 1 : 1L;
		
		if(dominioNorma == null) {
			AdicionarDominioNormaDTO adicionarDominioNormaDTO = new AdicionarDominioNormaDTO();
			adicionarDominioNormaDTO.codigoTipoNorma = codigoTipoNorma;
			adicionarDominioNormaDTO.nome = tipoNorma;
			dominioNorma = dominioNormaMapper.toDominioNorma(adicionarDominioNormaDTO);
			dominioNorma.persistAndFlush();
			LOGGER.info("Fim a persistência do domínio: " + adicionarDominioNormaDTO.toString());
		} else {
			LOGGER.info("Domínio já cadastrado no banco.");
		}
	}

}
