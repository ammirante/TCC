package com.github.ammirante.tcc.extracaobacen.servico.impl;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.github.ammirante.tcc.extracaobacen.dto.AdicionarNormaDTO;
import com.github.ammirante.tcc.extracaobacen.dto.NormaMapper;
import com.github.ammirante.tcc.extracaobacen.entidade.DominioNorma;
import com.github.ammirante.tcc.extracaobacen.entidade.Norma;
import com.github.ammirante.tcc.extracaobacen.extracao.BacenExtracaoAPI;
import com.github.ammirante.tcc.extracaobacen.extracao.DetalhamentoNormativo;
import com.github.ammirante.tcc.extracaobacen.extracao.DetalhamentoOutrosNormativos;
import com.github.ammirante.tcc.extracaobacen.extracao.ExibeNormativoBacen;
import com.github.ammirante.tcc.extracaobacen.extracao.ExibeOutrosNormativosBacen;
import com.github.ammirante.tcc.extracaobacen.extracao.Normativo;
import com.github.ammirante.tcc.extracaobacen.servico.NormativoService;
import com.github.ammirante.tcc.extracaobacen.util.DominioNormaEnum;

/**
 * NormativoServiceImpl
 *
 */
@ApplicationScoped
public class NormativoServiceImpl implements NormativoService {

	private static final Logger LOGGER = Logger.getLogger(NormativoServiceImpl.class);

	@Inject
	NormaMapper normaMapper;
	
	@Inject
	BacenExtracaoAPI bacenExtracaoAPI;
	
	/** (non-Javadoc)
	 * Método responsável por persistir um normativo.
	 * @throws IOException 
	 * 
	 * @see com.github.ammirante.tcc.extracaobacen.servico.NormativoService#persistirResumoNormativo(com.github.ammirante.tcc.extracaobacen.extracao.Normativo)
	*/
	@Override
	public void persistirResumoNormativo(Normativo normativo) throws IOException {
		LOGGER.info("Iniciando a persistência da norma: " + normativo.toString());
		Norma norma = Norma.findByNumeroNorma(normativo.getNumeroNormativo()).firstResult();
		
		if(norma == null) {
			AdicionarNormaDTO adicionarNormaDTO = new AdicionarNormaDTO();
			adicionarNormaDTO.assunto = extrairAssunto(normativo.getAssuntoNormativo());
			adicionarNormaDTO.dataDocumento = normativo.getData();
			adicionarNormaDTO.numeroNorma = normativo.getNumeroNormativo().intValue();
			adicionarNormaDTO.dominioNorma = DominioNorma.findByNomeIgnoreCase(normativo.getTipoNormativo()).firstResult();
			adicionarNormaDTO.responsavel = normativo.getResponsavel();
			
			// Recuperando os detalhes no normativo e preenchendo as informações faltantes.
			recuperaDetalhesNormativo(adicionarNormaDTO);
			
			norma = normaMapper.toNorma(adicionarNormaDTO);
			norma.persist();
			LOGGER.info("Normativo persistido.");
		}
		
		LOGGER.info("Fim da persistência da norma: " + normativo.toString());
	}
	
	/**
	 * Método responsável por requisitar os detalhes do normativo e preencher as informações faltantes.
	 * @param adicionarNormaDTO
	 * @throws IOException 
	 */
	private void recuperaDetalhesNormativo(AdicionarNormaDTO adicionarNormaDTO) throws IOException {
		if(adicionarNormaDTO.dominioNorma.nome.equals(DominioNormaEnum.COMUNICADO.getNomeNorma())) {
			DetalhamentoOutrosNormativos detalhamentoOutrosNormativos = bacenExtracaoAPI.recuperarOutrasNormas(adicionarNormaDTO.dominioNorma.nome, adicionarNormaDTO.numeroNorma);
			ExibeOutrosNormativosBacen exibeOutrosNormativosBacen = detalhamentoOutrosNormativos.getConteudo().get(0);
			adicionarNormaDTO.texto = exibeOutrosNormativosBacen.getTexto();
			adicionarNormaDTO.diarioOficialUniao = exibeOutrosNormativosBacen.getDiarioOficialUniao();
		} else {
			DetalhamentoNormativo detalhamentoNormativo = bacenExtracaoAPI.exibeNormativo(adicionarNormaDTO.dominioNorma.nome, adicionarNormaDTO.numeroNorma);
			ExibeNormativoBacen exibeNormativoBacen = detalhamentoNormativo.getConteudo().get(0);
			adicionarNormaDTO.diarioOficialUniao = exibeNormativoBacen.getDiarioOficialUniao();
			adicionarNormaDTO.texto = exibeNormativoBacen.getTexto();
			adicionarNormaDTO.referencia = exibeNormativoBacen.getReferencias();
			adicionarNormaDTO.normasVinculadas = exibeNormativoBacen.getNormasVinculadas();
		}
	}
	
	/**
	 * Método responsável por formatar o assunto do normativo.
	 * @param assuntoNaoFormatado
	 * @return
	 */
	private String extrairAssunto(String assuntoNaoFormatado) {
		Integer idxString = 0;
		Boolean isPrecisaFormatar = Boolean.FALSE;
		String assuntoFormatado = assuntoNaoFormatado;
		for(Character character : assuntoNaoFormatado.toCharArray()) {
			if(character.equals('>')) {
				isPrecisaFormatar = Boolean.TRUE;
				break;
			}
			idxString++;
		}
		
		if(isPrecisaFormatar) {
			assuntoFormatado = assuntoNaoFormatado.substring(idxString + 1, assuntoNaoFormatado.length() - 6); 
		}
		
		return assuntoFormatado;
	}
	
}
