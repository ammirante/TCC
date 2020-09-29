package com.github.ammirante.tcc.extracaobacen.extracao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * BacenExtracaoAPI
 *
 */
@ApplicationScoped
public class BacenExtracaoAPI {

	/**
	 * @param conteudo
	 * @return
	 * @throws IOException
	 */
	public RetornoBacen buscaNormativos(String conteudo) throws IOException {
		String urlFormatada = "https://www.bcb.gov.br/api/search/app/normativos/buscanormativos?rowlimit=9999&startrow=0&querytext=ContentType:normativo%20AND%20contentSource:normativos%20AND%20" + URLEncoder.encode(conteudo, StandardCharsets.UTF_8);
		URL url = new URL(urlFormatada);
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	connection.setRequestProperty("accept", "application/json");
    	InputStream responseStream = connection.getInputStream();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	return mapper.readValue(responseStream, RetornoBacen.class);
	}
	
	/**
	 * @param p1
	 * @param p2
	 * @return
	 * @throws IOException
	 */
	public DetalhamentoNormativo exibeNormativo(String p1, Integer p2) throws IOException {
		String urlFormatada = "https://www.bcb.gov.br/api/conteudo/app/normativos/exibenormativo?p1=" + URLEncoder.encode(p1, StandardCharsets.UTF_8) + "&p2=" + p2;
		URL url = new URL(urlFormatada);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	connection.setRequestProperty("accept", "application/json");
    	InputStream responseStream = connection.getInputStream();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	return mapper.readValue(responseStream, DetalhamentoNormativo.class);
	}
	
	/**
	 * @param p1
	 * @param p2
	 * @return
	 * @throws IOException
	 */
	public DetalhamentoOutrosNormativos recuperarOutrasNormas(String p1, Integer p2) throws IOException {
		String urlFormatada = "https://www.bcb.gov.br/api/conteudo/app/normativos/exibeoutrasnormas?p1=" + URLEncoder.encode(p1, StandardCharsets.UTF_8) + "&p2=" + p2;
		URL url = new URL(urlFormatada);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	connection.setRequestProperty("accept", "application/json");
    	InputStream responseStream = connection.getInputStream();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	return mapper.readValue(responseStream, DetalhamentoOutrosNormativos.class);
	}
	
	
}
