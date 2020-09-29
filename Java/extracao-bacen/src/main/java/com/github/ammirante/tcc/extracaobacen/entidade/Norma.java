package com.github.ammirante.tcc.extracaobacen.entidade;

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
}
