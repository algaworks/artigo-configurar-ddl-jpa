package com.algaworks.artigo.jpa.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cliente", schema = "sistemaerp", 
		uniqueConstraints = { @UniqueConstraint(name = "cliente_empresaid_cpf_unique", 
												columnNames = { "empresa_id", "cpf" }) })
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false, 
					foreignKey = @ForeignKey(name = "cliente_empresa_fk"))
	private Empresa empresa;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false) 
	private String cpf;
	
	@Column(name = "numero", length = 20, nullable = false)
	@ElementCollection
	@CollectionTable(name = "cliente_telefone", schema = "sistemaerp", 
						joinColumns = { @JoinColumn(name = "cliente_id", 
													foreignKey = @ForeignKey(name = "clientetelefone_cliente_fk")) })
	private Collection<String> telefones;
	
	@ElementCollection
	@CollectionTable(name = "cliente_endereco", schema = "sistemaerp", 
						joinColumns = { @JoinColumn(name = "cliente_id", 
													foreignKey = @ForeignKey(name = "clienteendereco_cliente_fk")) })
	private Collection<Endereco> enderecos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Collection<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
