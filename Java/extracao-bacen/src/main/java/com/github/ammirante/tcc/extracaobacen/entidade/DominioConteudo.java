package com.github.ammirante.tcc.extracaobacen.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

/**
 * 
 * DominioConteudo
 *
 */
@Entity
@Table(name = "dominio_conteudo")
public class DominioConteudo extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_tipo_cont")
	public Long codigoTipoCont;
	
	@Column(name = "tx_nome", nullable = false)
	public String nome;
	
	/**
	 * Método responsável por recuperar um Domínio de conteúdo pelo nome.
	 * @param nomeUsuario
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByNomeIgnoreCase(String nome) {
		return DominioConteudo.find("UPPER(nome) = UPPER(:nome)", Parameters.with("nome", nome).map());
	}
}
