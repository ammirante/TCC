package com.github.ammirante.tcc.site.resource;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.github.ammirante.tcc.site.dto.AdicionarPessoaDTO;
import com.github.ammirante.tcc.site.dto.PessoaMapper;
import com.github.ammirante.tcc.site.entidade.Pessoa;
import com.github.ammirante.tcc.site.infra.ConstraintViolationResponse;
import com.github.ammirante.tcc.site.security.TokenService;
import com.github.ammirante.tcc.site.util.RandomString;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

/**
 * UsuarioResource
 *
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	@Inject
	TokenService tokenService;
	
	@Inject
	PessoaMapper pessoaMapper;
	
	@Inject
	Mailer mailer;
	
	/**
	 * @param adicionarPessoaDTO
	 * @return
	 */
	@POST
	@Path("cadastrar")
	@Transactional
	@APIResponse(responseCode = "201", description = "Pessoa cadastrada com suecsso.")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
	public Pessoa cadastrar(AdicionarPessoaDTO adicionarPessoaDTO) {
		Pessoa pessoa = pessoaMapper.toPessoa(adicionarPessoaDTO);
		pessoa.persist();
		return pessoa;
	}
	
    /**
     * @param login
     * @param senha
     * @return
     */
    @GET
    @Path("/login")
    public String login(@QueryParam("login")String login, @QueryParam("senha") String senha) {
        Pessoa pessoa = Pessoa.find("nomeUsuario", login).firstResult();
        if(pessoa == null || !pessoa.senha.equals(senha)) {
            throw new WebApplicationException(Response.status(404).entity("Usuário ou senha inválido.").build());
        }
        return tokenService.generateAdminToken(pessoa.email, senha);
    }
    
    @PUT
    @Path("/recuperar-senha")
    @Transactional
    public Response recuperarSenha(@QueryParam("login")String login, @QueryParam("email")String email) {
    	Pessoa pessoa = Pessoa.find("nomeUsuario", login).firstResult();
    	
    	if(pessoa == null || !pessoa.email.equals(email)) {
    		throw new WebApplicationException(Response.status(404).entity("Usuário ou e-mail não encontrados na base.").build());
    	}
    	
    	RandomString randomString = new RandomString(8, ThreadLocalRandom.current());
    	String novaSenha = randomString.nextString();
    	pessoa.senha = novaSenha;
    	pessoa.persist();
    	mailer.send(Mail.withText(email, "Nova senha - Blog Open Banking", "Sua nova senha é: " + novaSenha));
    	
    	return Response.status(Status.OK).build();
    }

}
