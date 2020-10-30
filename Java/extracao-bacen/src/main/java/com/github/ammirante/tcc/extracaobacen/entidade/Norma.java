package com.github.ammirante.tcc.extracaobacen.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

/**
 * 
 * Norma
 *
 */
@Entity
@Table(name = "norma")
public class Norma extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_norma")
	public Long codigoNorma;
	
	@Column(name = "num_norm", nullable = false, updatable = false)
	public Integer numeroNorma;
	
	@Column(name = "ts_dc", nullable = false)
	public Date dataDocumento;
	
	@Lob
	@Column(name = "tx_asst", nullable = false)
	public String assunto;
	
	@Lob
	@Column(name = "tx_tx", nullable = false)
	public String texto;
	
	@Column(name = "tx_resp")
	public String responsavel;
	
	@Column(name = "tx_dou")
	public String diarioOficialUniao;
	
	@Lob
	@Column(name = "tx_ref")
	public String referencia;
	
	@Lob
	@Column(name = "tx_att")
	public String atualizacoes;
	
	@OneToOne(cascade = CascadeType.ALL)
	public DominioNorma dominioNorma;
	
	@Lob
	@Column(name = "tx_norm_vinc")
	public String normasVinculadas;
	
	@OneToOne(cascade = CascadeType.ALL)
	public DominioConteudo dominioConteudo;
	
	/**
	 * Método responsável por retornar uma norma pelo número.
	 * @param numeroNorma
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByNumeroNorma(BigDecimal numeroNorma) {
		return Norma.find("numeroNorma = :numeroNorma", Parameters.with("numeroNorma", numeroNorma.intValue()).map());
	}
	
	/**
	 * Método responsável por retornar os normativos de acordo com o Domínio Conteúdo.
	 * 
	 * @param conteudo
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByDominioConteudo(String conteudo) {
		return Norma.find("UPPER(dominioConteudo.nome) = UPPER(:conteudo)", Parameters.with("conteudo", conteudo).map());
	}
}
