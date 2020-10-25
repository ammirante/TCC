package com.github.ammirante.tcc.site.servico.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.github.ammirante.tcc.site.dto.AdicionarPostagemDTO;
import com.github.ammirante.tcc.site.dto.DominioCategoriaMapper;
import com.github.ammirante.tcc.site.dto.PostagemMapper;
import com.github.ammirante.tcc.site.entidade.DominioCategoria;
import com.github.ammirante.tcc.site.entidade.DominioSituacao;
import com.github.ammirante.tcc.site.entidade.Pessoa;
import com.github.ammirante.tcc.site.entidade.Postagem;
import com.github.ammirante.tcc.site.servico.DominioCategoriaServico;
import com.github.ammirante.tcc.site.servico.PostagemServico;
import com.github.ammirante.tcc.site.util.Constantes;

/**
 * PostagemServicoImpl
 *
 */
@ApplicationScoped
public class PostagemServicoImpl implements PostagemServico {

	@Inject
	PostagemMapper postagemMapper;
	
	@Inject
	DominioCategoriaMapper dominioCategoriaMapper;
	
	@Inject
	DominioCategoriaServico dominioCategoriaServico;
	
	/** (non-Javadoc)
	*  @see com.github.ammirante.tcc.site.servico.PostagemServico#cadastrarPostagem(com.github.ammirante.tcc.site.dto.AdicionarPostagemDTO)
	*/
	@Override
	@Transactional
	public void cadastrarPostagem(AdicionarPostagemDTO adicionarPostagemDTO) {
		// Recuperando a Pessoa pelo nome de usuário.
		Pessoa pessoa = Pessoa.findByNomeUsuarioIgnoreCase(adicionarPostagemDTO.nomeUsuario).firstResult();
		
		List<DominioCategoria> lstDominioCategoria = new ArrayList<>(adicionarPostagemDTO.lstDominioCategoria.size());
		for(Integer codigoCategoria : adicionarPostagemDTO.lstDominioCategoria) {
			lstDominioCategoria.add(dominioCategoriaServico.recuperarDominioCategoria(codigoCategoria.longValue()));
		}
		
		// Atribuindo a situação de ativo para o registro.
		Postagem postagem = postagemMapper.toPostagem(adicionarPostagemDTO);
		postagem.pessoa = pessoa;
		postagem.lstCategorias = lstDominioCategoria;
		postagem.situacao = DominioSituacao.findByNomeIgnoreCase(Constantes.ATIVO).firstResult();
		
		postagem.persist();
	}

}
