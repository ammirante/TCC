package com.github.ammirante.tcc.site.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * 
 * Postagem
 *
 */
@Entity
@Table(name = "postagem")
public class Postagem extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_post")
	public Long codigoPostagem;

	@Column(name = "tx_titu", nullable = false)
	public String titulo;

	@CreationTimestamp
	@Column(name = "ts_inic", nullable = false, updatable = false)
	public Date dataPostagem;

	@UpdateTimestamp
	@Column(name = "ts_fim")
	public Date dataAtualizacao;

	@Column(name = "tx_desc", nullable = false)
	public String descricaoTexto;

	@Column(name = "tx_ref_link_img_capa", nullable = false, length = 100)
	public String referenciaImagemCapa;

	@ManyToOne(cascade = CascadeType.ALL)
	public DominioSituacao situacao;

	@ManyToOne(cascade = CascadeType.ALL)
	public Pessoa pessoa;

	@JoinTable(name = "relacao_postagem_categoria", joinColumns = @JoinColumn(name = "cd_post"), inverseJoinColumns = @JoinColumn(name = "cd_cat"))
	@ManyToMany(cascade = CascadeType.ALL)
	public List<DominioCategoria> lstCategorias;
}
