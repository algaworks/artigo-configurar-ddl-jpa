package com.algaworks.artigo.jpa.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "produto", schema = "sistemaerp", 
		uniqueConstraints = { @UniqueConstraint(name = "produto_empresaid_nome_unique", 
												columnNames = { "empresa_id", "nome" }) },
		indexes = { @Index(name = "produto_nome_idx", columnList = "empresa_id, nome") })
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false, 
					foreignKey = @ForeignKey(name = "produto_empresa_fk"))
	private Empresa empresa;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria", schema = "sistemaerp",
				joinColumns = { @JoinColumn(name = "produto_id", 
					foreignKey = @ForeignKey(name = "produtocategoria_produto_fk")) },
				inverseJoinColumns = { @JoinColumn(name = "categoria_id", 
					foreignKey = @ForeignKey(name = "produtocategoria_categoria_fk")) })	
	private Collection<Categoria> categorias;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Collection<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(Collection<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
