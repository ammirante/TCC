package com.github.ammirante.tcc.extracaobacen.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ammirante.tcc.extracaobacen.dto.NormaDTO;
import com.github.ammirante.tcc.extracaobacen.dto.NormaMapper;
import com.github.ammirante.tcc.extracaobacen.entidade.Norma;
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService;

/**
 * NormativoResource
 *
 */
@Path("/normativos")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "normativo")
@ApplicationScoped
public class NormativoResource {
	
	@Inject
	ExtracaoService extracaoServico;
	
	@Inject
	NormaMapper normaMapper;
	
    /**
     * @param conteudo
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    @GET
    @Transactional
    public List<NormaDTO> recuperarNormativos(@QueryParam("conteudo") String conteudo) throws URISyntaxException, IOException {
    	Stream<Norma> normas = Norma.streamAll();
    	
    	return normas.map(norma -> normaMapper.toNormaDTO(norma)).collect(Collectors.toList());
    }
    
}