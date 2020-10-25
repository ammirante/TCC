package com.github.ammirante.tcc.site.servico.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.github.ammirante.tcc.site.entidade.DominioCategoria;
import com.github.ammirante.tcc.site.servico.DominioCategoriaServico;

/**
 * DominioCategoriaServicoImpl
 *
 */
@ApplicationScoped
public class DominioCategoriaServicoImpl implements DominioCategoriaServico {

	/** (non-Javadoc)
	*  @see com.github.ammirante.tcc.site.servico.DominioCategoriaServico#recuperarDominiosCategoria(java.util.List)
	*/
	@Override
	public List<DominioCategoria> recuperarDominiosCategoria(List<String> nomes) {
		List<DominioCategoria> lstDominiosCategorias = DominioCategoria.listAll();
		
		List<DominioCategoria> lstDominiosSelecionados = new ArrayList<>(nomes.size());
		for(String nome : nomes) {
			lstDominiosCategorias.stream().forEach(dominio -> {
				if(dominio.nome.equals(nome)) {
					lstDominiosSelecionados.add(dominio);
				}
			});
		}
		
		return lstDominiosSelecionados;
	}

	/** (non-Javadoc)
	*  @see com.github.ammirante.tcc.site.servico.DominioCategoriaServico#recuperarDominioCategoria(java.lang.Integer)
	*/
	@Override
	public DominioCategoria recuperarDominioCategoria(Long codigoCategoria) {
		return DominioCategoria.findById(codigoCategoria);
	}

}
